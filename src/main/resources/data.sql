INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'for (int i = 1; i <= 10; i++) {
                                                                if (i % 2 == 0) {
                                                                    System.out.println(i + " is even");
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'int count = 0;
                                                            while (count < 5) {
                                                                count++;
                                                            }
                                                            System.out.println("count = " + count);');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'if (score >= 90) {
                                                                grade = "A";
                                                            } else if (score >= 80) {
                                                                grade = "B";
                                                            } else {
                                                                grade = "C";
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'Scanner sc = new Scanner(System.in);
                                                            int a = sc.nextInt();
                                                            int b = sc.nextInt();
                                                            System.out.println(a + b);
                                                            sc.close();');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'StringBuilder sb = new StringBuilder();
                                                            for (int i = 1; i <= 5; i++) {
                                                                sb.append(i).append(" ");
                                                            }
                                                            System.out.println(sb.toString().trim());');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'List<String> names = new ArrayList<>();
                                                            names.add("Kim");
                                                            names.add("Lee");
                                                            for (String name : names) {
                                                                System.out.println(name);
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'Map<String, Integer> scores = new HashMap<>();
                                                            scores.put("math", 90);
                                                            scores.put("english", 85);
                                                            int math = scores.get("math");
                                                            System.out.println("math: " + math);');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'switch (day) {
                                                                case 1:
                                                                    System.out.println("Monday");
                                                                    break;
                                                                default:
                                                                    System.out.println("Other day");
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'int[] arr = {5, 3, 8, 1};
                                                            int sum = 0;
                                                            for (int x : arr) {
                                                                sum += x;
                                                            }
                                                            System.out.println("sum = " + sum);');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'String name = "Java";
                                                            System.out.println(name.length());
                                                            System.out.println(name.toUpperCase());
                                                            System.out.println(name.charAt(0));');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'boolean isAdult = age >= 19;
                                                            if (isAdult) {
                                                                System.out.println("adult");
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'for (int i = 1; i <= 9; i++) {
                                                                System.out.println("2 x " + i + " = " + (2 * i));
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'double avg = (double) total / count;
                                                            System.out.printf("%.2f%n", avg);');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'EASY',
                                                            'int max = Math.max(a, b);
                                                            int min = Math.min(a, b);
                                                            System.out.println(max - min);');

INSERT INTO snippet (language, difficulty, content) VALUES ('Spring', 'EASY',
                                                            '@SpringBootApplication
                                                            public class DemoApplication {
                                                                public static void main(String[] args) {
                                                                    SpringApplication.run(DemoApplication.class, args);
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Python', 'EASY',
                                                            'numbers = [3, 1, 4, 1, 5]
                                                            total = 0
                                                            for n in numbers:
                                                                total += n
                                                            print("total:", total)');

INSERT INTO snippet (language, difficulty, content) VALUES ('Python', 'EASY',
                                                            'name = input("name: ")
                                                            print("Hello, " + name)');

INSERT INTO snippet (language, difficulty, content) VALUES ('Python', 'EASY',
                                                            'for i in range(5):
                                                                print(i * i)');

INSERT INTO snippet (language, difficulty, content) VALUES ('Python', 'EASY',
                                                            'fruits = ["apple", "banana"]
                                                            fruits.append("cherry")
                                                            print(len(fruits))');

INSERT INTO snippet (language, difficulty, content) VALUES ('Python', 'EASY',
                                                            'age = 17
                                                            if age >= 19:
                                                                print("adult")
                                                            else:
                                                                print("student")');

INSERT INTO snippet (language, difficulty, content) VALUES ('JavaScript', 'EASY',
                                                            'const fruits = ["apple", "banana", "cherry"];
                                                            for (let i = 0; i < fruits.length; i++) {
                                                                console.log(i + ": " + fruits[i]);
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('JavaScript', 'EASY',
                                                            'function add(a, b) {
                                                                return a + b;
                                                            }

                                                            const result = add(2, 3);
                                                            console.log("result = " + result);');

INSERT INTO snippet (language, difficulty, content) VALUES ('JavaScript', 'EASY',
                                                            'let count = 0;
                                                            count += 5;
                                                            console.log("count:", count);');

INSERT INTO snippet (language, difficulty, content) VALUES ('JavaScript', 'EASY',
                                                            'const user = { name: "Kim", age: 18 };
                                                            console.log(user.name);
                                                            console.log(user["age"]);');

INSERT INTO snippet (language, difficulty, content) VALUES ('JavaScript', 'EASY',
                                                            'document.getElementById("title").textContent = "Hello";
                                                            document.body.style.background = "black";');

INSERT INTO snippet (language, difficulty, content) VALUES ('SQL', 'EASY',
                                                            'SELECT name, score
                                                            FROM student
                                                            WHERE score >= 80
                                                            ORDER BY score DESC;');

INSERT INTO snippet (language, difficulty, content) VALUES ('SQL', 'EASY',
                                                            'SELECT * FROM member WHERE id = 1;');

INSERT INTO snippet (language, difficulty, content) VALUES ('SQL', 'EASY',
                                                            'INSERT INTO member (id, name) VALUES (1, ''Kim'');');

INSERT INTO snippet (language, difficulty, content) VALUES ('SQL', 'EASY',
                                                            'UPDATE member SET name = ''Lee'' WHERE id = 1;');

INSERT INTO snippet (language, difficulty, content) VALUES ('SQL', 'EASY',
                                                            'DELETE FROM member WHERE id = 3;');

INSERT INTO snippet (language, difficulty, content) VALUES ('HTML', 'EASY',
                                                            '<ul>
                                                                <li>Java</li>
                                                                <li>Spring</li>
                                                            </ul>');

INSERT INTO snippet (language, difficulty, content) VALUES ('CSS', 'EASY',
                                                            '.button {
                                                                color: white;
                                                                background: blue;
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('HTML', 'EASY',
                                                            '<form action="/login" method="post">
                                                                <input type="text" name="id">
                                                                <button>Login</button>
                                                            </form>');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'public int sum(int[] numbers) {
                                                                int total = 0;
                                                                for (int n : numbers) {
                                                                    total += n;
                                                                }
                                                                return total;
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'int max = numbers[0];
                                                            for (int i = 1; i < numbers.length; i++) {
                                                                if (numbers[i] > max) {
                                                                    max = numbers[i];
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'String word = "hello";
                                                            String reversed = "";
                                                            for (int i = word.length() - 1; i >= 0; i--) {
                                                                reversed += word.charAt(i);
                                                            }
                                                            System.out.println(reversed);');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'int[][] board = new int[3][3];
                                                            for (int r = 0; r < 3; r++) {
                                                                for (int c = 0; c < 3; c++) {
                                                                    board[r][c] = r * 3 + c;
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'public int factorial(int n) {
                                                                if (n <= 1) {
                                                                    return 1;
                                                                }
                                                                return n * factorial(n - 1);
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'try {
                                                                int result = 10 / 0;
                                                            } catch (ArithmeticException e) {
                                                                System.out.println("cannot divide by zero");
                                                            } finally {
                                                                System.out.println("done");
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'public class Player {
                                                                private String name;

                                                                public Player(String name) {
                                                                    this.name = name;
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'private int score;

                                                            public int getScore() {
                                                                return score;
                                                            }

                                                            public void setScore(int score) {
                                                                this.score = score;
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'public interface Animal {
                                                                void sound();
                                                            }

                                                            public class Dog implements Animal {
                                                                public void sound() {
                                                                    System.out.println("Woof");
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'public boolean isPrime(int n) {
                                                                if (n < 2) {
                                                                    return false;
                                                                }
                                                                for (int i = 2; i * i <= n; i++) {
                                                                    if (n % i == 0) {
                                                                        return false;
                                                                    }
                                                                }
                                                                return true;
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'int count = 0;
                                                            for (char c : word.toCharArray()) {
                                                                if (c == ''a'' || c == ''e'' || c == ''i'' || c == ''o'' || c == ''u'') {
                                                                    count++;
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
                                                            nums.removeIf(n -> n % 2 == 0);
                                                            System.out.println(nums);');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'public enum Level {
                                                                EASY, NORMAL, HARD;

                                                                public boolean isHard() {
                                                                    return this == HARD;
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'public abstract class Shape {
                                                                public abstract double area();
                                                            }

                                                            public class Circle extends Shape {
                                                                private final double r;

                                                                public Circle(double r) {
                                                                    this.r = r;
                                                                }

                                                                @Override
                                                                public double area() {
                                                                    return Math.PI * r * r;
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'public int gcd(int a, int b) {
                                                                while (b != 0) {
                                                                    int temp = a % b;
                                                                    a = b;
                                                                    b = temp;
                                                                }
                                                                return a;
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'NORMAL',
                                                            'int[] fib = new int[10];
                                                            fib[0] = 0;
                                                            fib[1] = 1;
                                                            for (int i = 2; i < fib.length; i++) {
                                                                fib[i] = fib[i - 1] + fib[i - 2];
                                                            }
                                                            System.out.println(Arrays.toString(fib));');

INSERT INTO snippet (language, difficulty, content) VALUES ('Spring', 'NORMAL',
                                                            '@GetMapping("/hello")
                                                            public String hello(Model model) {
                                                                model.addAttribute("name", "world");
                                                                return "hello";
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Spring', 'NORMAL',
                                                            '@PostMapping("/members")
                                                            public String join(@RequestParam String name) {
                                                                memberService.join(name);
                                                                return "redirect:/members";
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Spring', 'NORMAL',
                                                            '@Service
                                                            public class MemberService {
                                                                private final MemberRepository memberRepository;

                                                                public MemberService(MemberRepository memberRepository) {
                                                                    this.memberRepository = memberRepository;
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Spring', 'NORMAL',
                                                            'public interface MemberRepository extends JpaRepository<Member, Long> {
                                                                List<Member> findByName(String name);
                                                                boolean existsByEmail(String email);
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Spring', 'NORMAL',
                                                            '@Entity
                                                            public class Member {
                                                                @Id
                                                                @GeneratedValue(strategy = GenerationType.IDENTITY)
                                                                private Long id;

                                                                @Column(nullable = false, length = 20)
                                                                private String name;
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Spring', 'NORMAL',
                                                            '@RestController
                                                            @RequestMapping("/api/members")
                                                            public class MemberApiController {
                                                                @GetMapping("/{id}")
                                                                public Member find(@PathVariable Long id) {
                                                                    return memberService.findById(id);
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Python', 'NORMAL',
                                                            'def is_even(n):
                                                                return n % 2 == 0

                                                            for i in range(1, 6):
                                                                if is_even(i):
                                                                    print(i, "is even")');

INSERT INTO snippet (language, difficulty, content) VALUES ('Python', 'NORMAL',
                                                            'scores = {"kim": 90, "lee": 85}
                                                            for name, score in scores.items():
                                                                if score >= 90:
                                                                    print(name, "A")
                                                                else:
                                                                    print(name, "B")');

INSERT INTO snippet (language, difficulty, content) VALUES ('Python', 'NORMAL',
                                                            'squares = [n * n for n in range(1, 11)]
                                                            evens = [n for n in squares if n % 2 == 0]
                                                            print(evens)');

INSERT INTO snippet (language, difficulty, content) VALUES ('Python', 'NORMAL',
                                                            'class Dog:
                                                                def __init__(self, name):
                                                                    self.name = name

                                                                def bark(self):
                                                                    print(self.name + " says woof")');

INSERT INTO snippet (language, difficulty, content) VALUES ('JavaScript', 'NORMAL',
                                                            'const button = document.getElementById("start");
                                                            button.addEventListener("click", function () {
                                                                alert("Game start!");
                                                            });');

INSERT INTO snippet (language, difficulty, content) VALUES ('JavaScript', 'NORMAL',
                                                            'const scores = [90, 75, 88, 62];
                                                            const passed = scores.filter(s => s >= 70);
                                                            const total = passed.reduce((sum, s) => sum + s, 0);
                                                            console.log(passed.length, total);');

INSERT INTO snippet (language, difficulty, content) VALUES ('JavaScript', 'NORMAL',
                                                            'const user = { name: "Kim", age: 18 };
                                                            const { name, age } = user;
                                                            console.log(`${name} is ${age} years old`);');

INSERT INTO snippet (language, difficulty, content) VALUES ('JavaScript', 'NORMAL',
                                                            'let count = 3;
                                                            const timer = setInterval(() => {
                                                                console.log(count);
                                                                count--;
                                                                if (count === 0) {
                                                                    clearInterval(timer);
                                                                }
                                                            }, 1000);');

INSERT INTO snippet (language, difficulty, content) VALUES ('SQL', 'NORMAL',
                                                            'CREATE TABLE member (
                                                                id INT PRIMARY KEY,
                                                                name VARCHAR(20) NOT NULL,
                                                                email VARCHAR(50)
                                                            );');

INSERT INTO snippet (language, difficulty, content) VALUES ('SQL', 'NORMAL',
                                                            'SELECT dept, COUNT(*) AS cnt, AVG(salary) AS avg_salary
                                                            FROM employee
                                                            GROUP BY dept
                                                            ORDER BY cnt DESC;');

INSERT INTO snippet (language, difficulty, content) VALUES ('SQL', 'NORMAL',
                                                            'SELECT m.name, o.product, o.price
                                                            FROM member m
                                                            JOIN orders o ON m.id = o.member_id
                                                            WHERE o.price >= 10000;');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'public int binarySearch(int[] arr, int target) {
                                                                int left = 0;
                                                                int right = arr.length - 1;
                                                                while (left <= right) {
                                                                    int mid = left + (right - left) / 2;
                                                                    if (arr[mid] == target) {
                                                                        return mid;
                                                                    } else if (arr[mid] < target) {
                                                                        left = mid + 1;
                                                                    } else {
                                                                        right = mid - 1;
                                                                    }
                                                                }
                                                                return -1;
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'for (int i = 0; i < arr.length - 1; i++) {
                                                                for (int j = 0; j < arr.length - 1 - i; j++) {
                                                                    if (arr[j] > arr[j + 1]) {
                                                                        int temp = arr[j];
                                                                        arr[j] = arr[j + 1];
                                                                        arr[j + 1] = temp;
                                                                    }
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'public void quickSort(int[] arr, int low, int high) {
                                                                if (low >= high) {
                                                                    return;
                                                                }
                                                                int pivot = arr[(low + high) / 2];
                                                                int i = low;
                                                                int j = high;
                                                                while (i <= j) {
                                                                    while (arr[i] < pivot) i++;
                                                                    while (arr[j] > pivot) j--;
                                                                    if (i <= j) {
                                                                        int temp = arr[i];
                                                                        arr[i] = arr[j];
                                                                        arr[j] = temp;
                                                                        i++;
                                                                        j--;
                                                                    }
                                                                }
                                                                quickSort(arr, low, j);
                                                                quickSort(arr, i, high);
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'private void merge(int[] arr, int left, int mid, int right) {
                                                                int[] temp = new int[right - left + 1];
                                                                int i = left, j = mid + 1, k = 0;
                                                                while (i <= mid && j <= right) {
                                                                    temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
                                                                }
                                                                while (i <= mid) temp[k++] = arr[i++];
                                                                while (j <= right) temp[k++] = arr[j++];
                                                                System.arraycopy(temp, 0, arr, left, temp.length);
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'public int[] bfs(List<List<Integer>> graph, int start) {
                                                                int[] dist = new int[graph.size()];
                                                                Arrays.fill(dist, -1);
                                                                Queue<Integer> queue = new ArrayDeque<>();
                                                                queue.offer(start);
                                                                dist[start] = 0;
                                                                while (!queue.isEmpty()) {
                                                                    int now = queue.poll();
                                                                    for (int next : graph.get(now)) {
                                                                        if (dist[next] == -1) {
                                                                            dist[next] = dist[now] + 1;
                                                                            queue.offer(next);
                                                                        }
                                                                    }
                                                                }
                                                                return dist;
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'private boolean[] visited;

                                                            public void dfs(List<List<Integer>> graph, int node) {
                                                                visited[node] = true;
                                                                System.out.print(node + " ");
                                                                for (int next : graph.get(node)) {
                                                                    if (!visited[next]) {
                                                                        dfs(graph, next);
                                                                    }
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'public int lcs(String a, String b) {
                                                                int[][] dp = new int[a.length() + 1][b.length() + 1];
                                                                for (int i = 1; i <= a.length(); i++) {
                                                                    for (int j = 1; j <= b.length(); j++) {
                                                                        if (a.charAt(i - 1) == b.charAt(j - 1)) {
                                                                            dp[i][j] = dp[i - 1][j - 1] + 1;
                                                                        } else {
                                                                            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                                                                        }
                                                                    }
                                                                }
                                                                return dp[a.length()][b.length()];
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'Map<String, List<String>> byDept = employees.stream()
                                                                    .filter(e -> e.getSalary() >= 3000)
                                                                    .sorted(Comparator.comparing(Employee::getName))
                                                                    .collect(Collectors.groupingBy(
                                                                            Employee::getDept,
                                                                            Collectors.mapping(Employee::getName, Collectors.toList())
                                                                    ));');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'public class Pair<K, V> {
                                                                private final K key;
                                                                private final V value;

                                                                public Pair(K key, V value) {
                                                                    this.key = key;
                                                                    this.value = value;
                                                                }

                                                                public <R> Pair<K, R> mapValue(Function<V, R> mapper) {
                                                                    return new Pair<>(key, mapper.apply(value));
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
                                                                String line;
                                                                while ((line = reader.readLine()) != null) {
                                                                    if (line.isBlank()) {
                                                                        continue;
                                                                    }
                                                                    System.out.println(line.trim());
                                                                }
                                                            } catch (IOException e) {
                                                                throw new UncheckedIOException(e);
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'public boolean isValid(String s) {
                                                                Deque<Character> stack = new ArrayDeque<>();
                                                                for (char c : s.toCharArray()) {
                                                                    if (c == ''('' || c == ''{'' || c == ''['') {
                                                                        stack.push(c);
                                                                    } else {
                                                                        if (stack.isEmpty()) {
                                                                            return false;
                                                                        }
                                                                        char open = stack.pop();
                                                                        if ((c == '')'' && open != ''('') || (c == ''}'' && open != ''{'') || (c == '']'' && open != ''['')) {
                                                                            return false;
                                                                        }
                                                                    }
                                                                }
                                                                return stack.isEmpty();
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'ExecutorService pool = Executors.newFixedThreadPool(4);
                                                            AtomicInteger counter = new AtomicInteger();
                                                            for (int i = 0; i < 100; i++) {
                                                                pool.submit(() -> counter.incrementAndGet());
                                                            }
                                                            pool.shutdown();
                                                            pool.awaitTermination(5, TimeUnit.SECONDS);
                                                            System.out.println("count = " + counter.get());');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'Pattern pattern = Pattern.compile("^[\\w.]+@[\\w-]+\\.[a-z]{2,}$");
                                                            for (String email : List.of("kim@test.com", "wrong@", "lee.park@school.kr")) {
                                                                Matcher matcher = pattern.matcher(email);
                                                                System.out.println(email + " -> " + matcher.matches());
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'public sealed interface Shape permits Circle, Square {}
                                                            public record Circle(double r) implements Shape {}
                                                            public record Square(double side) implements Shape {}

                                                            public double area(Shape shape) {
                                                                return switch (shape) {
                                                                    case Circle c -> Math.PI * c.r() * c.r();
                                                                    case Square s -> s.side() * s.side();
                                                                };
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Java', 'HARD',
                                                            'String city = Optional.ofNullable(member)
                                                                    .map(Member::getAddress)
                                                                    .map(Address::getCity)
                                                                    .filter(c -> !c.isBlank())
                                                                    .orElse("unknown");');

INSERT INTO snippet (language, difficulty, content) VALUES ('Spring', 'HARD',
                                                            '@Service
                                                            @Transactional(readOnly = true)
                                                            public class OrderService {
                                                                private final OrderRepository orderRepository;
                                                                private final MemberRepository memberRepository;

                                                                public OrderService(OrderRepository orderRepository, MemberRepository memberRepository) {
                                                                    this.orderRepository = orderRepository;
                                                                    this.memberRepository = memberRepository;
                                                                }

                                                                @Transactional
                                                                public Long order(Long memberId, int price) {
                                                                    Member member = memberRepository.findById(memberId)
                                                                            .orElseThrow(() -> new IllegalArgumentException("no member: " + memberId));
                                                                    Order order = new Order(member, price);
                                                                    return orderRepository.save(order).getId();
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Spring', 'HARD',
                                                            '@PostMapping("/api/posts")
                                                            public ResponseEntity<PostResponse> create(@Valid @RequestBody PostRequest request) {
                                                                Post post = postService.create(request.title(), request.content());
                                                                URI location = URI.create("/api/posts/" + post.getId());
                                                                return ResponseEntity.created(location).body(PostResponse.from(post));
                                                            }

                                                            @ExceptionHandler(IllegalArgumentException.class)
                                                            public ResponseEntity<String> handle(IllegalArgumentException e) {
                                                                return ResponseEntity.badRequest().body(e.getMessage());
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Spring', 'HARD',
                                                            '@Entity
                                                            @Table(name = "orders")
                                                            public class Order {
                                                                @Id
                                                                @GeneratedValue(strategy = GenerationType.IDENTITY)
                                                                private Long id;

                                                                @ManyToOne(fetch = FetchType.LAZY)
                                                                @JoinColumn(name = "member_id")
                                                                private Member member;

                                                                @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
                                                                private List<OrderItem> items = new ArrayList<>();
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Spring', 'HARD',
                                                            '@Configuration
                                                            @EnableWebSocketMessageBroker
                                                            public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
                                                                @Override
                                                                public void registerStompEndpoints(StompEndpointRegistry registry) {
                                                                    registry.addEndpoint("/ws").setAllowedOriginPatterns("*");
                                                                }

                                                                @Override
                                                                public void configureMessageBroker(MessageBrokerRegistry registry) {
                                                                    registry.enableSimpleBroker("/topic");
                                                                    registry.setApplicationDestinationPrefixes("/app");
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('Python', 'HARD',
                                                            'import time

                                                            def timer(func):
                                                                def wrapper(*args, **kwargs):
                                                                    start = time.time()
                                                                    result = func(*args, **kwargs)
                                                                    print(f"{func.__name__}: {time.time() - start:.3f}s")
                                                                    return result
                                                                return wrapper

                                                            @timer
                                                            def heavy(n):
                                                                return sum(i * i for i in range(n))');

INSERT INTO snippet (language, difficulty, content) VALUES ('Python', 'HARD',
                                                            'from dataclasses import dataclass

                                                            @dataclass
                                                            class Student:
                                                                name: str
                                                                score: int

                                                            students = [Student("kim", 90), Student("lee", 85), Student("park", 97)]
                                                            ranked = sorted(students, key=lambda s: (-s.score, s.name))
                                                            for rank, s in enumerate(ranked, start=1):
                                                                print(rank, s.name, s.score)');

INSERT INTO snippet (language, difficulty, content) VALUES ('Python', 'HARD',
                                                            'from functools import lru_cache

                                                            @lru_cache(maxsize=None)
                                                            def fib(n):
                                                                if n < 2:
                                                                    return n
                                                                return fib(n - 1) + fib(n - 2)

                                                            def evens(limit):
                                                                for i in range(limit):
                                                                    if fib(i) % 2 == 0:
                                                                        yield fib(i)

                                                            print(list(evens(20)))');

INSERT INTO snippet (language, difficulty, content) VALUES ('Python', 'HARD',
                                                            'from collections import Counter

                                                            text = "the quick brown fox jumps over the lazy dog the end"
                                                            counts = Counter(text.split())
                                                            top = {word: n for word, n in counts.most_common(3)}
                                                            print(top)');

INSERT INTO snippet (language, difficulty, content) VALUES ('JavaScript', 'HARD',
                                                            'async function loadMembers() {
                                                                try {
                                                                    const response = await fetch("/api/members");
                                                                    if (!response.ok) {
                                                                        throw new Error(`HTTP ${response.status}`);
                                                                    }
                                                                    const members = await response.json();
                                                                    return members.filter(m => m.active).map(m => m.name);
                                                                } catch (error) {
                                                                    console.error("failed:", error.message);
                                                                    return [];
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('JavaScript', 'HARD',
                                                            'function debounce(fn, delay) {
                                                                let timer = null;
                                                                return function (...args) {
                                                                    clearTimeout(timer);
                                                                    timer = setTimeout(() => fn.apply(this, args), delay);
                                                                };
                                                            }

                                                            const search = debounce((keyword) => {
                                                                console.log("search:", keyword);
                                                            }, 300);');

INSERT INTO snippet (language, difficulty, content) VALUES ('JavaScript', 'HARD',
                                                            'class Timer {
                                                                static count = 0;
                                                                #start = 0;

                                                                constructor(name) {
                                                                    this.name = name;
                                                                    Timer.count++;
                                                                }

                                                                start() {
                                                                    this.#start = Date.now();
                                                                }

                                                                get elapsed() {
                                                                    return Date.now() - this.#start;
                                                                }
                                                            }');

INSERT INTO snippet (language, difficulty, content) VALUES ('JavaScript', 'HARD',
                                                            'const urls = ["/api/a", "/api/b", "/api/c"];
                                                            const results = await Promise.all(urls.map(url => fetch(url).then(r => r.json())));
                                                            const grouped = results.flat().reduce((acc, item) => {
                                                                (acc[item.type] ??= []).push(item);
                                                                return acc;
                                                            }, {});
                                                            console.log(Object.keys(grouped));');

INSERT INTO snippet (language, difficulty, content) VALUES ('SQL', 'HARD',
                                                            'SELECT name, salary
                                                            FROM employee
                                                            WHERE salary > (
                                                                SELECT AVG(salary)
                                                                FROM employee
                                                                WHERE dept = ''dev''
                                                            )
                                                            ORDER BY salary DESC;');

INSERT INTO snippet (language, difficulty, content) VALUES ('SQL', 'HARD',
                                                            'SELECT m.name, COUNT(o.id) AS order_count, COALESCE(SUM(o.price), 0) AS total
                                                            FROM member m
                                                            LEFT JOIN orders o ON o.member_id = m.id
                                                            GROUP BY m.id, m.name
                                                            HAVING COUNT(o.id) >= 2
                                                            ORDER BY total DESC;');

INSERT INTO snippet (language, difficulty, content) VALUES ('SQL', 'HARD',
                                                            'SELECT name, dept, salary,
                                                                   RANK() OVER (PARTITION BY dept ORDER BY salary DESC) AS dept_rank
                                                            FROM employee
                                                            WHERE hire_date >= ''2024-01-01'';');

INSERT INTO snippet (language, difficulty, content) VALUES ('SQL', 'HARD',
                                                            'WITH monthly AS (
                                                                SELECT member_id, SUM(price) AS total
                                                                FROM orders
                                                                WHERE order_date BETWEEN ''2026-01-01'' AND ''2026-01-31''
                                                                GROUP BY member_id
                                                            )
                                                            SELECT m.name, monthly.total
                                                            FROM monthly
                                                            JOIN member m ON m.id = monthly.member_id
                                                            WHERE monthly.total >= 50000;');

INSERT INTO snippet (language, difficulty, content) VALUES ('SQL', 'HARD',
                                                            'CREATE TABLE orders (
                                                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                                member_id BIGINT NOT NULL,
                                                                price INT NOT NULL CHECK (price > 0),
                                                                status VARCHAR(20) DEFAULT ''READY'',
                                                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                                                FOREIGN KEY (member_id) REFERENCES member(id)
                                                            );');