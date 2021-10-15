/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author lixia
 */
public class User {
	
	private String username;
	private ArrayList<String> shoppinglist = new ArrayList<>();

	public User() {
	}

	public User(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<String> getShoppinglist() {
		return shoppinglist;
	}

	public void setShoppinglist(ArrayList<String> shoppinglist) {
		this.shoppinglist = shoppinglist;
	}
}