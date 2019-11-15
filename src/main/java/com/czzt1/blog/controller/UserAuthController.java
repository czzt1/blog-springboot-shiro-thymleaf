package com.czzt1.blog.controller;


import com.czzt1.blog.common.utils.ResponseUtil;
import com.czzt1.blog.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class UserAuthController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @PostMapping("/login")
    public Map<String, Object> login(String loginModalUserNmae, String loginModalUserPwd, boolean rememberme, HttpServletResponse response) {
        rememberme = true;
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginModalUserNmae, loginModalUserPwd, rememberme);
        Subject curUser = SecurityUtils.getSubject();
        try {
            curUser.login(usernamePasswordToken);
            User user = new User();
            user.setUsername(loginModalUserNmae);
            logger.info("用户登录！");
            return ResponseUtil.generateResponse("200", "成功", user);
        } catch (Exception e) {
            usernamePasswordToken.clear();
            return ResponseUtil.generateResponse("500", "失败", new User());
        }
    }
/*    @ResponseBody
    @PostMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "success";
    }*/
}