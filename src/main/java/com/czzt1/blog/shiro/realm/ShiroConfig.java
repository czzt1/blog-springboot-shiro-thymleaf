package com.czzt1.blog.shiro.realm;

import com.czzt1.blog.shiro.filter.ShiroLoginFilter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author breeze1
 */
@Configuration
public class ShiroConfig extends UserFilter {

    //private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);
    @Resource
    DefaultWebSecurityManager securityManager;

    /**
     * 注入自定义的 Realm
     *
     * @return MyRealm
     */
    @Bean
    public MyRealm myAuthRealm() {
        MyRealm myRealm = new MyRealm();
        // logger.info("====myRealm注册完成=====");
        return myRealm;
    }

    /**
     * 注入安全管理器
     *
     * @return SecurityManager
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        // 将自定义 Realm 加进来
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(myAuthRealm());
        //logger.info("====securityManager注册完成====");
        return securityManager;
    }


    /**
     * 注入 Shiro 过滤器
     *
     * @return ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 登录的url
        shiroFilterFactoryBean.setLoginUrl("/index");
        // 登录成功后跳转的url
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 未授权url
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        // 定义filterChain，静态资源不拦截
        filterChainDefinitionMap.put("/static/css/**", "anon");
        filterChainDefinitionMap.put("/static/js/**", "anon");
        filterChainDefinitionMap.put("/static/fonts/**", "anon");
        filterChainDefinitionMap.put("/static/images/**", "anon");
        // druid数据源监控页面不拦截
        filterChainDefinitionMap.put("/druid/**", "anon");
        // 配置退出过滤器，其中具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/index", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        // 除上以外所有url都必须认证通过才可以访问，未通过认证自动访问LoginUrl
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        //super.redirectToLogin(request, response);
        //返回json
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write("请登录！");
    }
}
