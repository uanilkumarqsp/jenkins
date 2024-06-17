package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public String getDataFronJsonFile(String key) throws Throwable {
		FileReader fr = new FileReader(".\\jsondata\\appcommondata.json");
		
		JSONParser jr = new JSONParser();
		 Object ob = jr.parse(fr);
		 JSONObject map = (JSONObject) ob;
		 
		
		 return (String) map.get(key);
	}
}
