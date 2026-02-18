
import java.util.Scanner;

public class UserManager implements UserManagerInterface{
    private User[] user = new User[5];
    Scanner sc =new Scanner(System.in);


    public UserInterface CheckUser(){
        System.out.println("Welcome To Task Manager");
        System.out.println("Enter Your Username");
        String username=sc.nextLine();
        System.out.print("Welcome ");
        System.out.println(username);
        User currentUser = null;
        boolean existinguser=false;
        for (int i = 0; i < user.length; i++) {
            if (user[i] != null) {
                if (user[i].getUsername().equals(username)) {
                    currentUser = user[i];
                    existinguser=true;
                    break;
                }
            }
        }
        if(existinguser==false) {
            currentUser = new User(username);
            for(int i=0;i<user.length;i++) {
                if(user[i]==null){
                    user[i] = currentUser;
                    break;
                }

            }
        }
        return currentUser;

    }
}
