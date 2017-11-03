import net.jini.core.entry.*;
public class JRAdvertQueue implements Entry {

	public Integer nextAd;
	
	public JRAdvertQueue() {
		
	}
	
	public JRAdvertQueue(int n) {
        nextAd = new Integer(n);
    }
	
	 public void addJob() {
	        nextAd = new Integer(nextAd.intValue() + 1);
	    }
}
