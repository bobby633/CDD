
import java.util.concurrent.Semaphore;


/**
 * 
 * @author bobby
 *
 */
public class Task implements Runnable {
private String threadName;
protected int num;
Semaphore forks = new Semaphore(4);



    Task(String task_1, int number) {
    	threadName = task_1;
    	num = number;
	    System.out.println("Creating " +  threadName + num );

   }
   //add a timer so the last person can eat
    //atomic operation
    
    public void run()
    {
        try
        {	
        	int modulo = ((Task.this.num + 1) % 5);	
        	while (true){
            thinking();
        	forks.acquire();
        	
        	if(forks.tryAcquire(modulo))
        	{
            	System.out.println(threadName + " available "  + ( Task.this.num -1 ) + " | " + modulo);
        		forks.acquire(modulo); 
            	eating();
            	forks.release();
            	forks.release(modulo);
            	thinking();
        	}
        	else 
        	{
            	System.out.println(threadName + " not available " );
            	forks.release();
            	thinking();
        	}
        	
        	}



        	
		// Let the thread sleep for a while.
        	
        	
        
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    /**
     *  eating this is when they have gotten the forks and can eat
     */
    public void eating() 
    {
    	System.out.println(threadName + " eating " );
    	
    	
    }
    /**
     *  thinking they have to think for a random amount of time
     */
    public void thinking() 
    {
		try {

	    	System.out.println(threadName + " thinking " );
	    	Thread.sleep((long)(Math.random() * 1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
