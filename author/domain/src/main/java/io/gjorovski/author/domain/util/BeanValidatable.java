package io.gjorovski.author.domain.util;

import javax.validation.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 16/10/2021 - 5:21 PM
 * @project mindware
 */
public class BeanValidatable<T> extends Validatable {

    private final Validator validator;

    protected BeanValidatable() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

        validator = validatorFactory.getValidator();
    }

    @Override
    public boolean isValid() {
        return validate().size() == 0;
    }

    @Override
    public List<Violation> validate() {
        @SuppressWarnings("unchecked")
        Set<ConstraintViolation<T>> constraintViolations = validator.validate((T) this);

        return constraintViolations.stream()
                .map(constraintViolation -> {
                    String attribute = getConstraintViolationAttribute(constraintViolation);
                    String message = constraintViolation.getMessage();

                    return new AttributeViolation(attribute, message);
                })
                .collect(Collectors.toList());
    }

    private String getConstraintViolationAttribute(ConstraintViolation<T> constraintViolation) {
        String attribute = null;

        for (Path.Node node : constraintViolation.getPropertyPath()) {
            attribute = node.getName();
        }

        return attribute;
    }
}
