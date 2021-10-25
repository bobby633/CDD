

/**
 * 
 * @author bobby
 *
 */

 class IntegerObj {
    int value;
    IntegerObj(int val) {
        this.value = val;
    }
    /**
     * 
     * @return return a value that has been incremented
     */
    synchronized int inc(){
        this.value++;
        return this.value;
    }
}
	 
   

