package com.assessment.checkouts;
import java.util.*;

// price discount class
public class priceDiscount {
	public static TreeMap<String, item> discountOnItem = new TreeMap<String, item>();
	
	static{
		discountOnItem.put("A", new item("A", 3, 130.0));
		discountOnItem.put("B", new item("B", 2, 45.0));
	}
	
	
}