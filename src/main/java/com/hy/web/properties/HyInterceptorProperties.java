package com.hy.web.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问controller时url拦截器属性文件
 *
 * @author wyx
 */
@ConfigurationProperties(prefix = "hy.web")
@Data
public class HyInterceptorProperties {

    private List<Path> interceptors = new ArrayList<>();


    @Data
    public static class Path{
        private String[] pathPatterns=new String[]{"/**"};
        private String excludePathPatterns;
    }
}
