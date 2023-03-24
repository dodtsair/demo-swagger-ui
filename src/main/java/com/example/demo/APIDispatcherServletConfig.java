package com.example.demo;

import com.example.demo.resource.api.APIComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import static com.example.demo.DemoApplication.enableSpringDoc;

/**
 * Having come so far as defining a separate DispatcherServlet for internal
 * We'll do the same for /api that way all controllers go into /api unless a
 * developer needs to work hard for it not to
 */
@Configuration
public class APIDispatcherServletConfig {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public ServletRegistrationBean apiServletRegistrationBean() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();

        applicationContext.register(APIComponentScan.class);

        dispatcherServlet.setApplicationContext(applicationContext);

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/api/*");
        servletRegistrationBean.setName("apiServlet");

        enableSpringDoc(applicationContext);
        return servletRegistrationBean;
    }

}
