class Converter {

    int convertStepsToKm(int steps) {
        return (int) Math.round(steps * 0.75 / 1000);
    }

    int convertStepsToKilocalories(int steps) {
        return (int) Math.round(steps * 50 / 1000);
    }
}
