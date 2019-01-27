package dao;

public class UserLog {

	private User user;

	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String execute()
	{
		try {
		UserAction ac=new UserAction();
		ac.show(user);
		return "success";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
}
