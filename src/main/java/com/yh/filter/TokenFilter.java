package com.yh.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录filter（token 过滤器）
 * token 唯一
 * value 唯一
 * 依据 token 对比 value 的值是否存在
 * 如果 value 不存在，跳转登录
 * 如果 value 存在，代表 token 也存在，直接放行
 * @author yuanzhe
 * @date 2019/9/30
 */

@WebFilter("/*")
public class TokenFilter implements Filter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String method = request.getMethod();
        if (method.equalsIgnoreCase("OPTIONS")) {
            return;
        }
        String uri = request.getRequestURI();
        // 如果与登录相关，直接放行
        if (uri.contains("login")) {
            chain.doFilter(req, resp);
        }
        if (uri.contains("swagger")) {
            chain.doFilter(req, resp);
        }
        // 获取请求体中的 token
        String token = request.getParameter("token");

        // 如果 token 存在，依据 token 得到 value 的值（key —》token，value -》name）
        String id = stringRedisTemplate.opsForValue().get(token);
        if (id != null) {
            chain.doFilter(req, resp);
        }
        response.sendRedirect(request.getContextPath() + "/login.html");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
