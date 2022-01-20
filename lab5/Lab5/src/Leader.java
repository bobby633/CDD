
import java.util.concurrent.Semaphore;
/**
 * 
 * @author bobby
 *
 */
public class Leader {
		Semaphore mutex= new Semaphore(1);
		Semaphore leaderQ= new Semaphore(0);
		Semaphore followerQ= new Semaphore(0);
		Semaphore rendezvous= new Semaphore(0);
		int Leaders= 0;
		int Followers=0;
		/**
		 * 
		 * @throws InterruptedException
		 */
	public void Leaders() throws InterruptedException {
	mutex.wait();
		
		if(Followers > 0) {
			Followers--;
			followerQ.release();
		}
		else {
			Leaders++;
		mutex.release();
		leaderQ.wait();
		System.out.print("Leader");
			rendezvous.wait();
			mutex.release();
		}
		if (Leaders>0) {
		Leaders -- ;
		leaderQ.release();
		}
	}
		
	public void Followers() throws InterruptedException{
		mutex.wait();
		
		if (Leaders > 0) {
			   Leaders--;
			   leaderQ.release();
		}
			else {
				Followers++;
				mutex.release();
				followerQ.wait();
				System.out.print("Follower");
				rendezvous.wait();
			}
			if(Followers > 0) {
				Followers--;
				followerQ.release();
			}
		}
	
	
}
