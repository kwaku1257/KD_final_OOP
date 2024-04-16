
public class User {
   
    private int userAge;
    
    private char userSex;
   
    public String userGoal;
    
    public String activityLevel;

   // Weight in kilograms
    public double userWeight;

   // Height in centimeters
    private double userHeight;

    private double WeeklyFatLossTarget; 

    private double MonthlyGainTarget; 

    
    public User(int userAge, char userSex, String userGoal, String activityLevel, double userWeight, double userHeight, double WeeklyFatLossTarget, double MonthlyGainTarget){
        this.userAge = userAge;
        this.userSex = userSex;
        this.userGoal = userGoal;
        this.activityLevel = activityLevel;
        this.userHeight = userHeight;
        this.userWeight = userWeight;
        this.WeeklyFatLossTarget = WeeklyFatLossTarget;
        this.MonthlyGainTarget = MonthlyGainTarget;

    }

    
    private double calculateBMR(){
        if (userSex == 'M') {
            return 66 + (13.7 * userWeight) + (5 * userHeight) - (6.8 * userAge);
        }
        else if (userSex == 'F'){
            return 655 + (9.6 * userWeight) + (1.8 * userHeight) - (4.7 * userAge);
        }
        return 0;
    }
    public double calculateTDEE(String activityLevel){
        double bmr = calculateBMR();
        double multiplier;
        switch (activityLevel) {
            case "Sedentary":
            multiplier = 1.15;
                
                break;

                case "Lightly Active":
                multiplier = 1.55;
                    
                    break;
                case "Highly Active":
                multiplier = 1.75;
                    
                    break;

        //Setting the default to lightly active if the user's activity level is not known
            default:
            multiplier = 1.55;
                break;
        }
        return bmr * multiplier;
    }
 
    public double calculateCalories(){
        double tdee = calculateTDEE(activityLevel);
        if (userGoal.equals("cut")){
            //Weekly Fat Loss Target Rate should remain between 0.5% to 0.75%
            tdee -= (userWeight * WeeklyFatLossTarget * 1100);

        }
        else if(userGoal.equals("bulk")){
            //Recommended monthly rate for body weight gain
            //Beginners = 2% (Totally new to training)
            //Novice = 1.5% (Still able to progress most training loads in the gym on a week to week basis)
            //Intermediate = 1% (Able to progress most training loads in the gym on a month to month basis)
            // Advanced = 0.5% (Progress is evident only when viewed over multiple months or a year)

            tdee += (userWeight * MonthlyGainTarget * 330); 
        }
        return tdee;
    }
}