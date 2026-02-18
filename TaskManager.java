import java.util.Scanner;

public class TaskManager implements TaskManagerInterface {

    public void add(UserInterface user, Scanner scanner) {

        boolean isAddingMoreTasks = true;
        boolean isInAddMenu = true;
        boolean isTaskListEmpty = TaskUtilities.checkTask(user);

        if (isTaskListEmpty == true) {
            System.out.println("No Task Available,Please Enter A Task");
        }

        while (isInAddMenu || isAddingMoreTasks) {
            try {
                System.out.println("Enter Your Task Title");
                String title = scanner.nextLine();
                if (title.equals("Exit")) {
                    throw new Exception();
                }

                TaskInterface task = new Task(null, "To Do", title);

                for (int i = 0; i < user.getTaskArray().length; i++) {
                    if (user.getTaskArray()[i] == null) {
                        user.getTaskArray()[i] = task;
                        System.out.println("Title Added Successfully");
                        break;
                    } else if (user.getTaskArray() != null) {
                        continue;
                    }
                }

                boolean isWaitingForValidDescriptionChoice = true;

                while (isWaitingForValidDescriptionChoice == true) {
                    System.out.println("Do You Want To Add Description?(Yes/No) Or Enter Exit!");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    System.out.println("Enter Your Choice:");

                    String choicetoadd = scanner.nextLine();

                    if (choicetoadd.equals("Exit")) {
                        throw new Exception();
                    }

                    if (choicetoadd.equals("1")) {
                        System.out.println("Enter your Description");
                        String description = scanner.nextLine();

                        if (description.equals("Exit")) {
                            throw new Exception();
                        }

                        for (int i = 0; i < user.getTaskArray().length; i++) {
                            if (user.getTaskArray()[i] != null) {
                                if (user.getTaskArray()[i].getTaskTitle().equals(title)) {
                                    user.getTaskArray()[i].setTaskDescription(description);
                                    System.out.println("Description Added Successfully");
                                    break;
                                }
                            }
                        }
                        isWaitingForValidDescriptionChoice = false;

                    } else if (choicetoadd.equals("2")) {
                        System.out.println("Title Is Added Without Any Description");
                        isWaitingForValidDescriptionChoice = false;

                    } else {
                        System.out.println("Give Correct Choice");
                    }
                }

                System.out.println("Do You Want To Add Another Task?(Yes/Exit)");
                String anotherchoice = scanner.nextLine();

                if (anotherchoice.equals("Exit")) {
                    throw new Exception();

                } else if (anotherchoice.equals("Yes")) {
                    isAddingMoreTasks = false;

                } else {
                    System.out.println("Give Correct Choice");
                }

            } catch (Exception e) {
                System.out.println("You Are Exiting");
                isInAddMenu = false;
                isAddingMoreTasks = false;
            }
        }
    }

    public void list(UserInterface user, Scanner scanner) {

        boolean isInListMenu = true;

        while (isInListMenu) {

            System.out.println("What Needs Be Listed?");
            System.out.println("1. All Task");
            System.out.println("2. All Title");
            System.out.println("3. All To Do");
            System.out.println("4. All In Progress");
            System.out.println("5. All Done");
            System.out.println("Enter What Needs To Be Listed? or Enter Exit");

            String tolist = scanner.nextLine();

            try {
                if (tolist.equals("Exit")) {
                    throw new Exception();
                }

                if (tolist.equals("1")) {

                    boolean isTaskListEmpty = TaskUtilities.checkTask(user);

                    if (isTaskListEmpty == true) {
                        System.out.println("There Is No Task, Please Enter A Task");
                    }

                } else if (tolist.equals("2")) {

                    boolean isTitleFound = false;

                    for (int i = 0; i < user.getTaskArray().length; i++) {
                        if (user.getTaskArray()[i] != null) {
                            if (user.getTaskArray()[i].getTaskTitle() != null) {
                                System.out.print(i + 1);
                                System.out.print(" ");
                                System.out.println(user.getTaskArray()[i].getTaskTitle());
                                isTitleFound = true;
                            }
                        }
                    }

                    if (isTitleFound == false) {
                        System.out.println("Title Is Empty,Please Add One");
                    }

                } else if (tolist.equals("3")) {
                    TaskUtilities.listingstat(user, "To do");

                } else if (tolist.equals("4")) {
                    TaskUtilities.listingstat(user, "In Progress");

                } else if (tolist.equals("5")) {
                    TaskUtilities.listingstat(user, "Done");

                } else {
                    System.out.println("Give Correct Choice");
                }

            } catch (Exception e) {
                System.out.println("Exited from list ");
                isInListMenu = false;
            }
        }
    }

    public void update(UserInterface user, Scanner scanner) {

        boolean isInUpdateMenu = true;

        while (isInUpdateMenu) {

            boolean isTaskListEmpty = TaskUtilities.checkTask(user);

            if (isTaskListEmpty == true) {
                System.out.println("No Task,Please Add A Task");
                break;
            }

            try {

                if (isTaskListEmpty == false) {

                    int choiceforupdate = TaskUtilities.getChoice(scanner, user);

                    if (choiceforupdate == -1) {
                        System.out.println("Please Enter Valid Task Number");

                    } else if (choiceforupdate == -2) {
                        System.out.println("Please Enter Valid Task Number");
                    }

                    if (choiceforupdate != -1 && choiceforupdate != -2) {

                        if (choiceforupdate != -3) {

                            boolean shouldExitUpdateOptions = false;

                            while (shouldExitUpdateOptions == false) {

                                System.out.println("1.Status");
                                System.out.println("2.Description");
                                System.out.println("3.Title");
                                System.out.println("Enter Choice To Update Or Enter Exit");

                                String choicetoupdate = scanner.nextLine();

                                if (choicetoupdate.equals("Exit")) {
                                    throw new Exception();
                                }

                                if (choicetoupdate.equals("1")) {

                                    boolean isWaitingForValidStatusChoice = false;

                                    while (isWaitingForValidStatusChoice == false) {

                                        System.out.println("1.To Do");
                                        System.out.println("2.Done");
                                        System.out.println("3.In Progress");
                                        System.out.println("Enter Choice Or Enter Exit");

                                        String statuschoice = scanner.nextLine();

                                        if (statuschoice.equals("Exit")) {
                                            throw new Exception();
                                        }

                                        if (statuschoice.equals("1")) {
                                            user.getTaskArray()[choiceforupdate - 1].setTaskStatus("To Do");
                                            System.out.println("Task Status Is Updated Successfully");
                                            isWaitingForValidStatusChoice = true;

                                        } else if (statuschoice.equals("2")) {
                                            user.getTaskArray()[choiceforupdate - 1].setTaskStatus("Done");
                                            System.out.println("Task Status Is Updated Successfully");
                                            isWaitingForValidStatusChoice = true;

                                        } else if (statuschoice.equals("3")) {
                                            user.getTaskArray()[choiceforupdate - 1].setTaskStatus("In Progress");
                                            System.out.println("Task Status Is Updated Successfully");
                                            isWaitingForValidStatusChoice = true;

                                        } else {
                                            System.out.println("Give Correct Choice");
                                        }
                                    }
                                }

                                if (choicetoupdate.equals("2")) {

                                    System.out.println("Enter Task Description To Update");
                                    String taskforupdate = scanner.nextLine();

                                    if (taskforupdate.equals("Exit")) {
                                        throw new Exception();
                                    }

                                    user.getTaskArray()[choiceforupdate - 1].setTaskDescription(taskforupdate);
                                    System.out.println("Your Task Description Is Updated Successfully");
                                }

                                if (choicetoupdate.equals("3")) {

                                    System.out.println("Enter Task Title To Update");
                                    String title = scanner.nextLine();

                                    if (title.equals("Exit")) {
                                        throw new Exception();
                                    }

                                    user.getTaskArray()[choiceforupdate - 1].setTaskTitle(title);
                                    System.out.println("Your Task Title Updated Successfully");
                                }

                                if (choicetoupdate.equals("Exit")) {
                                    shouldExitUpdateOptions = true;

                                } else {
                                    System.out.println("Give Correct Choice");
                                }
                            }
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("You Are Exiting From Update");
                isInUpdateMenu = false;
            }
        }
    }

    public void delete(UserInterface user, Scanner scanner) {

        boolean isInDeleteMenu = true;

        while (isInDeleteMenu) {

            boolean isTaskListEmpty = TaskUtilities.checkTask(user);

            if (isTaskListEmpty == true) {
                System.out.println("There Is No Task To List");
                break;
            }

            try {

                if (isTaskListEmpty == false) {

                    int choicefordelete = TaskUtilities.getChoice(scanner, user);

                    if (choicefordelete == -3) {
                        throw new Exception();
                    }

                    if (choicefordelete == -2 || choicefordelete == -1) {
                        System.out.println("Please Enter Valid Task Number");
                        continue;

                    } else {
                        user.getTaskArray()[choicefordelete - 1] = null;
                        System.out.println("Deleted successfully");
                    }

                    for (int i = 0; i < user.getTaskArray().length; i++) {

                        if (user.getTaskArray()[i] != null) {
                            continue;
                        }

                        for (int j = i + 1; j < user.getTaskArray().length; j++) {

                            if (user.getTaskArray()[j] != null) {
                                user.getTaskArray()[i] = user.getTaskArray()[j];
                                user.getTaskArray()[j] = null;
                                break;
                            }
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("You Are Existing From Delete");
                isInDeleteMenu = false;
            }
        }
    }
}