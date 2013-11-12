package cloud;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ruch.cloud.project.HBase;

public class Query {
	
	private static HBase hBase; 
	
	private final static String table_1 = "timeTable";
	private final static String table_2 = "userTable";
	
	private final static String teamMessage = "RuCh, 7164-7145-2270";
	
	public static  String heartbeat() {
		// TODO:current date
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return teamMessage + "\n" + ft.format(dNow);
	}

	// TODO: implement HBase search
	public static String search_tweets_by_time(String time) {
		HBase hBase = new HBase(table_1);
		String res = "";
		try {
			time=time.replace("+", "")
					.replace(":", "")
					.replace("-", "").trim();
			if(time.length() != 14)
				return "Wrong time format!";
			
			res = hBase.ServeScanTime(time);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
		return teamMessage + "\n" + res;
	}

	// TODO: implement HBase search
	public static String find_tweets_by_range(String userid_min,
			String userid_max) {
		HBase hBase = new HBase(table_2);
		String res = "";
		try {
			if (userid_min.trim().length() != 10 || userid_max.trim().length() != 10)
				return "Wrong users ID!";
			
			res = hBase.scanUidRange(userid_min, userid_max);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		return teamMessage + "\n" + res;
	}

	// TODO: implement HBase search
	public static String find_retweets_by_userid(String userid) {
		HBase hBase = new HBase(table_2);
		String res = "";
		try {
			if (userid.trim().length() != 10)
				return "Wrong users ID!";
			
			res = hBase.ServeScanRetweet(userid);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		return teamMessage + "\n" + res;
	}
}
