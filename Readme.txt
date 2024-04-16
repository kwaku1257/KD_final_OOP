# Nutrition Management Program

This program is designed to help users manage their nutrition by providing a random food combination based on the three major food groups: Protein, Carbohydrates, and Fats and Oils. The program takes input from the user regarding their age, sex, goal, activity level, weight, height, and desired targets for fat loss or weight gain. It then creates an array of `Food` objects by reading from a CSV file and randomly selects one food item from each category to provide a balanced meal plan.

## Features

- User Input: The program prompts the user for their age, sex, goal (cut, bulk, or maintain), activity level (Sedentary, Lightly Active, or Highly Active), weight, height, weekly fat loss target, and monthly gain target.
- CSV File Reading: The program reads a CSV file containing information about different types of food and their respective categories (Protein, Carbohydrates, and Fats and Oils) and creates instances of `Food` based on the file.
- Random Food Combination: The program randomly selects one food item from each of the three categories and prints out the selected food items to the user.

## How to Use

1. Prepare the CSV File: Ensure you have a CSV file containing the food information in the following format:

    'Chicken Breast', 'Protein'
    'Ground beef', 'Protein'
    'Boiled egg', 'Protein'
    'Tilapia', 'Protein'
    'Salmon', 'Protein'
    'Soybeans', 'Protein'
    'Potatoes', 'Carbohydrates'
    'White rice', 'Carbohydrates'
    'Pasta', 'Carbohydrates'
    'Boiled yam', 'Carbohydrates'
    'Avocado', 'Fats and Oils'
    'Palm oil', 'Fats and Oils'
    'Coconut oil', 'Fats and Oils'
    ```

    Replace the values with your own list of food items.

2. Update the Program: In the `Main` program, update the path to your CSV file in the `readFoodFromCSV` method:

    ```java
    readFoodFromCSV("path_to_csv_file.csv");
    ```

    In the provided code, 'db.csv' is used.

3. Compile and Run the Program: Compile and run the `Main` program.

4. Enter User Information: Follow the prompts provided by the program and enter the requested information about your age, sex, goal, activity level, weight, height, weekly fat loss target, and monthly gain target.

5. View Random Food Combination: After entering the required information, the program will read from the CSV file and print out a random food combination from the three major food groups: Protein, Carbohydrates, and Fats and Oils.

## Sample Output

After providing the required user information, the program will output a random food combination such as the following:

```
Random food combination:
Protein: Chicken Breast
Carbohydrate: Pasta
Fat/Oil: Avocado
```

## Note
- The program assumes that the user inputs are valid and within the expected range.
- Make sure the CSV file is formatted correctly as shown in the sample above.

---