
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
    static final int MAX_T = 4;             
  /**
   * 
   * @param args Creates and Execute the threads
   */
    public static void main(String[] args) throws InterruptedException,BrokenBarrierException{
    	
        IntegerObj total= new IntegerObj(0);
        // creates five tasks
    	Runnable prod = new Producer("producer",1);
    	Runnable prod1 = new Producer("producer",2);
    	Runnable con = new Consumer("consumer",1);
    	Runnable con1 = new Consumer("consumer",2);
    
    	
       
        
          
        // creates a thread pool with MAX_T no. of 
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);  
         
        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(prod);
        pool.execute(con);
        pool.execute(prod1);
        pool.execute(con1);
   
     
        // pool shutdown ( Step 4)
        pool.shutdown();    
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("total is: "+total.value);
        long startTime = System.nanoTime();

     // code

     long endTime = System.nanoTime();
     System.out.println("Took "+(endTime - startTime) + " ns"); 
    }
}
