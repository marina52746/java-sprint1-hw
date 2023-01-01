// С Новым годом!!!
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();
            int commandNumber = scanner.nextInt();
            if (commandNumber == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (commandNumber == 2) {
                stepTracker.changeStepGoal();
            } else if (commandNumber == 3) {
                stepTracker.printStatistic();
            } else if (commandNumber == 4) {
                System.out.println("Пока!");
                scanner.close();
                return;
            }
            else {
                System.out.println("Такой команды нет");
            }
        }
    }

    static void printMenu() {
        System.out.println("Выберите один из пунктов меню (введите цифру от 1 до 4):");
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц");
        System.out.println("4 - выйти из приложения");
    }
}