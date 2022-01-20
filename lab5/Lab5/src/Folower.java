import java.util.concurrent.Semaphore;
/**
 * 
 * @author bobby
 *
 */
public class Folower {
	Semaphore mutex= new Semaphore(1);
	Semaphore leaderQ= new Semaphore(0);
	Semaphore followerQ= new Semaphore(0);
	Semaphore rendezvous= new Semaphore(0);
		/**
		 * 
		 * @throws InterruptedException exception  is thrown 
		 */
	public Folower() throws InterruptedException {
		int Leaders = 0;
		int followers = 0;
		mutex.wait();
		
	if (Leaders > 0) {
		   Leaders--;
		   leaderQ.release();
	}
		else {
			followers++;
			mutex.release();
			followerQ.wait();
			System.out.print("Follower");
			rendezvous.wait();
		}
		if(followers > 0) {
			followers--;
			followerQ.release();
		}
	}

}
