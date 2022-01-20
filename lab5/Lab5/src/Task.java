import java.util.concurrent.Semaphore;

/**
 * 
 * @author bobby
 *
 */
public class Task implements Runnable {
	private String threadName;

	Semaphore leaderQ= new Semaphore(1);
	Semaphore followerQ= new Semaphore(1);
	int follower = 0;
	int leader = 0;
   

     Task(String task_1, IntegerObj total) {
    	threadName = task_1;
	    System.out.println("Creating " +  threadName );

    }
     /**
      *  leader prints the leader thread
      */
     public void leader()  {     	
	      try 
	      {	    	      	 	    	  

					System.out.println("Thread: " + threadName + " leader");
					// Let the thread sleep for a while.
					Thread.sleep(50);
				 
	      }
		      catch (InterruptedException e) {
		      System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      	  System.out.println("Thread " +  threadName + " exiting.");
	   }
     /**
      *  follower prints the leader thread
      */
     public void follower() 
     {
    	 try 
	      {	    	      	 	    	  

					System.out.println("Thread: " + threadName + " follower" );
					// Let the thread sleep for a while.
					Thread.sleep(50);
				 
	      }
		      catch (InterruptedException e) {
		      System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      	  System.out.println("Thread " +  threadName + " exiting.");
	   }	 
     
    @Override   
    public void run()
    {   	
    	try {
	    	leaderQ.acquire();
	      } catch (InterruptedException e) {
	         System.out.println(e);
	      }
	    try {
	    	leader();
	    }finally {
	    	leaderQ.release();
	    }
	   }
    }
