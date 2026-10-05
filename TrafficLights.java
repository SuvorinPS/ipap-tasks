import java.util.Scanner;

// Задача №124
// Светофорчики
public class TrafficLights {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        solveTrafficLights();
    }

    private static void solveTrafficLights() {
        System.out.println("Введите количество перекрестков:");
        int crossroads = scanner.nextInt();
        System.out.println("Введите количество тоннелей:");
        int tunnels = scanner.nextInt();

        int[] counter = new int[crossroads];
        for (int i = 0; i < tunnels; i++) {
            System.out.println("Введите номера перекрестков, которые соединяет тоннель №" + (i + 1) + ":");
            counter[scanner.nextInt() - 1]++;
            counter[scanner.nextInt() - 1]++;
        }

        for (int i = 0; i < counter.length; i++) {
            System.out.print(counter[i] + " ");
        }
    }
}

// тестовые данные
// 7 10
// 5 1 3 2 7 1 5 2 7 4 6 5 6 4 7 5 2 1 5 3
// результат
// 3 3 2 2 5 2 3