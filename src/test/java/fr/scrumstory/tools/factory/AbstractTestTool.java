package fr.scrumstory.tools.factory;

import fr.scrumstory.factory.DomainFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Fabrique abstraite commune aux fabriques de test.
 */
public class AbstractTestTool {

    @Autowired
    protected DomainFactory domainFactory;
}
