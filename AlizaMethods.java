//https://liveexample.pearsoncmg.com/dsanimation13ejava/BSTeBook.html
//Chat GPT

//Extra credit: iteration
import java.util.Stack;

public class AlizaMethods {
    DatabaseNode root; //top of tree

    //constructor: will change name later when adding to methods class
    public AlizaMethods() {
        this.root = null;
    }//end constructor

    //print pre-order using iteration and stack
    public void printPreorder(DatabaseNode root) {
        if (root == null) { //BST empty
            return;
        }//end if 
        //creating a stack to hold tree values
        Stack<DatabaseNode> preorder = new Stack<>();
        //put the root in the stack
        preorder.push(root);

        while(!preorder.isEmpty()){
            //remove current node from stack (so no repeats) and print it
            DatabaseNode current = preorder.pop();
            System.out.println(current.getID());
            //do right subtree first (bc stacks are read opposite way they are added to)
            if(current.right != null) { 
                preorder.push(current.right); //adding right side values to stack
            }//end if statement 

            //left subtree
            if (current.left != null){
                preorder.push(current.left);//adding left side values to stack
            }//end if statement
        }//end while loop
    }//end printPreorder
}//end AlizaMethods