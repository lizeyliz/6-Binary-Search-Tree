import java.util.Scanner;

public class DatabaseTest {
    public static void main(String[] args) {

        DatabaseMethods database = new DatabaseMethods();
      
        Scanner scanner = new Scanner(System.in);

        /*while (true) {
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
                    System.out.print("Enter ID number of record you want delete: ");
                    idNum = scanner.nextInt();
                    DatabaseNode.deleteNode(idNum);
                    System.out.println("Record deleted sucessfully.");
                    break;
                case 3:
                    // modify method
                    break;
                case 4:
                    System.out.print("Enter ID number to lookup: ");
                    idNum = scanner.nextInt();
                    scanner.nextLine(); // to get next line
                    System.out.print("Pick order (preorder, inorder, postorder): ");
                    String order = scanner.nextLine();
                    // lookup(idNum, order);  Not sure about this.
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
        } // end While loop*/

        //hardcoding in adds
        DatabaseNode node1 = new DatabaseNode(50);
        DatabaseNode node2 = new DatabaseNode(25);
        DatabaseNode node3 = new DatabaseNode(35);
        DatabaseNode node4 = new DatabaseNode(80);

        database.add(node1);
        database.add(node2);
        database.add(node3);
        database.add(node4);
    } // end public
}  // end Test Class file