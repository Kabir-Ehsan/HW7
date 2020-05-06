package com.example.HW4.Model;

import com.example.HW4.Validators.UniqueEmailAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @NotBlank(message = "User must not be empty")
    private String name;

    @UniqueEmailAddress
    private String email;

    private String profilePhotoUrl;
}
