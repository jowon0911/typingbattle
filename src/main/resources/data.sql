INSERT INTO snippet (language, content) VALUES ('Java',
                                                'for (int i = 1; i <= 10; i++) {
                                                    if (i % 2 == 0) {
                                                        System.out.println(i + " is even");
                                                    }
                                                }');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'public int sum(int[] numbers) {
                                                    int total = 0;
                                                    for (int n : numbers) {
                                                        total += n;
                                                    }
                                                    return total;
                                                }');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'int count = 0;
                                                while (count < 5) {
                                                    count++;
                                                }
                                                System.out.println("count = " + count);');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'int max = numbers[0];
                                                for (int i = 1; i < numbers.length; i++) {
                                                    if (numbers[i] > max) {
                                                        max = numbers[i];
                                                    }
                                                }');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'if (score >= 90) {
                                                    grade = "A";
                                                } else if (score >= 80) {
                                                    grade = "B";
                                                } else {
                                                    grade = "C";
                                                }');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'switch (day) {
                                                    case 1:
                                                        System.out.println("Monday");
                                                        break;
                                                    default:
                                                        System.out.println("Other day");
                                                }');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'String word = "hello";
                                                String reversed = "";
                                                for (int i = word.length() - 1; i >= 0; i--) {
                                                    reversed += word.charAt(i);
                                                }
                                                System.out.println(reversed);');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'int[][] board = new int[3][3];
                                                for (int r = 0; r < 3; r++) {
                                                    for (int c = 0; c < 3; c++) {
                                                        board[r][c] = r * 3 + c;
                                                    }
                                                }');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'for (int i = 0; i < arr.length - 1; i++) {
                                                    for (int j = 0; j < arr.length - 1 - i; j++) {
                                                        if (arr[j] > arr[j + 1]) {
                                                            int temp = arr[j];
                                                            arr[j] = arr[j + 1];
                                                            arr[j + 1] = temp;
                                                        }
                                                    }
                                                }');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'public int factorial(int n) {
                                                    if (n <= 1) {
                                                        return 1;
                                                    }
                                                    return n * factorial(n - 1);
                                                }');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'List<String> names = new ArrayList<>();
                                                names.add("Kim");
                                                names.add("Lee");
                                                for (String name : names) {
                                                    System.out.println(name);
                                                }');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'Map<String, Integer> scores = new HashMap<>();
                                                scores.put("math", 90);
                                                scores.put("english", 85);
                                                int math = scores.get("math");
                                                System.out.println("math: " + math);');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'StringBuilder sb = new StringBuilder();
                                                for (int i = 1; i <= 5; i++) {
                                                    sb.append(i).append(" ");
                                                }
                                                System.out.println(sb.toString().trim());');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'Scanner sc = new Scanner(System.in);
                                                int a = sc.nextInt();
                                                int b = sc.nextInt();
                                                System.out.println(a + b);
                                                sc.close();');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'try {
                                                    int result = 10 / 0;
                                                } catch (ArithmeticException e) {
                                                    System.out.println("cannot divide by zero");
                                                } finally {
                                                    System.out.println("done");
                                                }');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'public class Player {
                                                    private String name;

                                                    public Player(String name) {
                                                        this.name = name;
                                                    }
                                                }');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'private int score;

                                                public int getScore() {
                                                    return score;
                                                }

                                                public void setScore(int score) {
                                                    this.score = score;
                                                }');

INSERT INTO snippet (language, content) VALUES ('Java',
                                                'public interface Animal {
                                                    void sound();
                                                }

                                                public class Dog implements Animal {
                                                    public void sound() {
                                                        System.out.println("Woof");
                                                    }
                                                }');


INSERT INTO snippet (language, content) VALUES ('Spring',
                                                '@GetMapping("/hello")
                                                public String hello(Model model) {
                                                    model.addAttribute("name", "world");
                                                    return "hello";
                                                }');

INSERT INTO snippet (language, content) VALUES ('Spring',
                                                '@PostMapping("/members")
                                                public String join(@RequestParam String name) {
                                                    memberService.join(name);
                                                    return "redirect:/members";
                                                }');

INSERT INTO snippet (language, content) VALUES ('Spring',
                                                '@Service
                                                public class MemberService {
                                                    private final MemberRepository memberRepository;

                                                    public MemberService(MemberRepository memberRepository) {
                                                        this.memberRepository = memberRepository;
                                                    }
                                                }');

INSERT INTO snippet (language, content) VALUES ('Spring',
                                                'public interface MemberRepository extends JpaRepository<Member, Long> {
                                                    List<Member> findByName(String name);
                                                    boolean existsByEmail(String email);
                                                }');


INSERT INTO snippet (language, content) VALUES ('Python',
                                                'numbers = [3, 1, 4, 1, 5]
                                                total = 0
                                                for n in numbers:
                                                    total += n
                                                print("total:", total)');

INSERT INTO snippet (language, content) VALUES ('Python',
                                                'def is_even(n):
                                                    return n % 2 == 0

                                                for i in range(1, 6):
                                                    if is_even(i):
                                                        print(i, "is even")');

INSERT INTO snippet (language, content) VALUES ('Python',
                                                'scores = {"kim": 90, "lee": 85}
                                                for name, score in scores.items():
                                                    if score >= 90:
                                                        print(name, "A")
                                                    else:
                                                        print(name, "B")');


INSERT INTO snippet (language, content) VALUES ('JavaScript',
                                                'const button = document.getElementById("start");
                                                button.addEventListener("click", function () {
                                                    alert("Game start!");
                                                });');

INSERT INTO snippet (language, content) VALUES ('JavaScript',
                                                'const fruits = ["apple", "banana", "cherry"];
                                                for (let i = 0; i < fruits.length; i++) {
                                                    console.log(i + ": " + fruits[i]);
                                                }');

INSERT INTO snippet (language, content) VALUES ('JavaScript',
                                                'function add(a, b) {
                                                    return a + b;
                                                }

                                                const result = add(2, 3);
                                                console.log("result = " + result);');


INSERT INTO snippet (language, content) VALUES ('SQL',
                                                'SELECT name, score
                                                FROM student
                                                WHERE score >= 80
                                                ORDER BY score DESC;');

INSERT INTO snippet (language, content) VALUES ('SQL',
                                                'CREATE TABLE member (
                                                    id INT PRIMARY KEY,
                                                    name VARCHAR(20) NOT NULL,
                                                    email VARCHAR(50)
                                                );');