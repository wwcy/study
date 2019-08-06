package com.wcy;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.wcy.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2Doc
@EnableZuulProxy
@SpringCloudApplication
public class ApplicationZuulGateway {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationZuulGateway.class, args);
	}

	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}

	@Component
    @Primary
	static class DocumentConfig implements SwaggerResourcesProvider{

        @Override
        public List<SwaggerResource> get() {
            List<SwaggerResource> resources = new ArrayList<>();
            resources.add(swaggerResource("application-client","/application-client/v2/api-docs","2.0"));
            return resources;
        }

        private SwaggerResource swaggerResource(String name,String location,String version){
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }

}
