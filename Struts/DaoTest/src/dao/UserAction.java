package dao;

public class UserAction {
	public  void show(User u)
	{
		try {
		System.out.println("user name-"+u.getuName());
		System.out.println("user sir name-"+u.getuSirname());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
