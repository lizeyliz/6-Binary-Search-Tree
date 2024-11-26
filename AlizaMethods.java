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
        //nope this doesn't work bc we do need to ignore some values
        //when to pop?
        Stack<DatabaseNode> postorder = new Stack<>();
        //get to leftmost node
        DatabaseNode current = root;
        while(current.left != null) {
            postorder.push(current.left);
        }
        while(!postorder.isEmpty()){
            current = postorder.peek();
            //right first
            while(current.right != null) {
                postorder.push(current.right);
            }
            while(current.left != null) {
                postorder.push(current.left);
            }
        }//end while loop
    }//end printPostOrder
}//end AlizaMethods