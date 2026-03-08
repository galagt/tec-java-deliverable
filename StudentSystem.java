import java.util.Scanner;

import controllers.StudentController;
import repository.StudentRepository;

public class StudentSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentRepository repository = new StudentRepository();
        StudentController studentController = new StudentController(repository, input);
        int option;
        do {
            System.out.print("╔══════════════════════════════════╗\n║     STUDENT SYSTEM v1.0          ║\n╠══════════════════════════════════╣\n║  1. Register students            ║\n║  2. View grades                  ║\n║  3. View statistics              ║\n║  4. Search student               ║\n║  5. Exit                         ║\n╚══════════════════════════════════╝\n\nYour choice: ");
            option = input.nextInt();
            switch (option) {
                //Register students
                case 1:
                    studentController.registerStudent();
                    break;
                //View grades
                case 2:
                    studentController.viewGrades();
                    break;
                //View statistics
                case 3:
                    studentController.viewStatistics();
                    break;
                //Search student
                case 4:
                    studentController.searchStudent();
                    break;
                //Exit
                case 5:
                    //just pass without error
                    System.out.println("Thanks for using the system!");
                    break;
                default:
                    System.out.println("Error: Invalid choice!");
                    break;
            }
        }
        while (option != 5);
        input.close();
    }
}
