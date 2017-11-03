import net.jini.space.JavaSpace;

import java.rmi.RemoteException;

import net.jini.core.entry.Entry;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.lease.*;
import net.jini.core.transaction.TransactionException;

public class JRSetPriceAdvert implements Entry {
	AdGUI a;
	JavaSpace space;
	Integer advertID;
	String name;
	String description;
	Double price;
	String sellerName;
	long duration = 1000;
	/**Constructor for set price adverts.**/
	
	public JRSetPriceAdvert(Integer adID, String adName,
			String descr, Double adPrice, String seller) {
		advertID = adID.intValue();
		name = adName;
		description = descr;
		price = adPrice;
		sellerName = seller;		
	}
	
	public JRSetPriceAdvert() {
		space = SpaceUtils.getSpace();
		if (space == null) {
			System.err.println("Couldn't find javaspace");
			System.exit(1);
		}		
	}
	
	
	
	public Integer getAdvertID() {
		return advertID;
	}
	public void setAdvertID(Integer advertID) {
		this.advertID = advertID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	

}
