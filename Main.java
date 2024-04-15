import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Get user input
        System.out.println("Enter user age: ");
        int userAge = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        
        System.out.println("Enter user sex (M/F): ");
        char userSex = scanner.next().charAt(0);
        scanner.nextLine(); // consume the newline
        
        System.out.println("Enter user goal (cut/bulk/maintain): ");
        String userGoal = scanner.nextLine();
        
        System.out.println("Enter user activity level (Sedentary/Lightly Active/Highly Active): ");
        String activityLevel = scanner.nextLine();
        
        System.out.println("Enter user weight (kg): ");
        double userWeight = scanner.nextDouble();
        
        System.out.println("Enter user height (cm): ");
        double userHeight = scanner.nextDouble();
        
        System.out.println("Enter weekly fat loss target (if user goal is 'cut', otherwise 0): ");
        double weeklyFatLossTarget = scanner.nextDouble();
        
        System.out.println("Enter monthly gain target (if user goal is 'bulk', otherwise 0): ");
        double monthlyGainTarget = scanner.nextDouble();
        
        // Create a user object
        User user = new User(userAge, userSex, userGoal, activityLevel, userWeight, userHeight, weeklyFatLossTarget, monthlyGainTarget);
        
        // Calculate TDEE and calorie requirements
        double tdee = user.calculateCalories();
        System.out.println("User's Total Daily Energy Expenditure (TDEE): " + tdee + " calories/day");
        
        // Connect to the database
        Connection connection = null;
        try {
            connection = ConnectionManager.connectToDatabase();
            
            // Retrieve food data from the database
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Food");
            
            // Variables to store food data and user requirements
            double proteinReq = 0;
            double fatReq = 0;
            double carbReq = 0;
            
            // Determine user requirements based on their goal
            if (userGoal.equalsIgnoreCase("cut")) {
                proteinReq = Proteins.calculateproteinCutIntake(userWeight);
                fatReq = FatsAndOils.calculateFatCutIntake(tdee);
                carbReq = Carbohydrates.calculateCarbIntake(tdee, proteinReq, fatReq);
            } else if (userGoal.equalsIgnoreCase("bulk")) {
                proteinReq = Proteins.calculateproteinBulkIntake(userWeight);
                fatReq = FatsAndOils.calculateFatBulkIntake(tdee);
                carbReq = Carbohydrates.calculateCarbIntake(tdee, proteinReq, fatReq);
            } else if (userGoal.equalsIgnoreCase("maintain")) {
                proteinReq = Proteins.calculateproteinMaintainIntake(userWeight);
                fatReq = FatsAndOils.calculateFatMaintainIntake(tdee);
                carbReq = Carbohydrates.calculateCarbIntake(tdee, proteinReq, fatReq);
            }
            
            // Variables to track the closest matches for each macronutrient
            Food proteinFood = null;
            Food fatFood = null;
            Food carbFood = null;
            
            // Initialize variables for tracking the smallest differences
            double closestProteinDiff = Double.MAX_VALUE;
            double closestFatDiff = Double.MAX_VALUE;
            double closestCarbDiff = Double.MAX_VALUE;
            
            // Iterate through the food data
            while (rs.next()) {
                // Retrieve food information
                String foodName = rs.getString("food_name");
                String foodGroup = rs.getString("food_group");
                int calories = rs.getInt("calories");
                
                // Create a Food object based on the food group
                Food food = null;
                if (foodGroup.equalsIgnoreCase("Protein")) {
                    food = new Proteins(foodName, calories);
                    
                    // Check if this food is the closest match for the user's protein requirements
                    double proteinDiff = Math.abs(food.getCalories() - proteinReq);
                    if (proteinDiff < closestProteinDiff) {
                        closestProteinDiff = proteinDiff;
                        proteinFood = food;
                    }
                } else if (foodGroup.equalsIgnoreCase("Fats and Oils")) {
                    food = new FatsAndOils(foodName, calories);
                    
                    // Check if this food is the closest match for the user's fat requirements
                    double fatDiff = Math.abs(food.getCalories() - fatReq);
                    if (fatDiff < closestFatDiff) {
                        closestFatDiff = fatDiff;
                        fatFood = food;
                    }
                } else if (foodGroup.equalsIgnoreCase("Carbohydrates")) {
                    food = new Carbohydrates(foodName, calories);
                    
                    // Check if this food is the closest match for the user's carb requirements
                    double carbDiff = Math.abs(food.getCalories() - carbReq);
                    if (carbDiff < closestCarbDiff) {
                        closestCarbDiff = carbDiff;
                        carbFood = food;
                    }
                }
            }
            
            // Print the food combination for the user
            System.out.println("Recommended food combination for the user:");
            if (proteinFood != null) {
                System.out.println("Protein food: " + proteinFood.getName() + " with " + proteinFood.getCalories() + " calories");
            }
            if (fatFood != null) {
                System.out.println("Fat food: " + fatFood.getName() + " with " + fatFood.getCalories() + " calories");
            }
            if (carbFood != null) {
                System.out.println("Carbohydrate food: " + carbFood.getName() + " with " + carbFood.getCalories() + " calories");
            }
            
            // Close the statement and result set
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        // Close the scanner
        scanner.close();
    }
}

