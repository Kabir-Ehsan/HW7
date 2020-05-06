package com.example.HW4.Validators;

import com.example.HW4.Service.AlbumServ;
import com.example.HW4.Service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueEmailAddressValidator implements ConstraintValidator<UniqueEmailAddress, String> {

        @Autowired
        private UserServ userServ;

        @Override
        public void initialize(UniqueEmailAddress constraintAnnotation) {

        }

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            return userServ.emailIdExists(s);
        }
}
