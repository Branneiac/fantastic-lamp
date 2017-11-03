import net.jini.space.JavaSpace;

public class JRBidAdvert {
	
	Integer advertID;
	String name;
	String description;
	Double minPrice;
	Double maxPrice;
	String sellerName;
	
	public JRBidAdvert(Integer adID, String adName,
			String descr, Double adPriceMin, Double adPriceMax, String seller) {
		advertID = adID.intValue();
		name = adName;
		description = descr;
		minPrice = adPriceMin;
		maxPrice = adPriceMax;
		sellerName = seller;		
	}

}
