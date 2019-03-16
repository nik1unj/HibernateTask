package com.nikunj.Demohibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	private String name;
	private String fname;
	private String lname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return " "+name+"\t\t" + fname + "\t\t " + lname+" ";
	}	
}
