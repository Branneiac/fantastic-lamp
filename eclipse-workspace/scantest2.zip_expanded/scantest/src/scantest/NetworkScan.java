package scantest;

import java.net.InetAddress;
import java.util.stream.IntStream;

public class NetworkScan {
	
	public static void getNetworkIPs() {
	    final byte[] ip;
	    try {
	        ip = InetAddress.getLocalHost().getAddress();
	    } catch (Exception e) {
	        return;     // exit method, otherwise "ip might not have been initialized"
	    }

	    IntStream.range(1, 254).parallel().forEach(i-> {
	        final int j = i;  // i as non-final variable cannot be referenced from inner class
	        new Thread(new Runnable() {   // new thread for parallel execution
	            public void run() {
	                try {
	                    ip[3] = (byte)j;
	                    InetAddress address = InetAddress.getByAddress(ip);
	                    String output = address.toString().substring(1);
	                    if (address.isReachable(1000)) {	      
	                        System.out.println(output + " is on the network");
	                    } else {
	                        System.out.println("Not Reachable: "+output);
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }).start();     // dont forget to start the thread
	    });
	}
}
