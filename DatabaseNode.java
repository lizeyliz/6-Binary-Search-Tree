//object class
public class DatabaseNode {
    //instance variables
    private int idNum; //9 digit
    //pointing to left and right
    DatabaseNode left;
    DatabaseNode right;
    
    //constructor
    public DatabaseNode(int idNum){
        this.idNum = idNum;
    }//end constructor

    public int getID(){
        return idNum;
    }//end getID

    public void setID(int newID) {
        this.idNum = newID;
    }//endsetID
}//end class DatabaseNode
