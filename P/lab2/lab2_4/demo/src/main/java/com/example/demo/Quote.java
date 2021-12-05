package com.example.demo;

public class Quote {

	private String show_name;
	private String show_quote;

	public Quote(String show_name, String show_quote) {
		this.show_name = show_name;
		this.show_quote = show_quote;
	}

	public String getName() {
		return this.show_name;
	}

    public String getQuote() {
		return this.show_quote;
	}
}