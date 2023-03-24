package com.example.demo;

import com.example.demo.internal.InternalComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import static com.example.demo.DemoApplication.enableSpringDoc;

/**
 * We want to ensure that /api resources never provide backdoor access to internal resources
 * To accomplish that we'll create a new DispatcherServlet and load all the internal beans
 * into that context so that they are not available to beans outside the internal context
 * <p>
 * Note: internal beans still have access to api services (not controllers though)
 */
@Configuration
public class InternalDispatcherServletConfig {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public ServletRegistrationBean internalServletRegistrationBean() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();

        applicationContext.register(InternalComponentScan.class);

        dispatcherServlet.setApplicationContext(applicationContext);

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/internal/*");
        servletRegistrationBean.setName("internalServlet");

        enableSpringDoc(applicationContext);
        return servletRegistrationBean;
    }
}
