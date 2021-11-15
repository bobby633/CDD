import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
	private String name;
	private int num;
	public Consumer(String task_1,int total) {
		// TODO Auto-generated constructor stub
		 name=task_1;
		 num= total;
	}	
	Semaphore Items = new Semaphore(0);
	Semaphore Mutex = new Semaphore(1);
	
	
public void run() {
	while(true) {
		try {
			   
	             
			
		Items.acquire(1);
		Mutex.acquire();
		
		System.out.println(name + num);
		Mutex.release();
		//Event.process();
	            
		}
		catch(InterruptedException e)
        {
            e.printStackTrace();
        }
	}
}
}
