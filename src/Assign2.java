/*
 *	Assign2
 *	Trevor D. Brown - 1/31/2019
 *	Dr. Yang - CS 500-500 (Research Methods)
 *
 *	Assign2.java - the main class for the program (includes main method)
 */

// Import Objects
import java.util.Collections;	// Collections object
import java.util.Scanner;		// Scanner object
import java.io.*;				// IO package

public class Assign2 {

	// main(String[] args) - main method for program.
	public static void main(String[] args) {
		// Declare an Inventory object, to store multiple Item objects
		Inventory ourInventory = new Inventory();
		
		// Read the contents of the inventory.txt file, and store its content as Item objects in ourInventory.
		readInventoryFile(ourInventory);
		
		// Execute tasks
		task1(ourInventory);
		task2(ourInventory);
		task3(ourInventory);
	}
	
	// void readInventoryFile(Inventory ourInventory) - opens and stores content of inventory.txt to given Inventory object.
	public static void readInventoryFile(Inventory ourInventory) {
		// Declare variables to be used in method:
		File inventoryFile = new File("inventory.txt");		// inventory.txt File object
		Scanner fin;		// Scanner object
		
		// Try/catch for reading inventory file.
		try {
			fin = new Scanner(inventoryFile);
			
			// While more content exists in the file, read the next line
			while(fin.hasNextLine()) {
				// Store the line of content as a new Item object.
				ourInventory.addItem(fin.nextInt(), fin.nextInt());
			}
			
			// Close the Scanner object.
			fin.close();
		}catch(Exception e) {
			// If any exception occurs, print the stack trace to the console.
			e.printStackTrace();
		}
	}
	
	// Task 1: Display stored inventory, ascending by quantityInStock
	public static void task1(Inventory ourInventory) {
		System.out.println("Task 1: ");
		// Print Inventory (before sort):
		ourInventory.printAllItems();
		// Sort ourInventory by Quantity In Stock
		Collections.sort(ourInventory.getAllItems(), new SortByQuantityInStock());
		// Print Inventory (after sort):
		ourInventory.printAllItems();
	}
	
	// Task 2: Compute and display the total number of appliances in stock.
	public static void task2(Inventory ourInventory) {
		System.out.println("Task 2:");
		System.out.println("Total Items in Stock: " + ourInventory.getTotalItemsInStock());
		System.out.println("Total Quantity in Stock: " + ourInventory.getTotalQuantityInStock() + "\n");
	}
	
	// Task 3: Display the id for the appliance which has the highest number in stock
	public static void task3(Inventory ourInventory) {
		System.out.println("Task 3:");
		Item largestItem = ourInventory.getItemWithLargestQuantityInStock();
		System.out.println("Item with largest number in stock: " + largestItem.getItemID() + 
				" (Quantity was " + largestItem.getQuantityInStock() + ")");
	}

}
