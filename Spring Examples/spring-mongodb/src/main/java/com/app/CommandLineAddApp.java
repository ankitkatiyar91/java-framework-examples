package com.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

@Component
public class CommandLineAddApp {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void startApp() {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		String field = null, value;
		Map<String, String> map = new HashMap<String, String>();
		JSONObject jsonObject = new JSONObject();
		while (!input.equalsIgnoreCase("n")) {
			System.out.println("Enter field name:-");
			while (field == null || field.trim().length() == 0) {
				field = scanner.nextLine();
			}
			System.out.println("Enter value for this:-");
			value = scanner.nextLine();

			try {
				jsonObject.put(field, value);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			map.put(field, value);

			field = value = null;
			System.out.println("Want to enter more fields (Y/N):-");
			input = scanner.next();
		}
		/*
		 * org.springframework.data.mongodb.core.query.Query query=new
		 * org.springframework.data.mongodb.core.query.Query();
		 * query.getQueryObject().
		 * mongoTemplate.getDb().getMongo().getDB("varentry");
		 * mongoTemplate.getDb().command(JSON.parse(map.toString()).toString());
		 */
		/*
		 * BasicQuery query = new
		 * BasicQuery("db.varentry.insert("+jsonObject.toString()+")");
		 * mongoTemplate.executeQuery(query, "varentry", null);
		 */
		System.out.println("Data->" + jsonObject);

		/*
		 * Create basic db object
		 */
		DBObject basicDBObject = BasicDBObjectBuilder.start(map).get();
		System.out.println("DBObject-" + basicDBObject.toString());
		/*
		 * Get desired Collection
		 */
		DBCollection collection = mongoTemplate.getDb().getCollection(
				"varentry");
		
		/*
		 * Insert to that collection
		 */
		WriteResult result = collection.insert(basicDBObject);
		/*
		 * Printout added object
		 */
		System.out.println("You have added this Object-"+basicDBObject);
		/*
		 * Fetch all the objects
		 */
		DBCursor cursor = collection.find();
		System.out.println("%%%% Current Records %%%%");
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toString());
		}
		scanner.close();
	}

}
