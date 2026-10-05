import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RobotK79 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        robotK79();
    }

    private static void robotK79() {
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        enum Directions {
            UP,
            RIGHT,
            DOWN,
            LEFT;

            Directions left() {
                return values()[(ordinal() + 3) % 4];
            }

            Directions right() {
                return values()[(ordinal() + 1) % 4];
            }
        }

        Directions actualDirection = Directions.UP;
        List<Coords> visited = new ArrayList<>();

        visited.add(new Coords(0, 0));

        int moves = 0;
        boolean isSolved = false;

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) != 'S') {
                switch (input.charAt(i)) {
                    case 'L':
                        actualDirection = actualDirection.left();
                        break;
                    case 'R':
                        actualDirection = actualDirection.right();
                        break;
                }
            } else {
                moves++;
                Coords nextCoords = new Coords(visited.getLast().x, visited.getLast().y);

                switch (actualDirection) {
                    case UP:
                        nextCoords = new Coords(visited.getLast().x, visited.getLast().y + 1);
                        break;
                    case RIGHT:
                        nextCoords = new Coords(visited.getLast().x + 1, visited.getLast().y);
                        break;
                    case DOWN:
                        nextCoords = new Coords(visited.getLast().x, visited.getLast().y - 1);
                        break;
                    case LEFT:
                        nextCoords = new Coords(visited.getLast().x - 1, visited.getLast().y);
                        break;
                    default:
                        break;
                }

                if (visited.contains(nextCoords)) {
                    isSolved = true;
                    break;
                } else {
                    visited.add(nextCoords);
                }
            }
        }

        System.out.println(isSolved ? moves : -1);
    }

    record Coords(int x, int y) {
    }
}