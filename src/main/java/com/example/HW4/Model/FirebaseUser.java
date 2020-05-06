package com.example.HW4.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirebaseUser{
    
    private String uid;
    private String email;
    private String name;
}
