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