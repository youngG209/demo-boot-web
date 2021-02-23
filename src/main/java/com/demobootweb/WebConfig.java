package com.demobootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new PersonFormatter());
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        .order(숫자) : 우선순위
//        .addPathPatterns(특정패턴) : 해당 패턴에만 적용
        registry.addInterceptor(new GreetingInterceptor()).order(0);
        registry.addInterceptor(new AnotherInterceptor())
                .addPathPatterns("/hi")
                .order(-1);
    }
}
