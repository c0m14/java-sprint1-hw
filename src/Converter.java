public class Converter {
    double stepSizeKm;
    int callConsumptionPerStep;

    Converter() {
        stepSizeKm = 75.0 / (100.0 * 1000.0); //Берем среднюю длину шага в см и переводим в км
        callConsumptionPerStep = 50; // Калорий за шаг
    }

    double convertStepsToKm (int stepSum) {
        double distance = stepSum * stepSizeKm;
        return distance;
    }

    double convertStepsToKilocals (int stepSum) {
         double spentKilocals = (stepSum * callConsumptionPerStep) / 1000.0;
         return spentKilocals;
    }

}
