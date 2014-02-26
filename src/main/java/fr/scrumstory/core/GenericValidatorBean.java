package fr.scrumstory.core;

import fr.scrumstory.core.exception.ValidationException;
import fr.scrumstory.core.resource.MessageBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class GenericValidatorBean {

    @Autowired
    private MessageBundle messageBundle;

    @Autowired
    private Validator validator;

    public <T> void validate(T object) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        if (constraintViolations.size() > 0) {
            ValidationException validationException = new ValidationException();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                validationException.add(messageBundle.getMessage(constraintViolation.getMessageTemplate()));
            }
            throw validationException;
        }
    }
}
