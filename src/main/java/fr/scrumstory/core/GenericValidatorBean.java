package fr.scrumstory.core;

import fr.scrumstory.core.exception.ValidationException;
import fr.scrumstory.core.resource.MessageBundle;
import jdk.nashorn.internal.objects.NativeArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
                Map<String, Object> attributes = constraintViolation.getConstraintDescriptor().getAttributes();
                Object[] args = new Object[attributes.size()-3];
                int index = 0;
                for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                    if (!"groups".equals(entry.getKey()) && !"message".equals(entry.getKey()) && !"payload".equals(entry.getKey())) {
                        args[index] = entry.getValue();
                        index++;
                    }
                }

                validationException.add(messageBundle.getMessage(constraintViolation.getMessageTemplate(), args));
            }
            throw validationException;
        }
    }
}
