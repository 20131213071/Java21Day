package java21Day;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Json {
	public void testJson(){
		String json = "{\"a\":[\"a1\",\"a2\",\"a1\"],"
				+ "    \"cb\":{\"a\":1},"
				+ "    \"d\":[\"a\",{\"a\":[1,20]},{\"a\":2},\"\"],"
				+ "    \"e\":\"b\"}";
		//解析成一个JSONObject
		JSONObject jsonObject = JSON.parseObject(json);
		//将a的value解析成一个JSONArray
		JSONArray jsonArray = jsonObject.getJSONArray("a");
		System.out.println(jsonArray);//输出["a1","a2","a1"]
		//解析成一个JSONObject
		JSONObject cd  = jsonObject.getJSONObject("cd");
		//获取cb下a的值
		Integer key = cd.getInteger("a");;

		System.out.println(key);//输出1
	}
	public void testJsonObject(){
		String json = "{\"retCode\":200,\"retMsg\":\"success.\"}";
		Json jsonObject = JSON.parseObject(json, Json.class);
		System.out.println(jsonObject);
		/*Object axis = 
		    jObject.getJSONObject("data").getJSONObject("health_rank").getJSONArray("x_axis").toString();
     	*/
		}


}
