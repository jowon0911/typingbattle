package com.example.typingbattle.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.typingbattle.entity.Snippet;
import com.example.typingbattle.service.RankingService;

class RoomTest {

    private Room newRoom(boolean matched) {
        return new Room("1234", new Snippet("Java", "EASY", "int a = 1;"), "NORMAL", matched);
    }

    @Test
    void hostCanHandOverBeforeStart() {
        Room room = newRoom(false);
        room.addPlayer("A");
        room.addPlayer("B");

        assertFalse(room.changeHost("B", "A"));
        assertTrue(room.changeHost("A", "B"));
        assertEquals("B", room.getHost());
        assertEquals(List.of("B", "A"), room.getPlayers());
    }

    @Test
    void nextPlayerBecomesHostWhenHostLeaves() {
        Room room = newRoom(false);
        room.addPlayer("A");
        room.addPlayer("B");
        room.addPlayer("C");

        room.leave("A");

        assertEquals("B", room.getHost());
        assertEquals(List.of("B", "C"), room.getPlayers());
    }

    @Test
    void leavingDuringGameKeepsPlayerAsLeft() {
        Room room = newRoom(false);
        room.addPlayer("A");
        room.addPlayer("B");
        assertTrue(room.start());

        room.leave("B");

        assertEquals(List.of("A", "B"), room.getPlayers());
        assertEquals(List.of("B"), room.getLeftPlayers());
        assertFalse(room.isActivePlayer("B"));
        assertFalse(room.addPlayer("B"));
    }

    @Test
    void gameIsDoneWhenEveryoneElseLeft() {
        Room room = newRoom(false);
        room.addPlayer("A");
        room.addPlayer("B");
        room.start();

        room.leave("A");
        assertFalse(room.isAllDone());
        room.leave("B");
        assertTrue(room.isAllDone());
    }

    @Test
    void unfinishedPlayersAreLastInResults() {
        Room room = newRoom(false);
        room.addPlayer("A");
        room.addPlayer("B");
        room.addPlayer("C");
        room.start();
        room.leave("C");

        List<PlayerResult> results = room.end();

        assertEquals(3, results.size());
        for (PlayerResult result : results) {
            assertEquals(3, result.getRank());
            assertFalse(result.isFinished());
        }
        assertTrue(results.get(2).isLeft());
        assertNull(room.end());
    }

    @Test
    void cannotFinishDuringCountdown() {
        Room room = newRoom(false);
        room.addPlayer("A");
        room.addPlayer("B");
        room.start();

        assertNull(room.finish("A", 300, 100));
    }

    @Test
    void matchedRoomOnlyAcceptsReservedPlayers() {
        Room room = newRoom(true);
        room.reserve(List.of("A", "B"));

        assertFalse(room.addPlayer("C"));
        assertTrue(room.addPlayer("A"));
        assertFalse(room.isAllReservedJoined());
        assertTrue(room.addPlayer("B"));
        assertTrue(room.isAllReservedJoined());
        assertFalse(room.canStart("A"));
        assertFalse(room.changeHost("A", "B"));
    }

    @Test
    void scoreChangeDependsOnRank() {
        assertEquals(10, RankingService.calculateChange(2, 1));
        assertEquals(-10, RankingService.calculateChange(2, 2));
        assertEquals(30, RankingService.calculateChange(4, 1));
        assertEquals(10, RankingService.calculateChange(4, 2));
        assertEquals(-30, RankingService.calculateChange(4, 4));
    }
}
