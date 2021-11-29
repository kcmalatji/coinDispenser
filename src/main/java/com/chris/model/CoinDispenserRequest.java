package com.chris.model;


public class CoinDispenserRequest {
	private String amount;
	private String denominators;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "AmountRequest [amount=" + amount + ", getAmount()=" + getAmount() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
