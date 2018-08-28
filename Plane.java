/*
 * This class creates the plane objects to be used in the main program
*/
package flight;

//import required resources
import java.awt.Point;
import java.util.ArrayList;

//define the class
public class Plane {
    //define the variables
    String ID;
    Point departLoc;
    long departTime;
    Point arriveLoc;
    long arriveTime;
    Passenger[] passengerArray;
    int[] seatingBooked;
    
    //create the contructor
    public Plane(String myID, Point mydepartLoc, long mydepartTime, Point myarriveLoc, long myarriveTime, Passenger[] myPassengerArray, int[] mySeatingBooked){
        ID = myID;
        departLoc = mydepartLoc;
        departTime = mydepartTime;
        arriveLoc = myarriveLoc;
        arriveTime = myarriveTime;
        passengerArray = myPassengerArray;
        seatingBooked = mySeatingBooked;
    }
    
    public void setPassengerArray(Passenger[] passengers){ //this method changes the passengerArray
        passengerArray = passengers;
    }
    
    public void setSeatingBooked(int[] seating){ //this method changes to seating array
        seatingBooked = seating;
    }
    
    //this method converts a point value to an airports
    public String getActualDepartLocation(){
        Point Vancouver = new Point(240, 540); //define coordinates of all airports
        Point Edmonton = new Point(370, 510);
        Point Iqualuit = new Point(770, 270);
        Point Winnipeg = new Point(560, 600);
        Point Toronto = new Point(790, 690);
        Point Ottawa = new Point(830, 650);
        Point Halifax = new Point(990, 590);
        
        //test the locations
        if (departLoc.equals(Vancouver)){
            return "Vancouver";
        } else if (departLoc.equals(Edmonton)){
            return "Edmonton";
        } else if (departLoc.equals(Iqualuit)){
            return "Iqualuit";
        } else if (departLoc.equals(Winnipeg)){
            return "Winnipeg";
        } else if (departLoc.equals(Toronto)){
            return "Toronto";
        } else if (departLoc.equals(Ottawa)){
            return "Ottawa";
        } else if (departLoc.equals(Halifax)){
            return "Halifax";
        } else{
            return "Unidentified Location";
        }
    }
    //Same method as above except for an arrival location
    public String getActualArrivalLocation(){
        Point Vancouver = new Point(240, 540);
        Point Edmonton = new Point(370, 510);
        Point Iqualuit = new Point(770, 270);
        Point Winnipeg = new Point(560, 600);
        Point Toronto = new Point(790, 690);
        Point Ottawa = new Point(830, 650);
        Point Halifax = new Point(990, 590);
        
        if (arriveLoc.equals(Vancouver)){
            return "Vancouver";
        } else if (arriveLoc.equals(Edmonton)){
            return "Edmonton";
        } else if (arriveLoc.equals(Iqualuit)){
            return "Iqualuit";
        } else if (arriveLoc.equals(Winnipeg)){
            return "Winnipeg";
        } else if (arriveLoc.equals(Toronto)){
            return "Toronto";
        } else if (arriveLoc.equals(Ottawa)){
            return "Ottawa";
        } else if (arriveLoc.equals(Halifax)){
            return "Halifax";
        } else{
            return "Unidentified Location";
        }
    }
}
