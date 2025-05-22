package restaurant;

import java.util.*;
import main.*;
import people.*;

public class Restaurant {
	private String name;
	private List<Menu> menus;
	private List<Chef> chefs;
	private int total;
	
	public Restaurant(String name) {
		this.name = name;
		this.menus = new ArrayList<>();
		this.chefs = new ArrayList<>();
		this.total = 0;
	}

	public void addMenu(Menu mainCourse) {
		menus.add(mainCourse);
	}

	public void addChef(Chef chef) {
		chefs.add(chef);
	}

	public void showMenu() {
		System.out.println("Restaurant: " + name);
		System.out.println();
		System.out.println("Menus: ");
		for(Menu menu : menus) {
			System.out.println(" Category: " + menu.getName());
			for(Food food : menu.getFoods()) {
				System.out.println("  - " + food.getName() + " - " + food.getPrice());
			}
			System.out.println();
		}
	}

	public void showChef() {
		System.out.println("Chefs: ");
		for(Chef chef : chefs) {
			System.out.println(" - " + chef.getName());
		}
		System.out.println();
	}

	public void order(Chef chef, Visitor visitor, String name, int quantity) {
		for(Menu menu : menus) {
			for(Food food : menu.getFoods()) {
				if(food.getName().equals(name)) {
					total += food.getPrice() * quantity;
					chef.addCookHistory(name, quantity);
					visitor.addTotalPrice(food.getPrice() * quantity);
				}
			}
		}
	}

	public void showTotalIncome() {
		System.out.println();
		System.out.println("Total Income: " + total);
	}
}
