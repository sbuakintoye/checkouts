package com.assessment.checkouts;
import java.util.*;

// price of item
public class prices {
	public static TreeMap<String, Double> priceOfItem = new TreeMap<String, Double>();
	
	static{
		priceOfItem.put("A", 50.0);
		priceOfItem.put("B", 30.0);
		priceOfItem.put("C", 20.0);
		priceOfItem.put("D", 15.0);
	}
}