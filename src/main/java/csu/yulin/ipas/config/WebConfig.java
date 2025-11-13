// src/main/java/csu/yulin/ipas/config/WebConfig.java
package csu.yulin.ipas.config;

import csu.yulin.ipas.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lp
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilterRegistration(JwtFilter jwtFilter) {
        FilterRegistrationBean<JwtFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(jwtFilter);
        // 所有 /api/ 下的接口都需要 token
        bean.addUrlPatterns("/api/*");
        bean.setOrder(1);
        return bean;
    }
}