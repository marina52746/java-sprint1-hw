class MonthData {
    int[] days = new int[30];
    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < 30; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxStep = 0;
        for (int i = 0; i < 30; i++) {
            if (days[i] > maxStep) {
                maxStep = days[i];
            }
        }
        return maxStep;
    }

    int bestSeries(int goalByStepsPerDay) {
        int bestSession = 0;
        int countBest = 0;
        for (int i = 0; i < 30; i++) {
            if (days[i] > goalByStepsPerDay) {
                countBest++;
            }
            else {
                bestSession = refreshedMax(countBest, bestSession); // Не знаю, можно ли использовать стандартную функцию max? Мы ее, вроде, не прошли пока...
                countBest = 0;
            }
        }
        bestSession = refreshedMax(countBest, bestSession);
        return bestSession;
    }

    int refreshedMax(int comparingValue, int lastMax)
    {
        if (comparingValue > lastMax) {
            return comparingValue;
        }
        return lastMax;
    }
}
