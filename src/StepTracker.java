import java.util.Scanner;

public class StepTracker {
    int goal;
    Scanner scanner;
    int[][] stat;
    Converter converter;

    //Объявлеяем конструктор класса
    StepTracker () {
        goal = 10000; // цель по умолчанию = 10 тыс шагов
        stat = createCalendar();
        scanner = new Scanner(System.in);
        converter = new Converter();
    }

    //Метод по сохранению количества шагов
    void saveSteps () {
        int monthNumber;
        int dayNumber;
        int stepsPerDay;
        while (true) {
            System.out.println("Введите номер месяца");
            monthNumber = scanner.nextInt();
            if (monthNumber > 0 && monthNumber < 13) {
                break;
            } else {
                System.out.println("Месяц должен быть от 1 до 12");
            }
        }
        while (true) {
            System.out.println("Введите номер дня");
            dayNumber = scanner.nextInt();
            if (dayNumber > 0 && dayNumber < 31) {
                break;
            } else {
                System.out.println("День должен быть от 1 до 30");
            }
        }
        while (true) {
            System.out.println("Сколько шагов вы прошли?");
            stepsPerDay = scanner.nextInt();
            if (stepsPerDay > 0) {
                stat[monthNumber - 1][dayNumber - 1] = stat[monthNumber - 1][dayNumber - 1] + stepsPerDay;
                System.out.println("Значение сохранено");
                break;
            } else {
                System.out.println("Количество шагов должно быть больше 0");
            }
        }
    }
    //Метод по изменению цели
    void setGoal() {
        int newGoal;

        while (true) {
            System.out.println("Укажите новую цель по шагам за день");
            newGoal = scanner.nextInt();
            if (newGoal > 0) {
                goal = newGoal;
                break;
            }
            else {
                System.out.println("Количество шагов должно быть больше 0");
            }
        }
    }

    // Метод расчета и вывода статистики
    void showStat (int monthNumber) {
        int stepSum = 0;
        int maxSteps = 0;
        int seriesDaysGoalAchived = 0;
        int currentRecord = 0;

        monthNumber -=1; // Сдвигаем значение влево на 1 для корректной работы с индексом массива

        for (int i = 0; i < stat[0].length; i++) {
            //Печатаем результат за день
            System.out.print((i+1) + " день:" + stat[monthNumber][i] + ", ");

            //Считаем сумму шагов за месяц
            stepSum +=  stat[monthNumber][i];

            //Считаем максимальное количество шагов в месяц
            if (stat[monthNumber][i] > maxSteps) {
                maxSteps = stat[monthNumber][i];
            }

            //Считаем серию дней выполнения цели
            if (stat[monthNumber][i] >= goal) {

                if (stat[monthNumber][i+1] >= goal) {
                    seriesDaysGoalAchived++;
                }
            } else  if (currentRecord < seriesDaysGoalAchived) {
                currentRecord = seriesDaysGoalAchived + 1; // Прибавляем 1 для корректного значения дней в серии с учетом первого
                seriesDaysGoalAchived = 0;
            }
        }
        System.out.println();
        System.out.println("Общее кол-во шагов за месяц: " + stepSum);
        System.out.println("Максимальное пройденное кол-во шагов в месяце: " + maxSteps);
        System.out.println("Среднее количество шагов за месяц: " + (stepSum/stat[0].length));
        System.out.println("Пройденная дистанция: " + converter.convertStepsToKm(stepSum));
        System.out.println("Количество потраченных килокалорий: " + converter.convertStepsToKilocals(stepSum));
        System.out.println("Лучшая серия: " + currentRecord + " дней");
    }
    // Метод для заполнения календаря
    int[][] createCalendar() {
        int months = 12; // месяцев в году
        int days = 30; // дней в месяце
        int [][] stepsPerDate= new int[months][days];

        //Заполнить календарь дефолтным значением "0 шагов"
        for (int i = 0; i < stepsPerDate.length; i++) {
            for (int j = 0; j < stepsPerDate[0].length; j++) {
                stepsPerDate[i][j] = 0;
            }
        }
        return stepsPerDate;
    }
}
