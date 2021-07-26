package com.dms.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  @Value("${app.name}")
  private String API_NAME;

  @Value("${app.version}")
  private String API_VERSION;

  @Value("${app.description}")
  private String API_DESCRIPTION;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }

  public ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title(API_NAME)
        .version(API_VERSION)
        .description(API_DESCRIPTION)
        .build();
  }

}
