package fr.scrumstory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
@ComponentScan({"fr.scrumstory.tools"})
public class TestConfig {

}
