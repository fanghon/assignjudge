package edu.jmi.ATM;

import java.sql.Date;

public class ATMDetails {
	int id;
	String operation;//定义操作的类型
	int money;
	Date time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	ATMDetails()
	{
		
	}
	public ATMDetails(int id,String operation,int money,Date time){
		this.id=id;
		this.operation=operation;
		this.money=money;
		this.time=time;
		}
}