import java.util.Stack;

public class DatabaseMethods {

    DatabaseNode root; // top of tree

    public DatabaseMethods() {
        this.root = null;
    }// end constructor

    // add a node to the binary search tree
    public void add(DatabaseNode newNode) {
        // if tree is empty
        if (root == null) {
            root = newNode;
            return; // end method here if root == null
        } // end if statement

        // starting from the top
        DatabaseNode current = root;
        // while loop for placement if tree is not empty
        while (true) { // loops until break is called
            if (newNode.getID() < current.getID()) {
                if (current.left == null) {
                    current.left = newNode; // insert to the left
                    break;
                } else {
                    current = current.left; // move to next node to the left
                } // end inner if/else 1
            } else if (newNode.getID() > current.getID()) {
                if (current.right == null) {
                    current.right = newNode; // insert to the right
                    break;
                } else {
                    current = current.right; // move to next node to the right
                } // end inner if/else 2
            } else { // if newNode is equal to current
                // add exception handling here
                System.out.println("Node is a duplicate and cannot be placed.");
                break;
            } // end outer if/else
        } // end while loop
    }// end add method

    // generate random id number for extra credit (make sure there are no multiples)
    // hard code for now
    /*
     * public int generateID(){
     * int idNum = 0;
     * //generate random number
     * idNum = (int)(Math.random() * 1000000000);
     * return idNum;
     * 
     * }
     */

    // print pre-order using iteration and stack
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
            System.out.print(current.getID() + " ");
            // do right subtree first (bc stacks are read opposite way they are added to)
            if (current.right != null) {
                preorder.push(current.right); // adding right side values to stack
            } // end if statement

            // left subtree
            if (current.left != null) {
                preorder.push(current.left);// adding left side values to stack
            } // end if statement
        } // end while loop
    }// end printPreorder

    // pre-order recursive from geeksforgeeks
    // https://www.geeksforgeeks.org/binary-search-tree-traversal-inorder-preorder-post-order/
    // use stack for iterative version?
    /*
     * public static void printPreorder(DatabaseNode node) {
     * if (node == null)
     * return;//base case
     * 
     * // Visit node
     * System.out.print(node.getID() + " ");
     * 
     * // Traverse left subtree
     * printPreorder(node.left);
     * 
     * // Traverse right subtree
     * printPreorder(node.right);
     * }
     */

    public void modifyID(int iD) {


    }// end modify method

    public void printInOrder(DatabaseNode node) { // INORDER TRAVERSAL
        if (node == null)
            return;

        // left tree
        printInOrder(node.left);
        System.out.print(node.getID() + " ");

        // right tree
        printInOrder(node.right);
    }// end inOrder method

    public void postOrder() {
        if (root == null) {
            System.out.println("Empty Database");
        } else {
            Stack<DatabaseNode> stack = new Stack<>();
            DatabaseNode current = root;
            boolean check = true;

            while (true) { //infinite loop until break
                //go to extreme left
                while (current != null && check) {
                    stack.push(current);
                    current = current.left;
                }
                if (stack.empty()) {
                    break;
                }
                //to avoid infinite loop
                if (current != stack.peek().right) {
                    current = stack.peek().right;
                    check = true;
                    continue;
                }
                //if not caught in any above special case
                current = stack.pop();
                System.out.print(current.getID() + " ");
                check = false;
            }//end outer while loop
        }//end it/else statement
    }// end postOrder method

    public void delete(int idNum) {
        root = deleteNode(root, idNum);
    }

    private DatabaseNode deleteNode(DatabaseNode root, int idNum) {
        // Base case: if the tree is empty
        if (root == null) {
            return null;
        }

        // Traverse the tree to find the node to delete
        if (idNum < root.getID()) {
            root.left = deleteNode(root.left, idNum);
        } else if (idNum > root.getID()) {
            root.right = deleteNode(root.right, idNum);
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
            root.right = deleteNode(root.right, successor.getID()); // Remove successor
        }

        return root;
    }

    private DatabaseNode findMin(DatabaseNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void lookup(DatabaseMethods database, String order) {
        if (order.equalsIgnoreCase("preorder")) {
            database.printPreorder(database.root);
        } else if (order.equalsIgnoreCase("inorder")) {
            database.printInOrder(database.root);
        } else {
            System.out.println("Invalid order. Please choose either 'preorder' or 'inorder'.");
        }
        System.out.println();

    }

}
