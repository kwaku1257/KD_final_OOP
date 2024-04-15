public class Food{

    private String name;
  
    private double calorieCount;
   
    private String foodGroup;

    public Food(String name, double calorieCount, String foodGroup){
        this.name = name;
        this.calorieCount = calorieCount;
        this.foodGroup = foodGroup;
    }

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
