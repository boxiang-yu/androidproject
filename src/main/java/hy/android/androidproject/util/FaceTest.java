package hy.android.androidproject.util;

import java.util.HashMap;
import java.util.Map;

public class FaceTest {

	    public String search(String image) {
	        // 请求url
	        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";

			//String image1 = Base64Util.encode(bytes1);
			
			//System.out.println("image: " + image);
	        
	        try {
	            Map<String, Object> map = new HashMap<>();
	            //map.put("image", "027d8308a2ec665acb1bdf63e513bcb9");
	            map.put("image", image);
	            map.put("liveness_control", "NONE");
	            map.put("group_id_list", "1");
	            //map.put("image_type", "FACE_TOKEN");
	            map.put("image_type", "BASE64");
	            map.put("quality_control", "LOW");

	            String param = GsonUtils.toJson(map);

	            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
	            String accessToken = "24.6384b9e5409264a903d50c7623d3d509.2592000.1575808987.282335-17696446";

	            String result = HttpUtil.post(url, accessToken, "application/json", param);
	            System.out.println(result);
	            return result;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}
