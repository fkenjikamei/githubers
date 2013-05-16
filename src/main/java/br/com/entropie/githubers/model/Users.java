package br.com.entropie.githubers.model;

import java.util.Set;

public class Users {
	private Set<User> users;

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public int total() {
		return users.size();
	}
	
	@Override
	public String toString() {
		return users.toString();
	}
}
