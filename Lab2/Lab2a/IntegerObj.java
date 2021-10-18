import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author bobby
 *
 */

public class IntegerObj {
	
	AtomicInteger value;
	/**
	 * 
	 * @param val the value is gotten and converted to an Atomic value
	 */
    IntegerObj(int val) {
    	AtomicInteger Aval = new AtomicInteger(val);
        this.value = Aval;
    }
    /**
     * 
     * @return the atomic integer value that has been incremented
     */
   synchronized AtomicInteger inc(){
        value.incrementAndGet();
        return this.value;
   }
}
