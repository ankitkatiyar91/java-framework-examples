

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Data {

	
	/*get the data of a result set in the form of a map that contains arraylist of string*/
	public Map<Integer, ArrayList<String>> getDataMap(ResultSet rst)
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
					//System.out.println("value set" + rst.getString(j+1));
				}
				map.put(i, ar);
				/*System.out.println("list stted of size--"+ar.size());
				System.out.println("Size of map="+map.size());
				System.out.println("list clered now of size--"+ar.size());*/
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}
}
