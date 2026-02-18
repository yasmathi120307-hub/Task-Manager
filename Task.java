
public class Task implements TaskInterface {
    private String taskDescription;
    private String taskTitle;
    private String taskStatus;

    public Task(String taskDescription, String status, String title) {
        this.taskDescription = taskDescription;
        this.taskStatus = status;
        this.taskTitle = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }


    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}

