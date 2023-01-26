package com.app;





import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.app.model.Company;
import com.app.services.AdminService;
import com.app.services.CategoryService;
import com.app.services.CompanyService;
import com.app.services.Impl.AdminServiceImpl;
import com.app.services.Impl.CategoryServiceImpl;
import com.app.services.Impl.CompanyServiceImpl;

import ch.qos.logback.classic.Logger;


@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.app.model"})
@EnableJpaRepositories(basePackages = "com.app.repositories")
public class CmsPhase2Application {
	
	public static void main(String[] args) {
		SpringApplication.run(CmsPhase2Application.class, args);
		Logger logger = (Logger) LoggerFactory.getLogger(CmsPhase2Application.class);

		logger.info("sadasd");
	}
	
	
   @Bean("adminService")
    public AdminService adminService(){
        return new AdminServiceImpl();
    }
   
   @Bean("categoryService")
   public CategoryService categoryService(){
       return new CategoryServiceImpl();
   }
	
	
	

}

