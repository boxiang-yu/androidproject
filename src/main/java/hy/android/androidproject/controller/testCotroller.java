package hy.android.androidproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public class testCotroller {

    @ResponseBody
    @Controller
    public class AndroidCotroller {

        @RequestMapping(value = "/AndroidTest")
        public String upload1(HttpServletRequest request) {
            String images = request.getParameter("images");
            System.out.println(images);
            return "我接受到了 。" + images;
        }

    }
}
