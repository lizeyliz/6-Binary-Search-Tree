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

    //process left subtree (bottom up), then left subtree, then root
    public void printPostOrder(DatabaseNode root) {
        if (root == null) {
            return;
        }
        //use a stack in opposite order of what you want to do?
        //add all values to stack in opposite order and then read
        Stack<DatabaseNode> postorder = new Stack<>();
        postorder.push(root);
        while(!postorder.isEmpty()){
            DatabaseNode current = postorder.peek();
            //right first
            if(current.right != null) {
                postorder.push(current.right);
            }

            
        }

    }
}//end AlizaMethods