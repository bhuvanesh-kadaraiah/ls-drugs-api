package com.bhuni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bhuni.api.GreetingController;


/**
 * Spring boot main application
 *
 */
@SpringBootApplication 
//@ComponentScan(basePackages="com.bhuni")
//@EnableJpaRepositories("com.bhuni")
//@EntityScan("entities.package")
public class Application 
{
    public static void main( String[] args ) throws Exception
    {
    	System.out.println("#################Running Main##########");
        SpringApplication.run(Application.class,args);
    }
}
