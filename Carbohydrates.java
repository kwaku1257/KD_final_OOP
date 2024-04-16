import math; //Importing the math library/class

public class Carbohydrates extends Food{
    public Carbohydrates(String name, double calorieCount){
        super(name, calorieCount, "Carbohydrates");

    }
     // User's carb calories are based off remaining calories after calculating protein and fat intake
     public static double calculateCarbIntake(double tdee, double protein, double fat){
        return (tdee - (protein) - (fat)) / 4;
    
}
}
