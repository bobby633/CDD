
import java.util.concurrent.Semaphore;


/**
 * 
 * @author bobby
 *
 */
public class Task implements Runnable {
private String name;

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
       
        	//mutex.acquireUninterruptibly();
            for (int i = 0; i<500; i++)
            {
             
               
                if (i%100==0){
                   Thread.sleep(100); 
                }
                
            }
           
            System.out.println(name+" complete");
            
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

