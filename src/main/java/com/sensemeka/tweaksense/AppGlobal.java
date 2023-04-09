package com.sensemeka .tweaksense;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class AppGlobal {
	static public final String FILE_UPLOAD_LOCAL_PATH = "C:/_projects/tweaksense/src/main/updn/";
	//static public final String FILE_UPLOAD_LOCAL_PATH = "/var/lib/tomcat9/updn/";

	static public Map sessionToMap(HttpSession session) {
		Map map = new HashMap();
		try {
			Enumeration enumer = session.getAttributeNames();
			while(enumer.hasMoreElements()) {
				String key = (String)enumer.nextElement();
				map.put(key, session.getAttribute(key));
			}
		}
		catch(Exception e) {		 
		}

		return map;
	}
}
