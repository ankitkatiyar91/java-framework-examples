package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Data {
	
	public ArrayList<String> getData()
	{
		ArrayList<String> ar=new  ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/java","root","mysql");
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM login");
			ResultSet rst=stmt.executeQuery();
			ResultSet rst1=rst;
			ar=setData(rst);
			System.out.println("size of array list"+ar.size());
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}

	public ArrayList<String> setData(ResultSet rst)
	{
		ArrayList<String> ar=new ArrayList<String>();
		try {
			while(rst.next())
			{
				
					ar.add(rst.getString(1));
					ar.add(rst.getString(2));
					ar.add(rst.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
	
	//******************************
	
	public Map<Integer, ArrayList<String>>  getDataInMap()
	{
		Map<Integer, ArrayList<String>> map=new HashMap<Integer, ArrayList<String>>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bsplims","root","mysql");
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM employee_profile");
			ResultSet rst=stmt.executeQuery();
			map=setMultiRow(rst);
			
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}
	
	
	public Map<Integer, ArrayList<String>> setMultiRow(ResultSet rst)
	{	
		Map<Integer, ArrayList<String>> map=new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> ar=null;
		try {
			ResultSetMetaData rm= rst.getMetaData();
			int i=0;
			
			
			
			while (rst.next()) {
				ar=new ArrayList<String>();
				
				
				for (int j = 0; j < rm.getColumnCount(); j++) {
					ar.add(rst.getString(j+1));
					System.out.println("value set" + rst.getString(j+1));
				}
				map.put(i, ar);
				System.out.println("list stted of size--"+ar.size());
				System.out.println("Size of map="+map.size());
				
				System.out.println("list clered now of size--"+ar.size());
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}
	public static void main(String ar[])
	{
		Map<Integer, ArrayList<String>> map=( new Data()).getDataInMap();
		System.out.println("from map now---");
		System.out.println("size of map-"+map.size());
		Iterator<Integer> itr=map.keySet().iterator();
		while (itr.hasNext()) {
			System.out.println("value in iteraor-"+itr.next());
			
		}
		Iterator<ArrayList<String>> itrv=map.values().iterator();
		ArrayList<String> ars=null;
		while (itrv.hasNext()) {
			ars=itrv.next();
			System.out.println("contains"+ars.contains("ankit"));
			System.out.println("value in list---"+ars.size());
		}
	}
}
