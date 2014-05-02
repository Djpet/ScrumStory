package fr.scrumstory.config;

import com.mongodb.MongoClient;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Classe de configuration des beans liés à MongoDB.
 */
@Configuration
@EnableMongoRepositories(basePackages = "fr.scrumstory.repository.mongodb.spring")
@ComponentScan("fr.scrumstory.repository.mongodb")
public class MongoConfig {

    public @Bean MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(), "scrumstory");
    }

    public @Bean MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }

    @Bean
    public Mapper mapper() throws Exception {
        DozerBeanMapperFactoryBean factory = new DozerBeanMapperFactoryBean();
        factory.afterPropertiesSet();
        return (Mapper) factory.getObject();
    }
}