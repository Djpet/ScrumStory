package fr.scrumstory;

import fr.scrumstory.repository.IProjectRepository;
import fr.scrumstory.repository.IStoryRepository;
import fr.scrumstory.repository.Repository;
import org.mockito.*;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Field;

public class MockitoInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private BeanDefinitionRegistry registry;

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        AutowireCapableBeanFactory factory  = applicationContext.getAutowireCapableBeanFactory();
        registry = (BeanDefinitionRegistry) factory;
        factory.autowireBeanProperties(this,
                AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);

        createMockitoBeanForClass(Repository.class);
    }

    /**
     * Crée des beans mockito pour tous les attribues de la classe.
     * @param analyseClass : la classe.
     */
    private void createMockitoBeanForClass(Class<?> analyseClass) {

        Field[] fields = analyseClass.getDeclaredFields();
        for (Field field : fields) {
           Class<?> fieldClass = field.getType();

            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(Mockito.class);
            beanDefinition.setFactoryMethodName("mock");
            beanDefinition.setAutowireCandidate(true);
            ConstructorArgumentValues argumentValues = new ConstructorArgumentValues();
            beanDefinition.setConstructorArgumentValues(argumentValues);
            argumentValues.addGenericArgumentValue(fieldClass.getCanonicalName());
            registry.registerBeanDefinition(fieldClass.getCanonicalName(), beanDefinition);

        }
    }

}