import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DatabaseMethods {

    DatabaseNode root; // top of tree
    ArrayList<Integer> listIDs = new ArrayList<>(); // stores all IDs
    //initialize scanner
    Scanner scan = new Scanner(System.in);

    public DatabaseMethods() {
        this.root = null;
    }// end constructor

    public DatabaseNode getRoot() {
        return root;
    }

    Scanner scanner = new Scanner(System.in);

    // ADD method //
    public void addNode(DatabaseNode newNode) {
        //System.out.print("Enter ID number: ");
        //int idNum = scanner.nextInt();
        //DatabaseNode newNode = new DatabaseNode(idNum);

        // if tree is empty
        if (root == null) {
            root = newNode;
            return; // end method here if root == null
        } // end if statement

        // starting from the top
        DatabaseNode current = root;
        DatabaseNode parent = null;

        // while loop for placement if tree is not empty
        while (true) { 
            parent = current;// loops until break is called
            if (newNode.getID() < current.getID()) {
                current = current.getLeftChild();
                if (current == null) {
                    parent.setLeftChild(newNode);
                    break;
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                        break;
                    }  // end inner if/else 2
                } // end inner if/else 1

                /*if (current.left == null) {
                    current.left = newNode; // insert to the left
                    break;
                } else {
                    current = current.left; // move to next node to the left
                } // end inner if/else 1 */
            } else if (newNode.getID() > current.getID()) {
                if (current.right == null) {
                    current.right = newNode; // insert to the right
                    break;
                } else {
                    current = current.right; // move to next node to the right
                } // end inner if/else 2
            } else { // if newNode is equal to current
                System.out.println("Node is a duplicate and cannot be placed.");
                break;
            } // end outer if/else
        } // end while loop
        System.out.println("Record added successfully.");
        System.out.println("Your ID number is: " + newNode.getID());
    }// end of ADD method

     //create a new node from user input
     public DatabaseNode createNode() {
        int idNum = generateID();

        System.out.println("Enter first name:");
        String firstName = scan.next();
        System.out.println("Enter last name:");
        String lastName = scan.next();
        System.out.println("Enter address:");
        scan.nextLine();
        String addy = scan.nextLine();
        System.out.println("Enter city:");
        String city = scan.nextLine();
        System.out.println("Enter state:");
        String state = scan.nextLine();
        System.out.println("Enter zipcode:");
        int zip = scan.nextInt();
        System.out.println("Enter email:");
        String email = scan.next();
        System.out.println("Enter phone number:");
        String phNum = scan.next();

        DatabaseNode newNode = new DatabaseNode(idNum, firstName, lastName, addy, city, state, zip, email, phNum);
        //test code
        System.out.println("ID number is " + idNum);
        return newNode;
    }

    // search BST using id number
    /*
     * public DatabaseNode search(int idNum, DatabaseNode root) {
     * // start at root
     * DatabaseNode current = root;
     * // traverse tree until correct number of null is found
     * while (current != null) {
     * if (idNum < current.getID()) {
     * current = current.left;
     * } else if (idNum > current.getID()) {
     * current = current.right;
     * } else if (idNum == current.getID()) {
     * return current;
     * } // end if/else
     * } // end while loop
     * return null; // if not found
     * }// end search
     */

    // generate random id number for extra credit (make sure there are no multiples)
    // hard code for now
    public int generateID() {
        int idNum = 0;
        // generate random number
        idNum = (int) (Math.random() * 1000000000);
        // check that idNum is unique
        while (listIDs.contains(idNum)) {
            idNum = (int) (Math.random() * 1000000000);
        }
        return idNum;
    }// end generateID method

    // DELETE method //
    public void deleteNode() {
        System.out.print("Enter ID number of record you want to delete: ");
        int idNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        root = delete(root, idNum);
        System.out.println("Record deleted successfully.");
    }
 
    private DatabaseNode delete(DatabaseNode root, int idNum) {
    
       // Base case: if the tree is empty
        if (root == null) {
            return null;
        }

        // Traverse the tree to find the node to delete
        if (idNum < root.getID()) {
            root.left = delete(root.left, idNum);
        } else if (idNum > root.getID()) {
            root.right = delete(root.right, idNum);
        } else {
            // Found the node to delete
            // Case 1: No child (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            DatabaseNode successor = findMin(root.right);
            root.setID(successor.getID()); // Replace the value
            root.right = delete(root.right, successor.getID()); // Remove successor
        }
           root = delete(root, idNum);
       System.out.println("Record deleted successfully.");

        return root;
    }
    // end DELETE method //

    // MODIFY method //
    public void modifyNode() {
     
        //get ID for node to modify
        System.out.print("Enter ID number of record you want to modify: ");
        int idNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        DatabaseNode node = search(idNum, root);

        //search the tree for the node with that id number, and assign it to current
        if (node == null) {//if no node exists with that id number
            System.out.println("Record not found.");
            return;
        }//end if statement

        //give choice of what to modify
        System.out.println("What data would you like to modify?");
        System.out.println("Choose one: 1) First name 2)Last name 3)Address 4)City 5)State 6)Zip code 7)email 8)Phone number");
        int userChoice = scan.nextInt();
        scanner.nextLine(); // Consume newline    
        System.out.print("Enter new value: ");
        String newValue = scanner.nextLine();
        scanner.nextLine(); // Consume newline

        switch (userChoice) {
            case 1: 
                node.setFirstName(newValue);
                break;
            case 2:
                node.setLastName(newValue);
                break;
            case 3:
                node.setAddy(newValue);
                break;
            case 4:
                node.setCity(newValue);
                break;
            case 5:
                node.setState(newValue);
                break;
            case 6:
                node.setZip(Integer.parseInt(newValue));
                break;
            case 7:
                node.setEmail(newValue);
                break;
            case 8:
                node.setPhNum(newValue);
                break;
            default:
                System.out.println("Invalid choice.");
        }
        System.out.println("Record modified successfully.");
            
            //add node that was created in the switch/case
            /*if (search(newID, root) != null) {
                System.out.println("New ID already exists. Modification failed.");
                return;
            }*/
            // Temporarily remove the node and reinsert it with the new ID
            /*root = deleteNode(root, idNum); // Remove the current node
            DatabaseNode newNode = new DatabaseNode(newID, current.getFirstName(), current.getLastName(), current.getAddy(), current.getCity(),
            current.getState(), current.getZip(), current.getEmail(), current.getPhNum());
            addNode(newNode);
            //addNodeWithID(newID); // Add a new node with the updated ID*/
           
    }  // end MODIFY method //

    // LOOKUP method
    public void lookupNode() {
        System.out.print("Enter ID number to lookup: ");
        int idNum = scanner.nextInt();
        scanner.nextLine(); // to get next line

        DatabaseNode node = search(idNum, root);
        if (node == null) {
            System.out.println("Record not found.");
            return;
        }

        System.out.print("Enter order (preorder, inorder or postorder): ");
        String order = scanner.nextLine();

        if (order.equalsIgnoreCase("preorder")) {
            printPreorder(node);
        } else if (order.equalsIgnoreCase("inorder")) {
            printInOrder(node);
        } else if (order.equalsIgnoreCase("postorder")) {
            printPostOrder();
        } else {
            System.out.println("Invalid order. Please choose either "
                + "'preorder', 'inorder' or 'postorder'.");
        }
        System.out.println();
    }

    // print PREORDER TRAVERSAL using Iteration//
    public void printPreorder(DatabaseNode root) {

        if (root == null) { // BST empty
            return;
        } // end if
        
        // creating a stack to hold tree values
        Stack<DatabaseNode> preorder = new Stack<>();
        // put the root in the stack
        preorder.push(root);

        while (!preorder.isEmpty()) {
            // remove current node from stack (so no repeats) and print it
            DatabaseNode current = preorder.pop();
            System.out.print(current.toString() + " ");
            
            // do right subtree first (bc stacks are read opposite way they are added to)
            if (current.getRightChild() != null) {
                preorder.push(current.getRightChild()); // adding right side values to stack
            } // end if statement

            // left subtree
            if (current.getLeftChild() != null) {
                preorder.push(current.getLeftChild());// adding left side values to stack
            } // end if statement
        } // end while loop
    }// end printPreorder method



// INORDER TRAVERSAL //
    public void printInOrder(DatabaseNode node) { // INORDER TRAVERSAL
        if (node == null)
            return;

        // left tree
        printInOrder(node.getLeftChild());

        //Print the current node's toString
        System.out.print(node.toString() + " ");

        // right tree
        printInOrder(node.getRightChild());
    }// end INORDER TRAVERSAL

// POST-ORDER TRAVERSAL //
    public void printPostOrder() {
        if (root == null) {
            System.out.println("Empty Database");
        } else {
            Stack<DatabaseNode> stack = new Stack<>();
            DatabaseNode current = root;
            boolean check = true;

            while (true) { // infinite loop until break
                // go to extreme left
                while (current != null && check) {
                    stack.push(current);
                    current = current.left;
                }
                if (stack.empty()) {
                    break;
                }
                // to avoid infinite loop
                if (current != stack.peek().right) {
                    current = stack.peek().right;
                    check = true;
                    continue;
                }
                // if not caught in any above special case
                current = stack.pop();
                System.out.print(current.toString() + " ");
                //System.out.print(current.getID() + " ");
                check = false;
            } // end outer while loop
        } // end it/else statement
    }// end PrintPostOrder method
    // end LOOKUP methods //

    // HELPER methods //
    private DatabaseNode findMin(DatabaseNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private DatabaseNode search(int idNum, DatabaseNode node) {
        if (node == null || node.getID() == idNum) {
            return node;
        }
        if (idNum < node.getID()) {
            return search(idNum, node.left);
        } else {
            return search(idNum, node.right);
        }
    }

    /*private void addNodeWithID(int idNum) {
        DatabaseNode newNode = new DatabaseNode(idNum);

        if (root == null) {
            root = newNode;
            return;
        }

        DatabaseNode current = root;
        while (true) {
            if (idNum < current.getID()) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            }
        }
    }*/

   

    //prints count using recursion
    public int countRecords(DatabaseNode node) {
        if (node == null) {
            return 0;//base case
        }
        // Traverse left subtree
        int left = countRecords(node.left);
        // Traverse right subtree
        int right = countRecords(node.right);
        int total = left + right;
        return total + 1;
    }//end countRecords method
}//end class
