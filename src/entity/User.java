package entity;

public class User {
	private String userName;
	private String userPass;
	private int role;
	private String regTime;
	private int logNum;

	public static void showInfoTable ( ) {
		System.out.printf( "\t %-10s\t %-10s %-10s %-25s %-10s\n\n",
				"userName", "userPass", "role", "regTime", "logNum" );
	}
	public void showInfo ( ) {
		System.out.printf( "\t %-10s\t %-10s %-10s %-25s %-10s\n",
				this.userName, this.userPass, this.role, this.regTime, this.logNum );
	}













	public User ( ) {
		super( );
		// TODO Auto-generated constructor stub
	}
	public User ( String userName, String userPass, int role, String regTime, int logNum ) {
		super( );
		this.userName = userName;
		this.userPass = userPass;
		this.role = role;
		this.regTime = regTime;
		this.logNum = logNum;
	}
	public String getUserName ( ) {
		return userName;
	}
	public void setUserName ( String userName ) {
		this.userName = userName;
	}
	public String getUserPass ( ) {
		return userPass;
	}
	public void setUserPass ( String userPass ) {
		this.userPass = userPass;
	}
	public int getRole ( ) {
		return role;
	}
	public void setRole ( int role ) {
		this.role = role;
	}
	public String getRegTime ( ) {
		return regTime;
	}
	public void setRegTime ( String regTime ) {
		this.regTime = regTime;
	}
	public int getLogNum ( ) {
		return logNum;
	}
	public void setLogNum ( int logNum ) {
		this.logNum = logNum;
	}

}
