
import java.util.Scanner;

public interface TaskManagerInterface  {
    public void add(UserInterface user, Scanner sc);
    public void list(UserInterface user, Scanner sc);
    public void update(UserInterface user, Scanner sc);
    public void delete(UserInterface user,Scanner sc);

}
