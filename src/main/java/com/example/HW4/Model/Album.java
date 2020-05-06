package com.example.HW4.Model;


import com.example.HW4.Validators.UniqueCoverPhotoUrl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Albums")
public class Album {

    @Id
    private String id;

    @Length(min = 4, max = 10)
    private String name;

    private String email;

    @UniqueCoverPhotoUrl
    private String coverPhotoUrl;
    public String createdBy;
    public Date dateCreated;

}

