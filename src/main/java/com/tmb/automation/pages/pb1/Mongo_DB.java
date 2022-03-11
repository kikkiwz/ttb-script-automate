package com.tmb.automation.pages.pb1;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.*;
import org.bson.Document;
import org.json.JSONObject;

/* This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class Mongo_DB {

	public Object mongoData(String host, String port, String username, String password, String dbName,
			String collection, String query1, String data1, String query2) {

		String URI = "mongodb://" + username + ":" + password + "@" + host + ":" + port + "/" + dbName;
		System.out.println("-------------URI--------------- " + URI);

		MongoClient mongo = new MongoClient(new MongoClientURI(URI));
		MongoDatabase db1 = mongo.getDatabase(dbName);
		MongoCollection<Document> data = db1.getCollection(collection);

		Object s1 = null;
		Object s2 = null;
		Object s3 = null;
		try {
			for (Document cur : data.find()) {
				// System.out.println("---------cursor1---- " + cur.toJson());
				JSONObject jo1 = new JSONObject(cur.toJson());
				s1 = jo1.toString();
				s2 = jo1.get(query1);
				// System.out.println("---------s1---- " + s1);
				// System.out.println("---------s2---- " + s2);
				if (s2.equals(data1)) {
					// System.out.println("---------s3---- " + s2);
					s3 = s1;
					break;
				}
			}
		} finally {
			mongo.close();
		}
		System.out.println("---------s1---- " + s1);
		System.out.println("---------s2---- " + s2);
		System.out.println("---------return---- " + s3);

		return s3;
	}

	public Object mongoObject(String host, String port, String username, String password, String dbName,
			String collection, String query1, String data1, String query2) {

		String URI = "mongodb://" + username + ":" + password + "@" + host + ":" + port + "/" + dbName;
		System.out.println("-------------URI--------------- " + URI);
		Object output = null;

		MongoClient mongo = new MongoClient(new MongoClientURI(URI));
		MongoDatabase db1 = mongo.getDatabase(dbName);
		MongoCollection<Document> doc = db1.getCollection(collection);
		try {
			BasicDBObject Query = new BasicDBObject();
			Query.put(query1, data1);

			FindIterable<Document> cursor = doc.find(Query);
			MongoCursor<Document> iterator = cursor.iterator();

			while (iterator.hasNext()) {
				System.out.println("---------next---- " + iterator.next());
				// System.out.println("---------next1---- " + iterator.next().size());
				// System.out.println("---------next2---- " +
				// iterator.next().getString(query2));
				output = iterator.next();
			}
		} catch (Exception e) {
		} finally {
			mongo.close();
		}
		return output;
	}

	public String mongoString(String host, String port, String username, String password, String dbName,
			String collection, String query1, String data1, String query2) {

		String output = null;

		String URI = "mongodb://" + username + ":" + password + "@" + host + ":" + port + "/" + dbName;
		System.out.println("-------------URI--------------- " + URI);

		MongoClient mongo = new MongoClient(new MongoClientURI(URI));
		MongoDatabase db1 = mongo.getDatabase(dbName);
		MongoCollection<Document> doc = db1.getCollection(collection);
		try {
			BasicDBObject Query = new BasicDBObject();
			Query.put(query1, data1);

			FindIterable<Document> cursor = doc.find(Query);
			MongoCursor<Document> iterator = cursor.iterator();

			while (iterator.hasNext()) {
				// System.out.println("---------next---- " + iterator.next());
				// System.out.println("---------next1---- " + iterator.next().size());
				System.out.println("---------next2---- " + iterator.next().getString(query2));
				output = iterator.next().getString(query2);
			}
		} catch (Exception e) {
		} finally {
			mongo.close();
		}
		System.out.println("---------output---- " + output);

		return output;
	}

}
