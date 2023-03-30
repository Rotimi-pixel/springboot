package nl.cim.training.springboot.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import nl.cim.training.springboot.dto.EmployeeRequest;

import java.lang.annotation.*;

@Documented()
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployeeRequestConstraint.class)



public  @interface EmployeeValidation {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
