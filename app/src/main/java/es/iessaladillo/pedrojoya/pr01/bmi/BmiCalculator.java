package es.iessaladillo.pedrojoya.pr01.bmi;

/**
 * Allow Bmi calculation and clasification
 */
public class BmiCalculator {

    /**
     * @param weightInKgs Weight of the person in kgs
     * @param heightInMeters Height of the person in meters
     * @return The body mass index (BMI)
     */
    public float calculateBmi(float weightInKgs, float heightInMeters) {
        // TODO
        return weightInKgs * (heightInMeters * heightInMeters);
    }


    /**
     * @param bmi Body mass index to get clasification from
     * @return A BmiClasification enum with the clasification of BMI
     */
    public BmiClasification getBmiClasification(float bmi) {
        // TODO
        Enum<BmiClasification> range = null;
        if (bmi < 18.5) {
            range = BmiClasification.LOW_WEIGHT;
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            range = BmiClasification.NORMAL_WEIGHT;
        } else if (bmi >= 25 && bmi <= 29.9){
            range = BmiClasification.OVERWWEIGHT;
        } else if (bmi >= 30 && bmi <= 34.9){
            range = BmiClasification.OBESITY_GRADE_1;
        } else if (bmi >= 30 && bmi <= 34.9){
            range = BmiClasification.OBESITY_GRADE_2;
        } else{
            range = BmiClasification.OBESITY_GRADE_3;
        }
        return (BmiClasification) range;
    }

    public enum BmiClasification {
        LOW_WEIGHT, NORMAL_WEIGHT, OVERWWEIGHT, OBESITY_GRADE_1, OBESITY_GRADE_2, OBESITY_GRADE_3
    }
}
