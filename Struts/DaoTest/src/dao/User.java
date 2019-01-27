package dao;

public class User {
	public String uName,uSirname;

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
		System.out.println("name is set");
	}

	public String getuSirname() {
		return uSirname;
	}

	public void setuSirname(String uSirname) {
		this.uSirname = uSirname;
		System.out.println("Sir name is set");
	}

	

}
