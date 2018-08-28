/*
 * This method provides an internal clock to the program
*/
package flight;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends Thread{
    public void run(){
        
        while(true){
            Flight.totalFastForward = Flight.totalFastForward + ((Flight.animationSpeed * 1000) - 1000); //define the totalFastForward value based on the animation speed
            long mlls = System.currentTimeMillis() + Flight.totalFastForward; //get the clock time, convert to visible time, set the output
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(mlls);
            String output = sdf.format(date);
            Flight.clockLabel.setText(output);
            
            try {
                Thread.sleep(1080); //run every second (but allow time for the program to run)
            } catch (InterruptedException ex) {
                //
            }
        }
    }
}
