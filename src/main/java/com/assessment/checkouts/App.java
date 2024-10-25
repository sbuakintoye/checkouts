package com.assessment.checkouts;
import com.assessment.checkouts.*;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App {
	private static final Logger logger = LogManager.getLogger(App.class);
	public static void main(String[] args) throws Exception {
		itemCheckout cout = new itemCheckout();
						
		// Input items, quantity and new price, and display total price 
		System.out.println("#################Items checkout################");
		
		System.out.println("");
		boolean carryOn = true;
		
	    do {
	    	// input item
	    	Scanner itemObj = new Scanner(System.in);
	    	String item;
	    	// validate item input
	    	do {
	    		System.out.print("Item (A-D): ");
		    	item = itemObj.next();
	    		if (!item.equals("A") && !item.equals("B") && !item.equals("C") && !item.equals("D")) {
	    			System.out.println("");
	    			logger.error("Invalid item");
                    System.out.println("Invalid item, please try again");
                    System.out.println("");
                }
	    	}while (!item.equals("A") && !item.equals("B") && !item.equals("C") && !item.equals("D"));
	        	    	
	    	// input quantity
	    	Scanner QuantityObj = new Scanner(System.in);
	    	System.out.print("Quantity: ");
	        
	        // validate quantity input
	        while (!QuantityObj.hasNextInt()) {
	        	System.out.println("");
	        	System.out.println("That's not a number!");
	            logger.error("Invalid value");
	            System.out.println("");
	            System.out.print("Quantity: ");
	            QuantityObj.next();
	        }
	         int quantity= QuantityObj.nextInt();
	       	        
	        // add item and quantity
	        cout.addItem(item, Math.abs(quantity));
	        
	        // update item price
	        double price;
	        Scanner priceObj = new Scanner(System.in);
	        System.out.print("New item price: ");
	        String priceString = priceObj.nextLine();
	        
	        // validate price input
	        if (priceString.equals("") || priceString.equals(" ")) {
	        	logger.warn("Empty input! old price will be used. ");
	        	price = prices.priceOfItem.get(item);
	        }else if (priceString.matches("-?\\d+(\\.\\d+)?")) { // valid double check
	            price = Double.parseDouble(priceString);
	        }else 
	        {
	        	logger.warn("Invalid input! old price will be used. ");
	        	price = prices.priceOfItem.get(item);	
	        }
	        cout.updatePrice(item, price);
	        
	        
	        try {
				cout.cartReview();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
	        // calculate total price
			Double totalPrice = cout.totalPrice(cout.items);
			System.out.println("Total Price: " + totalPrice);
	        System.out.println("");
	        
	        // remove item
	        Scanner removeObj = new Scanner(System.in);
	        System.out.print("Do you want to remove any item (Y/N)? ");
	        String rem = removeObj.next(); 
	        System.out.println("");
	        if (rem.equalsIgnoreCase("Y")) {
	        	// input item
		    	Scanner itemRemObj = new Scanner(System.in);
		    	String itemRem;
		    	// validate item input
		    	do {
		    		System.out.print("Item (A-D): ");
			    	itemRem = itemRemObj.next();
		    		if (!itemRem.equals("A") && !itemRem.equals("B") && !itemRem.equals("C") && !itemRem.equals("D")) {
		    			System.out.println("");
		    			logger.error("Invalid item");
	                    System.out.println("Invalid item, please try again");
	                    System.out.println("");
	                }
		    	}while (!itemRem.equals("A") && !itemRem.equals("B") && !itemRem.equals("C") && !itemRem.equals("D"));
		    	
		    	// input quantity
		    	Scanner QuantityRemObj = new Scanner(System.in);
		    	System.out.print("Quantity: ");
		        
		        // validate quantity input
		        while (!QuantityRemObj.hasNextInt()) {
		        	System.out.println("");
		        	System.out.println("That's not a number!");
		            logger.error("Invalid value");
		            System.out.println("");
		            System.out.print("Quantity: ");
		            QuantityRemObj.next();
		        }
		         int quantityRem= QuantityRemObj.nextInt();
		         try {
			 			cout.removeItem(itemRem, Math.abs(quantityRem));
			 		} catch (Exception e1) {
			 			// TODO Auto-generated catch block
			 			System.out.println(e1.toString());
			 		}
		         try {
						cout.cartReview();
					} catch (Exception e) {
						System.out.println(e.toString());
					}
		         
		 	// calculate total price
				Double totalRemPrice = cout.totalPrice(cout.items);
				System.out.println("Total Price: " + totalRemPrice);
		        System.out.println("");
	        	
	        }
	        
	        // query to add more item
	        Scanner resObj = new Scanner(System.in);
	        System.out.println("");
	        System.out.print("Is that all(Y/N)? ");
	        String res = resObj.next(); 
	        System.out.println("");
	        if (res.equalsIgnoreCase("Y")) {
	        	System.out.println("End of transaction");
	        	carryOn = false;
	        	System.exit(0);
	        }
	        
	        System.out.println("");
	    }
	    while (carryOn);
		
		
		
	}
}