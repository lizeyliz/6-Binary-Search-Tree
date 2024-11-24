import java.util.Scanner;

public class DatabaseTest {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Modify");
            System.out.println("4. Lookup");
            System.out.println("5. List number of records");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // add method
                    break;
                case 2:
                    // delete method
                    break;
                case 3:
                    // modify method
                    break;
                case 4:
                    // lookup method
                    break;
                case 5:
                    //System.out.println("Number of records: " + DatabaseMethods.countRecords());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            } // end Switch/Case
        } // end While loop
    } // end public
}  // end Test Class file