import java.util.Scanner;

public class DatabaseTest {
    public static void main(String[] args) {

        DatabaseMethods database = new DatabaseMethods();
      
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
                case 1:  // ADD method
                    DatabaseNode newNode = database.createNode();
                    database.addNode(newNode);
                    break;
                case 2: // DELETE method
                    database.deleteNode();
                    break;
                case 3: // MODIFY method
                    database.modifyNode();
                    break;
                case 4: // LOOKUP method
                    database.lookupNode();
                    break;
                case 5:
                    System.out.println("Number of records: " 
                        + database.countRecords(database.getRoot()));
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            } // end Switch/Case
        } // end While loop 

        //hardcoding in adds
        /*DatabaseNode node1 = new DatabaseNode(50);
        DatabaseNode node2 = new DatabaseNode(25);
        DatabaseNode node3 = new DatabaseNode(35);
        DatabaseNode node4 = new DatabaseNode(80);

        database.add(node1);
        database.add(node2);
        database.add(node3);
        database.add(node4);*/

        //print in preorder
        //System.out.println("Pre-order traversal");
        //database.printPreorder(node1);

        //System.out.println();

        //print in order
        //System.out.println("In Order Traversal");
        //database.printInOrder(node1);

    } // end public

    
}  // end Test Class file