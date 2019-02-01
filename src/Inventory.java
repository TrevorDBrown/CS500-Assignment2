/*
 *	Assign2
 *	Trevor D. Brown - 1/31/2019
 *	Dr. Yang - CS 500-500 (Research Methods)
 *
 *	Inventory.java - the Inventory class, which represents the inventory of a given store.
 */

import java.util.*;		// util Package

public class Inventory {
		// Properties of an Inventory object
		ArrayList<Item> ourItems;		// ourItems - ArrayList<Items>; stores all items in the store.
		
		// Inventory constructor - default, parameterless; initializes the ourItems property.
		public Inventory() {
			ourItems = new ArrayList<>();
		}
		
		/*
		 * addItem - two parameters: itemID and quantityInStock; passes parameter to Item constructor, and
		 * adds new item to the ourItems ArrayList.
		 */
		public void addItem(int itemID, int quantityInStock) {
			this.ourItems.add(new Item(itemID, quantityInStock));
		}
		
		/*
		 * getItem(int itemID) - one parameter: itemID; finds the Item specified by itemID.
		 */
		public Item getItem(int itemID) {
			for (Item item: ourItems) {
				if (item.getItemID() == itemID) {
					return item;
				}
			}
			
			return new Item();
		}
		
		/*
		 * getAllItems - parameterless; returns the entire ArrayList<Item>
		 */
		public ArrayList<Item> getAllItems(){
			return this.ourItems;
		}
		
		/*
		 * getTotalItemsInStock - parameterless; returns the size of the ArrayList<Item>
		 */
		public int getTotalItemsInStock() {
			return this.ourItems.size();
		}
		
		/*
		 * getTotalQuantityInStock - parameterless; returns the total quantity in stock 
		 * (collective for all items)
		 */
		public int getTotalQuantityInStock() {
			int total = 0;
			
			for (Item item: this.ourItems) {
				total += item.getQuantityInStock();
			}
			
			return total;
		}
		
		/*
		 * getItemWithLargestQuantityInStock - parameterless; returns the Item object 
		 * with the largest quantityInStock value.
		 */
		public Item getItemWithLargestQuantityInStock() {
			Item largestItem = new Item();
			
			for (Item item: this.ourItems) {
				if (item.getQuantityInStock() > largestItem.getQuantityInStock()) {
					largestItem = item;
				}
			}
			
			return largestItem;
			
		}
		
		/*
		 * printAllItems - parameterless; prints a formatted list of all Items (itemID and quantityInStock)
		 */
		public void printAllItems() {
			System.out.println("Current Inventory");
			for (Item item: this.ourItems) {
				System.out.println(item);
			}
			System.out.println("");
		}
}
