
import java.util.Scanner;

public class TaskUtilities {

    public static boolean checkTask(UserInterface user) {
        boolean alreadylistedtask = true;
        for (int i = 0; i < user.getTaskArray().length; i++) {
            if (user.getTaskArray()[i] != null) {
                System.out.print(i + 1);
                System.out.print(" ");
                System.out.print("Title");
                System.out.print(" : ");
                System.out.println(user.getTaskArray()[i].getTaskTitle());
                System.out.print("Description");
                System.out.print(" : ");
                System.out.println(user.getTaskArray()[i].getTaskDescription());
                System.out.print("Status");
                System.out.print(" : ");
                System.out.println(user.getTaskArray()[i].getTaskStatus());
                alreadylistedtask = false;

            } else if (user.getTaskArray()[i] == null) {
                continue;
            }
        }
        return alreadylistedtask;
    }


    public static int getChoice(Scanner sc, UserInterface user) throws Exception {
        System.out.println("Enter Your Choice Or Enter Exit");
        String choice = sc.nextLine();
        if (choice.equals("Exit")) {
            throw new Exception();
        }
        try {
            Integer choiceForUpdateAndDelete = new Integer(choice);
            if (choiceForUpdateAndDelete < user.getTaskArray().length) {
                if (user.getTaskArray()[choiceForUpdateAndDelete - 1] != null) {
                    return choiceForUpdateAndDelete;
                } else {
                    return -1;
                }
            } else {
                return -2;
            }
        } catch (Exception e) {
            System.out.println("Please Enter Correct Choice");
            return -3;
        }
    }






    public static void listingstat(UserInterface user, String Status) {
        boolean thereisnovalue = false;
        for (int i = 0; i < user.getTaskArray().length; i++) {
            if (user.getTaskArray()[i] != null) {
                if (user.getTaskArray()[i].getTaskStatus().equals(Status)) {
                    System.out.print(i + 1);
                    System.out.print(" ");
                    System.out.print("TITLE: ");
                    System.out.println(user.getTaskArray()[i].getTaskTitle());
                    System.out.print("DESCRIPTION: ");
                    System.out.println(user.getTaskArray()[i].getTaskDescription());
                    System.out.print("STATUS: ");
                    System.out.println(user.getTaskArray()[i].getTaskStatus());
                    thereisnovalue = true;
                }
            }
        }
        if (thereisnovalue == false) {
            System.out.println("Your File Is Empty");
        }
    }
}

