package by.gsu.pms.task11.config;

import by.gsu.pms.task11.model.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public Database getDatabase(){
        String dbUrl = "jdbc:mysql://localhost:3306/products";
        String dbUser = "root";
        String dbPassword = "root";
        return new Database(dbUrl, dbUser, dbPassword);
    }
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.freeMarker();
    }
}
