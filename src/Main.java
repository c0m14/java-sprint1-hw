import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepTracker currentTracker = new StepTracker(sc);
        int monthNumber;

        while (true) {
            printMenu();
            int userChoice = sc.nextInt();

            if (userChoice == 1) {
                currentTracker.saveSteps();
            } else if (userChoice == 2) {
                while (true) {
                    System.out.println("За какой месяц показать статистику? (введите номер от 1 до 12)");
                    monthNumber = sc.nextInt();
                    if (monthNumber > 0 && monthNumber < 12) {
                        currentTracker.showStat(monthNumber);
                        break;
                    } else {
                        System.out.println("Укажите число от 1 до 12");
                    }
                }
            } else if (userChoice == 3) {
                currentTracker.setGoal();
            } else if (userChoice == 0) {
                break;
            } else {
                System.out.println("Команды не существует. Выберите команду из списка");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите нужно действие:");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}
