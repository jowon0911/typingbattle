let text = "";
let spans = [];
let position = 0;
let correctCount = 0;
let errorCount = 0;
let hasError = false;
let startTime = 0;
let endTime = 0;
let canType = true;


function setupCode(codeElement) {
    text = codeElement.textContent.replace(/\r\n/g, "\n");
    codeElement.innerHTML = "";
    spans = [];

    for (let i = 0; i < text.length; i++) {
        const span = document.createElement("span");
        if (text[i] === "\n") {
            span.textContent = "↵\n";
            span.classList.add("newline");
        } else {
            span.textContent = text[i];
        }
        codeElement.appendChild(span);
        spans.push(span);
    }

    skipIndent();
    showCursor();
}

// 키보드를 누를 때마다 실행된다
document.addEventListener("keydown", function (event) {
    if (!canType) return;
    if (endTime !== 0) return;
    if (event.ctrlKey || event.altKey) return;

    if (event.key === "Process") {
        showImeWarning(true);
        return;
    }
    showImeWarning(false);

    let key = event.key;
    if (key === "Enter") key = "\n";
    if (key !== "Backspace" && key.length !== 1) return;

    event.preventDefault();

    if (startTime === 0) startTime = Date.now();

    if (key === "Backspace") {
        hasError = false;
    } else if (hasError) {
        return;
    } else if (key === text[position]) {
        spans[position].classList.add("done");
        position++;
        correctCount++;
        skipIndent();
    } else {
        hasError = true;
        errorCount++;
    }

    showCursor();
    updateScreen();

    if (position === text.length) {
        endTime = Date.now();
        gameFinished();
    }
});

function skipIndent() {
    if (position > 0 && text[position - 1] !== "\n") return;   // 줄의 시작이 아니면 그냥 둔다

    while (text[position] === " ") {
        spans[position].classList.add("done");
        position++;
    }
}

// 지금 쳐야 할 글자를 파란색으로 표시한다
// (오타 상태면 빨간색)
function showCursor() {
    for (let i = 0; i < spans.length; i++) {
        spans[i].classList.remove("current", "wrong");
    }
    if (position < spans.length) {
        if (hasError) {
            spans[position].classList.add("wrong");
        } else {
            spans[position].classList.add("current");
        }
    }
}

// 걸린 시간
function getElapsedMs() {
    if (startTime === 0) return 0;
    if (endTime !== 0) return endTime - startTime;
    return Date.now() - startTime;
}

// 타수: 1분 동안 맞게 친 글자 수
function getCpm() {
    const minutes = getElapsedMs() / 60000;
    if (minutes === 0) return 0;
    return Math.round(correctCount / minutes);
}

// 정확도: 전체 입력 중 맞게 친 비율
function getAccuracy() {
    const total = correctCount + errorCount;
    if (total === 0) return 100;
    return Math.round(correctCount / total * 100);
}

// 진행률: 전체 코드 중 몇 %까지 쳤는지
function getProgress() {
    return Math.floor(position / text.length * 100);
}