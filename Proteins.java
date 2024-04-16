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
