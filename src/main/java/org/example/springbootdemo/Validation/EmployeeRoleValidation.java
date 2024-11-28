package org.example.springbootdemo.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
//@Constraint(validatedBy = RoleValidation.class)
public @interface EmployeeRoleValidation {

    String message() default "{}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


}
