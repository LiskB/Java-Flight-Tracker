/*
 * This method handles the animation of the planes
*/
package flight;

import java.awt.Point;
import javax.swing.JLabel;

public class AnimatePlanes extends Thread{
    public void run(){
        while(true){
            //get locations of plane icons and add to array
            Point location1 = Flight.p1.getLocation();
            Point location2 = Flight.p2.getLocation();
            Point location3 = Flight.p3.getLocation();
            Point location4 = Flight.p4.getLocation();
            Point location5 = Flight.p5.getLocation();
            Point[] locations = {location1, location2, location3, location4, location5};
            
            //call the animation methods for each icon
            Flight.p1.setLocation(animate(location1, Flight.planes.get(0).arriveLoc));
            Flight.p2.setLocation(animate(location2, Flight.planes.get(1).arriveLoc));
            Flight.p3.setLocation(animate(location3, Flight.planes.get(2).arriveLoc));
            Flight.p4.setLocation(animate(location4, Flight.planes.get(3).arriveLoc));
            Flight.p5.setLocation(animate(location5, Flight.planes.get(4).arriveLoc));
            
            for (int i = 0; i < 5; i++){
                boolean tester = checkPlaneDest(locations[i], Flight.planes.get(i)); //check if the plane arrived
                if (tester == true){ //if arrived:
                    //find which plane will replace the current one
                    long soonestTime = (long)(Math.pow(2, 55)); //define a number that is surely bigger then any possible system time
                    int soonestTimeIndex = 0; //define the index
                    JLabel[] planeIcons = {Flight.p1, Flight.p2, Flight.p3, Flight.p4, Flight.p5}; //add icons to array
                    int futureSize = Flight.futurePlanes.size(); //get the size of the array
                    if (futureSize > 0){ //if there are planes upcoming:
                        for (int j = 0; j < futureSize; j++){
                            if (Flight.futurePlanes.get(j).departTime < soonestTime){
                                //if the soonest time is less than the current, set it, and set the index
                                soonestTimeIndex = j;
                                soonestTime = Flight.futurePlanes.get(j).departTime;
                            }
                        }
                        //set the arrived plane to the future plane with the soonest dpearture time
                        Flight.planes.set(i, Flight.futurePlanes.get(soonestTimeIndex));
                        Flight.futurePlanes.remove(soonestTimeIndex); //remove it from the future planes
                        Flight.dtm.removeRow(0); //remove the row  
                    } else{ //if no upcoming planes, generate a plane in the current one's place
                        Plane tempPlane = Flight.generateFuturePlane();
                        Flight.planes.set(i, tempPlane);
                    }
                    planeIcons[i].setLocation(Flight.planes.get(i).departLoc); //set the new location of the icon
                }
            }
            Flight.refreshTables(); //refresh the tables
            try {
                Thread.sleep(1000 / Flight.animationSpeed); //run x times every second (x is the animation speed)
            } catch (InterruptedException ex) {
                //
            }
        }
    }
    
    //This method checks if the plane has reached its destination
    public boolean checkPlaneDest(Point location, Plane plane){
        Point airport = plane.arriveLoc; //get the arrival location
        long differenceY = Math.abs(airport.y - location.y); //compare the distances in the x and y
        long differenceX = Math.abs(airport.x - location.x);
        if(((differenceY > -3)&&(differenceY < 3)) && ((differenceX > -3)&&(differenceX < 3))){ //if the plane is at the destination, return true
            return true;
        }
        return false; //else return false
    } 
    
    //This method creates the new location for each icon
    public Point animate(Point location, Point destination){
        int destinationX = destination.x; //get the destination location
        int destinationY = destination.y;

        double distanceX = destinationX - location.x; //find the x and y distances
        double distanceY = destinationY - location.y;

        double difference = 0; //define variable
        double xMovement = 0;
        double yMovement = 0;
        
        //if the x and y distances are the same, the plane can move diagonally
        if (Math.abs(distanceX) == Math.abs(distanceY)){
            if(distanceX >= 0){
                xMovement = 1;
            } else{
                xMovement = -1;
            }
            if (distanceY >= 0){
                yMovement = 1;
            } else{
                yMovement = -1;
            }
        } else if(Math.abs(distanceX) > Math.abs(distanceY)){ //if the x distance is greater, move 1 space in that direction
            if(distanceX >= 0){
                xMovement = 1;
            } else{
                xMovement = -1;
            }
        } else if (Math.abs(distanceY) > Math.abs(distanceX)){ //if the y distance is greater, move 1 space in that direction
            if (distanceY >= 0){
                yMovement = 1;
            } else{
                yMovement = -1;
            }
        }
        //create and return the generated point
        Point point = new Point((int)(location.x + xMovement), (int)(location.y + yMovement));
        return point;
    }
}
