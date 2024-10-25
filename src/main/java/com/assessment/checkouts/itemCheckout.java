package com.assessment.checkouts;
import java.util.*;

import com.assessment.checkouts.*;


public class itemCheckout {
	public static TreeMap<String, Integer> items = new TreeMap<String, Integer>();
	
	// Add item to the cart
	public static void addItem(String item, Integer quantity){
		if(!items.containsKey(item))
			items.put(item, quantity);  // Add a new item to the cart
		else
		{
			items.put(item, quantity + items.get(item)); // Update item with the quantity
		}
	}
	
	
	// Remove items from the cart
	public static void removeItem(String item, Integer quantity) throws Exception{
		if(!items.containsKey(item))
			throw new Exception("The item not found");  
		if(items.get(item) == quantity)
			items.remove(item);
		else if(items.get(item) > quantity)
			items.put(item, items.get(item) - quantity);
		else
			throw new Exception("More quantity provided");	
	}
	
	
	// Update item price
	public static void updatePrice(String item, Double price) throws Exception{
	
		if (price >= 0.0) {
			prices.priceOfItem.put(item, price);
		}
		else 
			throw new Exception("Invalid price value");
		
	}
	
	
	// preview the cart
	public static void cartReview()
	{
		if(items.isEmpty())
			System.out.println("Empty Cart!");
			
		// display the items with and  quantities
		Set<String> allItemsInCart = items.keySet();
		for(Iterator<String> i = allItemsInCart.iterator(); i.hasNext();){
			String item = i.next();
			Integer quantity = items.get(item);
			System.out.println("Item: "+ item + " of Quantity: " + quantity);
		}
	}
	
	
	// empty the cart
	public static void emptyCart(){
		items.clear();
	}
	
	
	// compute total price
	public static double totalPrice(TreeMap<String, Integer> items){
		Double total = 0.0;
		
		// compute the total value of each item and then add the total
		Set<String> keys = items.keySet();
		   for (Iterator<String> i = keys.iterator(); i.hasNext();) {
		     String item = i.next();
		     Integer quantity = items.get(item);
		     
		     // check and process the item discount 
		     if(priceDiscount.discountOnItem.containsKey(item)){
		    	 item offerDiscount = (item)priceDiscount.discountOnItem.get(item);
		    	 
		    	 if(offerDiscount.quantity < quantity)
		    	 {
		    		 total += (quantity % offerDiscount.quantity)*prices.priceOfItem.get(item) + (quantity / offerDiscount.quantity) * offerDiscount.price;
		    	 }
		    	 else if(offerDiscount.quantity == quantity)
		    	 {
		    		 total += offerDiscount.price;
		    	 }
		    	 else
		    	 {
		    		 total += (quantity)*prices.priceOfItem.get(item);
		    	 }
		     }
		     else 
		     {
		    	 total += (quantity)*prices.priceOfItem.get(item);
		     }
		   }
		
		return total;
	}
}