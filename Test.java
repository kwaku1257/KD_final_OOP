import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int userAge = scanner.nextInt();
        System.out.println("Enter sex('M' or 'F': )");
        char userSex = scanner.next().charAt(0);
        System.out.println("Enter your goal (cut/bulk/maintain): ");
        String userGoal = scanner.next();
        System.out.println("Enter your activity level (Sedentary/Lightly Active/Highly Active): ");
        String activityLevel = scanner.next();
        System.out.println("Enter your weight in kilograms: ");
        double userWeight = scanner.nextDouble();
        System.out.println("Enter your height in centimeters: ");
        double userHeight = scanner.nextDouble();
        System.out.println("Enter your weekly fat loss target(Between 0.5% and 0.75%): ");
        double weeklyFatLossTarget = scanner.nextDouble();
        System.out.println("For monthly gain rate: ");
        System.out.println("Beginner: 2% (Totally new to training)");
        System.out.println("Novice: 1.5% (Still able to progress most training loads in the gym on a week to week basis)");
        System.out.println("Intermediate: 1% (Able to progress most training loads in the gym on a month to month basis)");
        System.out.println("Advanced: 0.5% (Progress is evident only when viewed over multiple months or a year)");
        System.out.println("Enter monthly gain target: ");
        double MonthlyGainTarget = scanner.nextDouble();
        

    }
}