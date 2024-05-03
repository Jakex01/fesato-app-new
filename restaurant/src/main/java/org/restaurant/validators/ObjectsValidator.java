package org.restaurant.validators;

import jakarta.validation.*;
import org.restaurant.exceptions.ObjectNotValidException;
import org.restaurant.request.CreateRestaurantRequest;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectsValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void validate(T objectToValidate) {
        Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);

        if (!violations.isEmpty()) {
            var errorMessages = violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());

            throw new ObjectNotValidException(errorMessages);
        }

    }
}
