import java.util.concurrent.atomic.AtomicLongArray;

class AcmeSafeState implements State {
    private AtomicLongArray value;

    AcmeSafeState(int length) { value = new AtomicLongArray(length); }

    public int size() { return value.length(); }

    /**
     * This function is not thread safe. However, since it gets called
     * after the thread work, it will not affect the results.
    **/
    public long[] current() {
	long[] tmp = new long[this.size()];
	for (int i = 0; i < this.size(); ++i){
	    tmp[i] = this.value.get(i);
	}
	return tmp;
    }

    public void swap(int i, int j) {
	value.getAndDecrement(i);
	value.getAndIncrement(j);
    }
}
