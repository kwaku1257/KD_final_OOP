public class Food{
//Creating instance variables
    private String name;
  
    private double calorieCount;
   
    private String foodGroup;

//Constructor
    public Food(String name, double calorieCount, String foodGroup){
        this.name = name;
        this.calorieCount = calorieCount;
        this.foodGroup = foodGroup;
    }

//Accessor Methods
    public double getCalories(){
        return calorieCount;
    }

    public String getFoodGroup(){
        return foodGroup;
    }
    public String getName(){
        return name;
    }
}
