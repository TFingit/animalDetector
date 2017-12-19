package animalDetector.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;

import com.alibaba.fastjson.JSONArray;
import com.baidu.aip.imageclassify.AipImageClassify;

public class DetectAnimal {
	//设置APPID/AK/SK
    public static final String APP_ID = "10547189";
    public static final String API_KEY = "kzgjVEFryuRFx7sB54n0IeAv";
    public static final String SECRET_KEY = "4l5zmOeC2LmhgnushZ9NNLGj3G7iDOeX";
    
    /**
     * 这个方法将传入的图片流交给百度AI进行识别
     * @return
     * @throws Exception 
     */
    public static Map<String,String> detectAnimal(InputStream imgStream) throws Exception{
    	//Map<String,String> result = new HashMap<>();
    	AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
    	 // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(10*1000);
        client.setSocketTimeoutInMillis(60000);
        HashMap<String, String> options = new HashMap<>();
        options.put("top_num", "1");
        byte[] data = inputStream2Byte(imgStream);
        JSONObject result = client.animalDetect(data, options);
        System.out.println(result+"--原始数据");
        String json = result.get("result").toString();
        String target = JSONArray.parseArray(json).get(0).toString();
        Map<String,String> end = com.alibaba.fastjson.JSONObject.toJavaObject(com.alibaba.fastjson.JSONObject.parseObject(target), Map.class);
        //System.out.println(end.get("name"));
       // Map<String,String> parse = (Map<String, String>) com.alibaba.fastjson.JSONObject.parse(result.get("result").toString());
        //System.out.println(parse.get("name"));
      //  String name = result.get("result").get("name");
	//	String score = result.get("result").get("score");
    	return end;
    }
    /**
     * 将inputStream转换成byte数组
     * @param is
     * @return
     * @throws Exception
     */
    private static byte[] inputStream2Byte(InputStream is) throws Exception{
    	try(
    			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
    	){
    		byte[] buffer = new byte[1024];
    		int flag;
    		while((flag=is.read(buffer))!=-1){
    			byteStream.write(buffer);
    		}
    		byte[] data = byteStream.toByteArray();
    		return data;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
}
