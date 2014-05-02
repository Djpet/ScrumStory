package fr.scrumstory.config;

import fr.scrumstory.core.SessionBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * Classe de configuration des beans liés au Web.
 */
@Configuration
public class WebConfig {

    @Bean(name = "sessionBean")
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public SessionBean sessionBean() {
        return new SessionBean();
    }
}
