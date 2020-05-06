package com.example.HW4.Validators;

import com.example.HW4.Service.AlbumServ;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailAddressValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface UniqueEmailAddress {

    String message() default "Email ID Exists";

    Class<?>[] groups() default {};

    Class<?extends Payload>[] payload() default{};
}
