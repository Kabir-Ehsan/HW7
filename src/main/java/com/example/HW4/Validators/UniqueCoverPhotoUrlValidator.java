package com.example.HW4.Validators;

import com.example.HW4.Service.AlbumServ;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCoverPhotoUrlValidator implements ConstraintValidator<UniqueCoverPhotoUrl, String> {

    @Autowired
    private AlbumServ albumServ;

    @Override
    public void initialize(UniqueCoverPhotoUrl constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return albumServ.coverPhotoExists(s);
    }
}
