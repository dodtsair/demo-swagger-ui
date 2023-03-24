package com.example.demo;

import org.springdoc.core.SpringDocConfigProperties;
import org.springdoc.core.SpringDocConfiguration;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springdoc.core.SwaggerUiOAuthProperties;
import org.springdoc.webmvc.core.MultipleOpenApiSupportConfiguration;
import org.springdoc.webmvc.core.SpringDocWebMvcConfiguration;
import org.springdoc.webmvc.ui.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootApplication(
		exclude = {
				SpringDocWebMvcConfiguration.class,
				MultipleOpenApiSupportConfiguration.class,
				SwaggerConfig.class,
				SwaggerUiConfigProperties.class,
				SwaggerUiConfigParameters.class,
				SwaggerUiOAuthProperties.class,
				SpringDocConfiguration.class,
				SpringDocConfigProperties.class
		}
)
@ConfigurationPropertiesScan
@ComponentScan(basePackages = "com.example.demo",
		excludeFilters = {
				//Forcing the internal APIs and services to be loaded into a different context, in accessible from members of the root
				@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.example\\.demo\\.internal\\..*"),
				//Force all API packaged controllers to be under the /api context path
				@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.example\\.demo\\.resource.api\\..*"),
		}
)

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	public static void enableSpringDoc(AnnotationConfigWebApplicationContext applicationContext) {
		applicationContext.register(
				SwaggerConfig.class,
				SwaggerUiConfigProperties.class,
				SwaggerUiConfigParameters.class,
				SwaggerUiOAuthProperties.class,
				SpringDocWebMvcConfiguration.class,
				MultipleOpenApiSupportConfiguration.class,
				SpringDocConfiguration.class,
				SpringDocConfigProperties.class,
				JacksonAutoConfiguration .class
		);
	}

}
