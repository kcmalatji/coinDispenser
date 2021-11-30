package com.chris.model;


public class CoinDispenserRequest {
	private int amount;
	private String denominators;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDenominators() {
		return denominators;
	}

	public void setDenominators(String denominators) {
		this.denominators = denominators;
	}

	@Override
	public String toString() {
		return "CoinDispenserRequest [amount=" + amount + ", denominators=" + denominators + "]";
	}

}
