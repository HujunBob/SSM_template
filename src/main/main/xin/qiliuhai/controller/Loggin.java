package xin.qiliuhai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import xin.qiliuhai.po.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/UserInfo")
public class Loggin {
    @RequestMapping("/redirect")
    public String redirect(){
        System.out.println("我是重定向");
        return "success";
    }
    @RequestMapping("/forward")
    public String  forward(){
        System.out.println("我是请求转发");
        return "success";
    }
    @RequestMapping("/registe")
    public String register(UserInfo userInfo, MultipartFile pictureFile) throws IOException {
        System.out.println(userInfo);
        String picture_name=pictureFile.getOriginalFilename();
        String newFileName=UUID.randomUUID().toString()+picture_name.substring(picture_name.lastIndexOf("."));
        File uploadPic =new File("C:\\Users\\TAOBAOBAO\\Desktop\\数据库\\"+newFileName);
        if(!uploadPic.exists()){
            uploadPic.mkdirs();
        }
        pictureFile.transferTo(uploadPic);
        return "redirect:./redirect.action";
    }

    @RequestMapping("/login")
    @ResponseBody
    public  UserInfo login( UserInfo userInfo,HttpServletRequest request) throws Exception{
        System.out.println(userInfo);
        request.getSession().setAttribute("user",userInfo);
        return userInfo;
    }
}
