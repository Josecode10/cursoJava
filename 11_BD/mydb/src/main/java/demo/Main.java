package demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // We use a Scanner to get user input for the menu.
        Scanner scanner = new Scanner(System.in);
        int choice;

        // The main application loop.
        do {
            System.out.println("\n--- MySQL CRUD Application ---");
            System.out.println("1. Create Table");
            System.out.println("2. Insert Data");
            System.out.println("3. Read Data");
            System.out.println("4. Update Data");
            System.out.println("5. Delete Data");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                // Get the user's menu choice.
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                choice = 0;
            }

            // Execute the selected action.
            switch (choice) {
                case 1:
                    UserDAO.createTable();
                    break;
                case 2:
                    UserDAO.insertData(scanner);
                    break;
                case 3:
                    UserDAO.readData();
                    break;
                case 4:
                    UserDAO.updateData(scanner);
                    break;
                case 5:
                    UserDAO.deleteData(scanner);
                    break;
                case 6:
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

}
