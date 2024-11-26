import java.util.Stack;
import java.util.ArrayList;

public class AbbyMethods {
    DatabaseNode root; //top of tree
    ArrayList<Integer> listIDs = new ArrayList<>();

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
    }//end postOrder method

    public void postOrderRecursion(DatabaseNode node) {
        if (node == null) {
            return;
        }
        postOrderRecursion(node.left);

        postOrderRecursion(node.right);

        System.out.print(node.getID() + " ");
    }//end postOrder_recusrion method

    // generate random id number for extra credit (make sure there are no multiples)
    // hard code for now
    public int generateID(){
    int idNum = 0;
    //generate random number
    idNum = (int)(Math.random() * 1000000000);
    //check that idNum is unique
    while (listIDs.contains(idNum)) {
        idNum = (int)(Math.random() * 1000000000);
    }
    return idNum;
    }//end generateID method
    
}//end class
