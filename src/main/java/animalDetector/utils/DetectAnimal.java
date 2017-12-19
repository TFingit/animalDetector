package animalDetector.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.baidu.aip.imageclassify.AipImageClassify;

public class DetectAnimal {
	//设置APPID/AK/SK
    public static final String APP_ID = "10547189";
    public static final String API_KEY = "kzgjVEFryuRFx7sB54n0IeAv";
    public static final String SECRET_KEY = "4l5zmOeC2LmhgnushZ9NNLGj3G7iDOeX";
    
    /**
     * 这个方法将传入的图片流交给百度AI进行识别
     * @return
     */
    public static Map<String,String> detectAnimal(FileInputStream imgStream){
    	//Map<String,String> result = new HashMap<>();
    	AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
    	 // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(10*1000);
        client.setSocketTimeoutInMillis(60000);
        HashMap<String, String> options = new HashMap<>();
        options.put("top_num", "3");
        byte[] data = inputStream2Byte(imgStream);
        JSONObject result = client.animalDetect(data, options);
        System.out.println(result);
    	return null;
    }
    
    private static byte[] inputStream2Byte(InputStream is){
    	byte[] data = null;
    	
    	return data;
    }
}
