//object class
public class DatabaseNode {
    
    //instance variables
    private int idNum; //9 digit
    //private String firstName;
    //private String lastName;
    //private String addy;
    //private String city;
    //private String state;
    //private int zip5;
    //private String email;
    //private String phNum;

    //pointing to left and right
    DatabaseNode left;
    DatabaseNode right;
    
    //constructor
    public DatabaseNode(int idNum){
        this.idNum = idNum;
       // this.left = null;
       // this.right = null;
    }//end constructor

    public int getID(){
        return idNum;
    }//end getID

    public void setID(int newID) {
        this.idNum = newID;
    }//endsetID

    public String toString() {
        return Integer.toString(getID());
    }
}//end class DatabaseNode
