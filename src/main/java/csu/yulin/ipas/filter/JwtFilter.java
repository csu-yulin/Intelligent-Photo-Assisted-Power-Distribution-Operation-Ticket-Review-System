// src/main/java/csu/yulin/ipas/filter/JwtFilter.java
package csu.yulin.ipas.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import csu.yulin.ipas.common.ResponseResult;
import csu.yulin.ipas.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lp
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String path = request.getRequestURI();
        if ("/api/auth/login".equals(path)) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if (jwtUtil.validateToken(token)) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        // 统一返回 JSON 错误
        response.setStatus(401);
        response.setContentType("application/json;charset=UTF-8");
        ResponseResult<?> result = ResponseResult.error(401, "请先登录");
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}