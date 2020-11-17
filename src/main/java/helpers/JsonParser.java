package helpers;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonParser {
	
	protected static final String baseDirectory= System.getProperty("user.dir");

	public static Map<String, String> getAllXpathAndValueFromJsonObject(JSONObject json,
			Map<String, String> keyValueStore, Stack<String> keyPath) {
		Set<String> jsonKeys = json.keySet();

		for (Object keyO : jsonKeys) {
			String key = (String) keyO;
			keyPath.push(key);
			Object object = json.get(key);
			if (object instanceof JSONObject) {
				getAllXpathAndValueFromJsonObject((JSONObject) object, keyValueStore, keyPath);
			}
			if (object instanceof JSONArray) {
				doJsonArray((JSONArray) object, keyPath, keyValueStore, json, key);
			}
			if (object instanceof String || object instanceof Boolean || object.equals(null)
					|| object instanceof Integer || object instanceof Number ) {
				String keyStr = "";
				for (String keySub : keyPath) {
					keyStr += keySub + ".";
				}
				keyStr = keyStr.substring(0, keyStr.length() - 1);
				keyPath.pop();
				keyValueStore.put(keyStr, json.get(key).toString());
			}
		}
		if (keyPath.size() > 0) {
			keyPath.pop();
		}
		return keyValueStore;
	}

	public static void doJsonArray(JSONArray object, Stack<String> keyPath, Map<String, String> keyValueStore,
			JSONObject json, String key) {
		JSONArray arr = (JSONArray) object;
		for (int i = 0; i < arr.length(); i++) {
			keyPath.push(Integer.toString(i));
			Object obj = arr.get(i);
			if (obj instanceof JSONObject) {
				getAllXpathAndValueFromJsonObject((JSONObject) obj, keyValueStore, keyPath);
			}
			if (obj instanceof JSONArray) {
				doJsonArray((JSONArray) obj, keyPath, keyValueStore, json, key);
			}
			if (obj instanceof String || obj instanceof Boolean || obj.equals(null) || obj instanceof Integer) {
				String keyStr = "";
				for (String keySub : keyPath) {
					keyStr += keySub + ".";
				}
				keyStr = keyStr.substring(0, keyStr.length() - 1);
				keyPath.pop();
				keyValueStore.put(keyStr, json.get(key).toString());
			}
		}
		if (keyPath.size() > 0) {
			keyPath.pop();
		}
	}



	public Map<String, String> publishAllXpathInResponse(String s) {
		Map<String, String> keyValueStore = new HashMap<String, String>();
		Stack<String> keyPath = new Stack<String>();
		JSONObject json = new JSONObject(s);
		keyValueStore = JsonParser.getAllXpathAndValueFromJsonObject(json, keyValueStore, keyPath);
		for (Map.Entry<String, String> map : keyValueStore.entrySet()) {
			//System.out.println(map);
		}
		return keyValueStore;
	}

	public static String readJson(String FileName) {
		String json = null;
		try {
			String path = baseDirectory + "/src/test/resources/" + FileName;
			JSONParser parser = new JSONParser();
			Object data = parser.parse(new FileReader(path));
			json = data.toString();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return json;
	}
	



}
