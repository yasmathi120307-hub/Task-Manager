

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        UserManagerInterface userManager = new UserManager();
        while (true) {
            UserInterface user = userManager.CheckUser();
            Integer choice = 0;
            while (choice != 5) {

                System.out.println("1.Add Task");
                System.out.println("2.List All The Task");
                System.out.println("3.Update");
                System.out.println("4.Delete");
                System.out.println("5.Exit");
                System.out.println("Enter Your Choice");
                try {
                    choice = new Integer(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid Choice ,Please Enter Correct Choice");

                }

                if (choice == 1) {
                    taskManager.add(user,scanner);
                }
                if (choice == 2) {
                    taskManager.list(user,scanner);
                }
                else if (choice == 3) {
                    taskManager.update(user,scanner);
                }
                else if(choice==4){
                    taskManager.delete(user,scanner);
                }
                else if (choice == 5) {
                    System.out.println("Thanks For Visiting The Task Manager");
                }
                else{
                    System.out.println("Enter Valid Choice");
                }
            }
        }
    }
}
