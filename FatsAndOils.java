public class FatsAndOils extends Food{
    public FatsAndOils(String name, double calorieCount){
        super(name, calorieCount, "Fats and Oils");

       
    }

    //Dividing by 9 to convert from calories to grams
    public static double calculateFatBulkIntake(double tdee){
        return (0.25 * tdee)/9;


    }
    public static double calculateFatCutIntake(double tdee){
        return (0.20 * tdee)/9;
    

    }
    public static double calculateFatMaintainIntake(double tdee){
        return (0.225 * tdee)/9;
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