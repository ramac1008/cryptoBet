package com.dharbor.messagingstompwebsocket;

public class HelloMessage {

	private String name;
	private String bet;

	public HelloMessage() {
	}

	public HelloMessage(String name, String bet) {

		this.name = name;
		this.bet = bet;
	}

	public String getName() {
		return name;
	}

	public String getBet() {
		return bet;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBet(String bet) {
		this.bet = bet;
	}
}
