// Ryan Gunawan
// CS241-02 Project 1: Shopping Cart Management

import java.util.*;
import java.io.*;

public class Shop {
	public static void main(String[] args) throws Exception{
		if(args.length!=2) exit();
		new Shop(args[0],args[1]);
	}
		
	public static void exit(){
		System.out.println("Usage: java Shop <items file> <orders file>");
	}
	
	public Shop(String items_file, String orders_file) throws Exception{    	
        MyTreeMap <String, ArrayList<String>> orders = new MyTreeMap<>();        
        MyTreeMap <String, Integer> items = new MyTreeMap<>();
        ArrayList<String> storeCart;
                 
		// read items file to create inventory
		Scanner items_scanner=new Scanner(new File(items_file));
		while (items_scanner.hasNext()) {
			// substring ignores the dollar sign in front of the integer value
			items.put(items_scanner.next(),Integer.parseInt(items_scanner.next().substring(1)));
		}
		items_scanner.close();

        // read orders file to see the actions needed
        Scanner orders_scanner = new Scanner(new File(orders_file));
		while (orders_scanner.hasNext()) {
			// substring ignores the dollar sign in front of the integer value
//			items.put(items_scanner.next(),Integer.parseInt(items_scanner.next().substring(1)));
			switch(orders_scanner.next()){
				case ("add"): {
					String name = orders_scanner.next();
					String item = orders_scanner.next();
				
					if (!orders.containsKey(name)){
						storeCart = new ArrayList<String>();
						storeCart.add(item);
							
						orders.put(name, storeCart);
				    	System.out.println("-----------------------------------------------------");				
						System.out.println("### " + name + " has taken a cart! ###");
				    	System.out.println("Added [" + item + "] to " + name + "\'s cart.");
				     	System.out.println(name + "\'s cart: " + orders.get(name));
					} else {
						addItem(orders, name, item);					
					}
					break;
				}
				case("delete"): {
					String name = orders_scanner.next();
					String item = orders_scanner.next();
					deleteItem(orders, name, item);
					break;
				}
				case("cart"): {
					String name = orders_scanner.next();
					cart(orders, items, name);
					break;
				}
				case("checkout"): {
					String name = orders_scanner.next();					
					checkout(orders, items, name);
					break;
				}
				default:
					break;
			}
		}
		orders_scanner.close();
    }

    public static void addItem(MyTreeMap <String,ArrayList<String>>store, String name, String item){
    	System.out.println("-----------------------------------------------------");
    	ArrayList<String> tempCart = store.get(name);
    	if (!tempCart.contains(item)) {
	    	tempCart.add(item);
	    	System.out.println("Added [" + item + "] to " + name + "\'s cart.");
	     	System.out.println(name + "\'s cart: " + tempCart);
    	} else System.out.println(name + "\'s cart already has [" + item + "].");
    }
    
    public static void deleteItem(MyTreeMap <String,ArrayList<String>>store, String name, String item) {
    	System.out.println("-----------------------------------------------------");
    	if (store.containsKey(name)){
	    	ArrayList<String> tempCart = store.get(name);
	    	if (tempCart.contains(item)){
	    	tempCart.remove(item);
	    	System.out.println("Removed [" + item + "] from " + name + "\'s cart.");
	     	System.out.println(name + "\'s cart: " + tempCart);
	    	} else System.out.println("[" + item + "] not found in " + name + "\'s cart.");
    	} else System.out.println("[" + item + "] not found in " + name + "\'s cart.");
    }
    
    public static void cart(MyTreeMap <String,ArrayList<String>>store, MyTreeMap<String, Integer> items, String name) {
    	System.out.println("-----------------------------------------------------");
    	System.out.println("Viewing " + name + "\'s cart:");
    	System.out.println("---------------------------");
        ArrayList<String> tempCart = store.get(name);
        for (String x: tempCart) System.out.printf("%-20s $%5d %n", x, items.get(x));
    }
    
    public static void checkout(MyTreeMap <String,ArrayList<String>>store, MyTreeMap<String, Integer> items, String name){
    	System.out.println("-----------------------------------------------------");
        ArrayList<String> tempCart = store.get(name);
        Integer totalCost = 0;
        for (String x: tempCart) totalCost += items.get(x);	
    	System.out.println(name + " has checked out. Total: $" + totalCost);
    }
}