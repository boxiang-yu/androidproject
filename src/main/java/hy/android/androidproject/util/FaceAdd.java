package hy.android.androidproject.util;

/**
 * 人脸注册
 *
 */
/*
public class FaceAdd {
	private static String accessToken = "24.6384b9e5409264a903d50c7623d3d509.2592000.1575808987.282335-17696446";

	public static String add() throws Exception {

		byte[] bytes1 = FileUtil.readFileByBytes("F:\\photo\\huge\\huge3.jpg");
		String image1 = Base64Util.encode(bytes1);

		// 请求url
		String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", image1);
			map.put("group_id", "1");
			map.put("user_id", "huge");
			map.put("user_info", "胡歌");
			map.put("liveness_control", "NORMAL");
			//map.put("image_type", "FACE_TOKEN");
			map.put("image_type", "BASE64");
			map.put("quality_control", "LOW");

			String param = GsonUtils.toJson(map);
			// 客户端可自行缓存，过期后重新获取。
			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		String string = FaceAdd.add();
		System.out.println(string);
	}
}
*/