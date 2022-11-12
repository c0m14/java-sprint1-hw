public class Converter {
    double stepSizeSm;
    double stepSizeKm;
    int callConsumptionPerStep;

    Converter() {
        stepSizeSm = 75; //средняя длина шага в сантиметрах
        stepSizeKm = stepSizeSm / (100 * 1000); //Берем среднюю длину шага в см и переводим в км
        callConsumptionPerStep = 50; // Калорий за шаг
    }

    double convertStepsToKm (int stepSum) {
        double distance = stepSum * stepSizeKm;
        return distance;
    }

    double convertStepsToKilocals (int stepSum) {
         double spentKilocals = (stepSum * callConsumptionPerStep) / 1000;
         return spentKilocals;
    }

}
