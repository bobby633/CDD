
import java.util.concurrent.Semaphore;


/**
 * 
 * @author bobby
 *
 */
public class Task implements Runnable {
private String name;
private int arrivedSoFar = 0;
private int TotalThread = 3;


Semaphore mutex = new Semaphore(0);
Semaphore sema = new Semaphore(0);
    private IntegerObj total;
    /**
     * 
     * @param task_1 creates a task that gets executed 
     * @param total makes a total that gets shown at the end
     */
    public Task(String task_1, IntegerObj total) {
        name=task_1;
        this.total = total;
    }
   
    public void run()
    {
        try
        {	
        	
        	mutex.acquire();
        	arrivedSoFar ++;
        	if(arrivedSoFar < TotalThread) {
        		mutex.acquire();
        		sema.acquire();
        	}
        	else {
        		sema.acquire();
        		sema.release();
        	}
        	//mutex.acquireUninterruptibly();
            for (int i = 0; i<500; i++)
            {
            	
             
                total.inc();
               
                if (i%100==0){
                   Thread.sleep(100); 
                }
                
            }
           
            System.out.println(name+" complete");
            mutex.release();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
