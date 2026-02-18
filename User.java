public class User implements UserInterface {
    private String username;
    private Task[] taskArray=new Task[5];

    public User(String username){
        this.username=username;
    }

    public String getUsername() {
        return username;
    }

    public TaskInterface[] getTaskArray() {
        return taskArray;
    }


}