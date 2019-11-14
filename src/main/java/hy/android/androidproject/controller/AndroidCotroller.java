package hy.android.androidproject.controller;
import com.google.gson.Gson;
import hy.android.androidproject.util.FaceTest;
import hy.android.androidproject.util.FaceUtil;
import hy.android.androidproject.util.User;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
//@RestController
@ResponseBody
@Controller
public class AndroidCotroller {

    @RequestMapping(value = "/uploadPictrue",method = RequestMethod.POST)
    public String uploadBak(String images){
       //String images = request.getParameter("images");
        Gson gson = new Gson();
        FaceTest faceTest = new FaceTest();
        System.out.println(images);
        System.out.println("开始执行");
        if(images != null || images != ""){
            //获取请求参数
            //String base64 = request.getParameter("images");
            System.out.println("++++++++++++++++++++" + images);
            String result = faceTest.search(images);
            System.out.println(result);
            Map fromJson = gson.fromJson(result,Map.class);
            Map map = (Map) fromJson.get("result");

            ArrayList user = (ArrayList) map.get("user_list");
            User u = gson.fromJson(user.get(0).toString(), User.class);
            System.out.println(u.getUser_info());
            return u.getUser_info();
        }
        System.out.println("结束了。。。");
        return "base64是空字符串";
    }


    @RequestMapping(value = "/detect", method = RequestMethod.POST)
    public String detect(String imagesBase64){
        String imageType = "BASE64";
        System.out.println("imageBase64: " + imagesBase64);
        FaceUtil faceUtil = new FaceUtil();
        JSONObject jsonObject = faceUtil.faceUpload(imagesBase64, imageType);
        System.out.println(jsonObject.toString(2));
        System.out.println("----------------------------------------------------");

//	    System.out.println(res.getString("error_msg"));
        JSONObject face_list = jsonObject.getJSONObject("result").getJSONArray("face_list").getJSONObject(0);
        System.out.println(face_list.toString());
        return face_list.toString();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(String imagesBase64, String name, String userid, String gender){
        System.out.println("imageBase64:" + imagesBase64 + " name:" + name + " userid:" + userid + " gender:" + gender);
        FaceUtil faceUtil = new FaceUtil();
        String result = faceUtil.add(imagesBase64, name, userid, gender);
        return result;
    }
}
