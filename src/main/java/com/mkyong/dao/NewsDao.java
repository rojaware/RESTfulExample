package com.mkyong.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class NewsDao {
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void run() {
		try {

			MongoClient mongo = getConnection();
			System.out.println("===> show dbs");

			// display all dbs
			List<String> dbnameList = getDatabaseList(mongo);
			System.out.println(StringUtil.print(dbnameList));

			// get news database
			List<String> newList = getNewsList();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param mongo
	 */
	public List<String> getNewsList() {
		List<String> newsList = new ArrayList<String>();
		try {
			MongoClient mongo = getConnection();

			System.out.println("===> use news");
			DB db = mongo.getDB("news");

			// display all tables from a db
			System.out.println("===> show collections");
			Set<String> tables = db.getCollectionNames();

			for (String coll : tables) {
				System.out.println(coll);
			}
			System.out.println(tables);
			// read users table
			System.out.println("===> db.news.find()");
			DBCollection table = db.getCollection("posts");
			BasicDBObject query = new BasicDBObject();
			DBCursor cursor = table.find(query);

			while (cursor.hasNext()) {
				DBObject o = cursor.next();
				String s = o.toString();
				newsList.add(s);
				System.out.println(s);
			}
			cursor.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newsList;
	}

	/**
	 * @param mongo
	 * @return
	 */
	public List<String> getDatabaseList(MongoClient mongo) {
		List<String> dbs = mongo.getDatabaseNames();
		List<String> dbnameList = new ArrayList<String>();
		for (String dbname : dbs) {
			System.out.println(dbname);
			dbnameList.add(dbname);
		}
		return dbnameList;
	}

	public static MongoClient getConnection() throws UnknownHostException {
		MongoClient mongo = new MongoClient("localhost", 27017);
		return mongo;
	}

	public static void main(String[] args) {
		System.out.println("MongoDB sample starts!");
		NewsDao app = new NewsDao();
		app.run();
	}
}
