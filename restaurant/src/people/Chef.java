package people;

import java.util.*;

public class Chef {
	private String name;
	private List<String> cookHistory;
	
	public Chef(String name) {
		this.name = name;
		this.cookHistory = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
	
	public List<String> getCookHistory() {
		return cookHistory;
	}
	
	public void addCookHistory(String name, int quantity) {
		cookHistory.add(name + " - " + quantity);
	}

	public void showCookHistory() {
		System.out.println();
		System.out.println(name + "'s Cook History: ");
		for(String history : cookHistory) {
			System.out.println(" - " + history);
		}
	}

}
