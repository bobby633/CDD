import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
	private String name;
	private int num;
	public Producer(String task_1,int total)  {
		// TODO Auto-generated constructor stub
		 name=task_1;
		 num= total;
	}
	int  BUFFER_SIZE = 5;
	Semaphore Mutex = new Semaphore(1);
	Semaphore Items = new Semaphore(0);
	Semaphore buff = new Semaphore(BUFFER_SIZE);
	int result;
	public void run() {
		while(true) 
		{
			try
		
			{
				for (int i = 0; i<500; i++)
	            {
	             
			 if (i%100==0){
                 Thread.sleep(100); 
              }
			
					Mutex.acquire();
					//Buffer.add(event);
					System.out.println(name + num);
					
					Items.release();
					Mutex.release();
					Thread.sleep(500);

	            }
			}
			catch(InterruptedException e)
	        {
	            e.printStackTrace();
	        }
	}
	}

}
