public class Proteins extends Food{
    public Proteins(String name, double calorieCount){
        super(name, calorieCount, "Proteins");

    }
      //Adequate protein intake: 2.2-2.6 gram per kilogram of user's weight
    public static double calculateproteinCutIntake(double userWeight){
        return (userWeight * 2.6) * 4;

    }
    //Adequate protein intake: 1.6-2.2gram per kilogram of user's weight
    public static double calculateproteinBulkIntake(double userWeight){
        return (userWeight * 2.0) * 4;
    }
    //Adequate protein intake: 1.6-2.2gram per kilogram of user's weight
    public static double calculateproteinMaintainIntake(double userWeight){
        return (userWeight * 1.8) * 4;
    }

}

/*     public double calculateProteinForCut() {
    return 2.6 * weight; // 1.2 g/lb for cutting
}

 public double calculateProteinForBulk() {
    return 1.6 * weight; // 0.7 g/lb for bulking
}

public double calculateFatForCut() {
    double tdee = calculateTDEE();
    return 0.20 * tdee; // 20% of TDEE for cutting
}

public double calculateFatForBulk() {
    double tdee = calculateTDEE();
    return 0.25 * tdee; // 25% of TDEE for bulking
}

public double calculateCarbohydrate() {
    double tdee = calculateTDEE();
    double protein = userSex == 'M' ? calculateProteinForCut() : calculateProteinForBulk();
    double fat = userSex == 'M' ? calculateFatForCut() : calculateFatForBulk();
    return (tdee - (protein * 4) - (fat * 9)) / 4;
}

public double calculateCaloriesForCut(double targetWeeklyFatLossRate) {
    double tdee = calculateTDEE();
    return tdee - (targetWeeklyFatLossRate * 500); // Adjust for fat loss
}

public double calculateCaloriesForBulk(double targetMonthlyGainRate) {
    double tdee = calculateTDEE();
    return tdee + (targetMonthlyGainRate * 150); // Adjust for weight gain
}

public double calculateCaloriesForMaintenance() {
    return calculateTDEE();
}
}*/