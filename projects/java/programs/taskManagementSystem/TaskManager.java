package taskManagementSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import taskManagementSystem.Task.PRIORITY;

public class TaskManager {
    private ArrayList<Task> tasks;

    TaskManager() {
        this.tasks = new ArrayList<>();
    }

    // methods
    void addTask(String title, String description, PRIORITY priority) {
        tasks.add(new Task(title, description, priority));
    }

    void showTasks() {

        if (tasks.isEmpty())
            return;

        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    void deleteTask(int id) {
        if (tasks.removeIf(t -> t.getId() == id)) {
            System.out.println("deletion success");
        }
    }

    Task searchTask(int id) {
        for (Task t : tasks) {
            if (t.getId() == id)
                return t;
        }

        return null;
    }

    void markCompleted(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setCompleted(true);
                System.out.println("marked successfully as completed!");
            }
        }
    }

    // sorting
    void filterBy(boolean completed) {
        for (Task t : tasks) {
            if (t.isCompleted() == completed) {
                System.out.println(t);
            }
        }
    }

    void filterBy(PRIORITY p) {
        for (Task t : tasks) {
            if (t.getPriority() == p) {
                System.out.println(t);
            }
        }
    }

    // persistence
    void saveTasks() {
        // save tasks into file names savedTasks.txt

        try {

            FileWriter writer = new FileWriter("savedTasks.txt");

            for (Task t : tasks) {
                writer.write(t.toFileString());
            }
            System.out.println("data saved successfully!");
            writer.close();

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }

    // in progress
    // void loadTasks() {

    //     try {

    //         File obj = new File("savedTasks.txt");
        
    //     } catch (FileNotFoundException e) {
    //         System.out.println("Error");
    //         e.printStackTrace();
    //     }
    // }

}
