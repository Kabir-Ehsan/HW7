package com.example.HW4.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "comments")

public class Comment {
    @Id
    private String id;

    @NotBlank
    private String photoId;

    @Length(min = 1, max = 20)
    private String message;

    public String createdBy;
    public Date dateCreated;
}
