
import java.util.concurrent.BrokenBarrierException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author bobby
 *
 */
public class Main {
    
      // Maximum number of threads in thread pool
    static final int MAX_T = 5;             
  /**
   * 
   * @param args Creates and Execute the threads
   */
    public static void main(String[] args) throws InterruptedException,BrokenBarrierException{
    	
       
        // creates five tasks
        Runnable r1 = new Task("Philosopher 1",1);
        Runnable r2 = new Task("Philosopher 2",2);
        Runnable r3 = new Task("Philosopher 3",3);
        Runnable r4 = new Task("Philosopher 4",4);
        Runnable r5 = new Task("Philosopher 5",5);   
          
        // creates a thread pool with MAX_T no. of 
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);  
         
        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);
          
        // pool shutdown ( Step 4)
        pool.shutdown();    
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     System.out.println(" Finished "); 
    }
}
