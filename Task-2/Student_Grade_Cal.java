// Input: Take marks obtained (out of 100) in each subject.
// Calculate Total Marks: Sum up the marks obtained in all subjects.
// Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
// average percentage.
// Grade Calculation: Assign grades based on the average percentage achieved.
// Display Results: Show the total marks, average percentage, and the corresponding grade to the user
import java.util.*;

public class Student_Grade_Cal {
      public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);

        System.out.println("STUDENT GRADING CALCULATOR");
        System.out.print("Total number of subjects: ");
        int n = sc.nextInt();
        int marks;

        int total = 0;
        for(int i=1; i<=n; i++){
            System.out.print("Enter the subject name: ");
            String sub = sc.next();
            while(true){
                System.out.print("Enter the Marks obtained in "+sub+" (out of 100): ");
                marks = sc.nextInt();
                if(marks>=0 && marks<=100){
                    break;
                }else{
                    System.out.println("Invalid marks entered please enter marks between 0 to 100");
                }
            }
            total += marks;    
        }
        double average = (double) total/n;

        String grade;
        if(average>=80){
            grade = "A";
        }else if(average>=60){
            grade = "B";
        }else if(average>=40){
            grade = "C";
        }else{
            grade = "F";
        }

        System.out.println("Total marks obtain: "+total+" out of "+n*100);
        System.out.println("Average percentage: " + average);
        System.out.println("Grade: " +grade);

        sc.close();
      }  
}
