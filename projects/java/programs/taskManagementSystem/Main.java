package taskManagementSystem;

import java.util.Scanner;

import taskManagementSystem.Task.PRIORITY;

public class Main {

  public static void main(String[] args) {
    TaskManager taskManager = new TaskManager();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    System.out.println("Task Management CLI");
    System.out.println("-------------------");

    while (running) {
      printMenu();
      System.out.print("Choose an option: ");
      String input = scanner.nextLine().trim();

      switch (input) {
        case "1":
          System.out.print("Title: ");
          String title = scanner.nextLine().trim();

          System.out.print("Description: ");
          String description = scanner.nextLine().trim();

          PRIORITY priority = readPriority(scanner);
          taskManager.addTask(title, description, priority);
          System.out.println("Task added successfully.");
          break;

        case "2":
          System.out.println("All tasks:");
          taskManager.showTasks();
          break;

        case "3":
          Integer idToSearch = readInt(scanner, "Enter task id: ");
          if (idToSearch == null) {
            break;
          }
          Task found = taskManager.searchTask(idToSearch);
          if (found == null) {
            System.out.println("Task not found.");
          } else {
            System.out.println(found);
          }
          break;

        case "4":
          Integer idToComplete = readInt(scanner, "Enter task id to mark completed: ");
          if (idToComplete != null) {
            taskManager.markCompleted(idToComplete);
          }
          break;

        case "5":
          Integer idToDelete = readInt(scanner, "Enter task id to delete: ");
          if (idToDelete != null) {
            taskManager.deleteTask(idToDelete);
          }
          break;

        case "6":
          System.out.print("Show completed tasks only? (true/false): ");
          String completedInput = scanner.nextLine().trim();
          if ("true".equalsIgnoreCase(completedInput) || "false".equalsIgnoreCase(completedInput)) {
            taskManager.filterBy(Boolean.parseBoolean(completedInput));
          } else {
            System.out.println("Invalid input. Enter true or false.");
          }
          break;

        case "7":
          PRIORITY priorityFilter = readPriority(scanner);
          taskManager.filterBy(priorityFilter);
          break;

        case "8":
          taskManager.saveTasks();
          break;

        case "9":
          taskManager.saveTasks();
          running = false;
          System.out.println("Exiting Task Management CLI.");
          break;

        default:
          System.out.println("Invalid option. Please choose from the menu.");
      }
    }

    scanner.close();
    }

  private static void printMenu() {
    System.out.println();
    System.out.println("1. Add Task");
    System.out.println("2. Show All Tasks");
    System.out.println("3. Search Task by Id");
    System.out.println("4. Mark Task as Completed");
    System.out.println("5. Delete Task");
    System.out.println("6. Filter by Completion Status");
    System.out.println("7. Filter by Priority");
    System.out.println("8. Save Tasks");
    System.out.println("9. Save and Exit");
  }

  private static PRIORITY readPriority(Scanner scanner) {
    while (true) {
      System.out.print("Priority (LOW/MEDIUM/HIGH): ");
      String priorityInput = scanner.nextLine().trim().toUpperCase();

      try {
        return PRIORITY.valueOf(priorityInput);
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid priority. Please enter LOW, MEDIUM, or HIGH.");
      }
    }
  }

  private static Integer readInt(Scanner scanner, String prompt) {
    System.out.print(prompt);
    String input = scanner.nextLine().trim();
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      System.out.println("Invalid number.");
      return null;
    }
  }
}

