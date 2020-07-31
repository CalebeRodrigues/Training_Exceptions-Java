package model.entities;

import model.exceptions.DomainExceptions;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

		public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(Double amount){
		balance += amount;
	}
	
	public void withDraw(Double amount) {
		
		if(amount > withdrawLimit) {
			throw new DomainExceptions("The amount exceeds withdraw limit");
		}
		
		if(amount > balance) {
			throw new DomainExceptions("Not enough balance");
		}
			
		balance -= amount;
	}
	
	public String toString() {
		
		return "New balance: $ " + String.format("%.2f",balance); 
	}
}
