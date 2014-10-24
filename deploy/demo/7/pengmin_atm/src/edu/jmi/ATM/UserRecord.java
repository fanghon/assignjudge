package edu.jmi.ATM;

public class UserRecord {

	String user;
	String password;
     int yuer;
	public UserRecord(){
		
	}
	public UserRecord(String user, String password, int yuer) {
		this.user=user;
		this.password=password;
		this.yuer= yuer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getYuer() {
		return yuer;
	}
	public void setYuer(int yuer) {
		this.yuer = yuer;
	}

}
