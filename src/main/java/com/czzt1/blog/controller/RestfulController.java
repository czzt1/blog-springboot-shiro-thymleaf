package com.czzt1.blog.controller;

import com.czzt1.blog.mapper.ArticleMapper;
import com.czzt1.blog.mapper.UserInfoMapper;
import com.czzt1.blog.pojo.Article;
import com.czzt1.blog.pojo.UserInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author czzt1
 * @Date 2019-06-20- 12:46
 */
@RestController
public class RestfulController {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private UserInfoMapper userInfoMapper;

    /*@ResponseBody
    @RequestMapping(value = "/categoryList/{pageNum}",method = RequestMethod.GET)
    public String articleList(@PathVariable int pageNum){
        int pageSize=10;
        Map<String,Object> param=new HashMap<>();
        PageHelper.startPage(1,10);
        return articleMapper.getList(param).toString();
    }*/



/*    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public UserInfo userLogin(@RequestParam(value = "loginModalUserNmae") String loginModalUserNmae, @RequestParam(value = "loginModalUserPwd") String loginModalUserPwd, HttpSession session){
        UserInfo userInfo=userInfoMapper.selectUserByName(loginModalUserNmae);
        if(userInfo==null){
            userInfo=new UserInfo();
            userInfo.setStatus("F");
            userInfo.setMsg("用户不存在！");
            return userInfo;
        }
        String pwd=userInfo.getPassword();
        userInfo.setPassword(null);
        if(pwd.equals(loginModalUserPwd)){
            session.setAttribute("userInfo",userInfo);
            userInfo.setStatus("S");
            return userInfo;
        }else{
            userInfo=new UserInfo();
            userInfo.setStatus("F");
            userInfo.setMsg("密码错误！");
            return userInfo;
        }
    }*/

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map<String,Object> register(@RequestParam(value = "registerModalUserNmae") String registerModalUserNmae,@RequestParam(value = "registerModalNickName") String registerModalNickName,@RequestParam(value = "registerModalUserPwd") String registerModalUserPwd){
        Map<String,Object> result=new HashMap<>();
        UserInfo userInfo=userInfoMapper.selectUserByName(registerModalUserNmae);
        if(userInfo!=null){
            result.put("msg","用户名已被占用");
            result.put("status","F");
            return result;
        }
        UserInfo newUser=new UserInfo();
        newUser.setUsername(registerModalUserNmae);
        newUser.setPassword(registerModalUserPwd);
        newUser.setNickname(registerModalNickName);
        userInfoMapper.insertNewUser(newUser);
        result.put("msg","注册成功");
        result.put("status","S");
        return result;
    }

    /*@ResponseBody
    @GetMapping(value = "/categoryList/{pageNum}")
    public String getHostArticleList(){
        return null;
    }*/

}
