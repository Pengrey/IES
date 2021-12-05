package com.example.demo;

public class Show {

	private String show_name;
	private Integer show_id;

	public Show(String show_name, Integer show_id) {
		this.show_name = show_name;
		this.show_id = show_id;
	}

	public Integer getId() {
		return this.show_id;
	}

	public String getName() {
		return this.show_name;
	}
}