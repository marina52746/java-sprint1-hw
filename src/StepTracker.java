import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay;
    StepTracker(Scanner scan) {
        goalByStepsPerDay = 10000;
        scanner = scan;
        for (int i = 0; i < 12; i++) {
            monthToData[i] = new MonthData();
        }

    }

    void changeStepGoal() {
        System.out.println("Введите цель шагов на день:");
        int stepsPerDay = scanner.nextInt();
        if (stepsPerDay <= 0) {
            System.out.println("Неверное количество шагов. Количество шагов - целое положительное число больше нуля.");
            return;
        }
        goalByStepsPerDay = stepsPerDay;
    }
    void addNewNumberStepsPerDay()
    {
        System.out.println("Введите номер месяца от 1 до 12 (1 - январь, 12 - декабрь):");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Неверный номер месяца. Номер месяца должен быть целым числом от 1 до 12.");
            return;
        }
        System.out.println("Введите номер дня от 1 до 30:");
        int dayNumber = scanner.nextInt();
        if (dayNumber < 1 || dayNumber > 30) {
            System.out.println("Неверный номер дня. Номер дня должен быть целым числом от 1 до 30.");
            return;
        }
        System.out.println("Введите количество шагов:");
        int stepCount = scanner.nextInt();
        if (stepCount < 0) {
            System.out.println("Неверное количество шагов. Количество шагов должно быть целым положительным числом.");
            return;
        }
        monthToData[monthNumber - 1].days[dayNumber - 1] = stepCount;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца от 1 до 12 (1 - январь, 12 - декабрь):");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Неверный номер месяца. Номер месяца должен быть целым числом от 1 до 12.");
            return;
        }
        MonthData monthData = monthToData[month - 1];
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц = " + monthData.sumStepsFromMonth());
        System.out.println("Максимальное пройденное количество шагов в месяце = " + monthData.maxSteps());
        System.out.println("Среднее количество шагов = " + (int) Math.round(monthData.sumStepsFromMonth() / 30));
        Converter converter = new Converter();
        System.out.println("Пройденная дистанция = " + converter.convertStepsToKm(monthData.sumStepsFromMonth()) + " км");
        System.out.println("Количество сожженных килокалорий = " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
        System.out.println("Лучшая серия = " + daysCount(monthData.bestSeries(goalByStepsPerDay)));
        System.out.println();
    }

    String daysCount(int days) {
        String daysString;
        if (days == 1 || days == 21) {
            daysString = "день";
        } else if (days == 2 || days == 3 || days == 4 || days == 22 || days == 23 || days == 24) {
            daysString = "дня";
        }
        else daysString = "дней";
        return days + " " + daysString;
    }
}
