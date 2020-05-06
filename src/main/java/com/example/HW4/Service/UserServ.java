package com.example.HW4.Service;

//import com.amazonaws.util.StringUtils;
import com.example.HW4.Model.Album;
import com.example.HW4.Model.FirebaseUser;
import com.example.HW4.Model.Photo;
import com.example.HW4.Model.User;
import com.example.HW4.Repository.UserRepo;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserServ{

    @Autowired
    private UserRepo repo;

    public FirebaseUser firebaseUser;



    public List<User> getUser() {
        return repo.findAll();
    }

    public User save(User user) {
        return repo.save(user);
    }

    public User getByUserID(String userId)
    {
        return repo.findById(userId).get();
    }

    public User getByEmail(String email) {
        return repo.findByEmail(email);
    }
    public void edit(User user) {
        repo.save(user);
    }

    public boolean emailIdExists(String s) {
        return !repo.existsByEmail(s);
    }

    public boolean isValidUser(String idToken) {
        try
        {
            String uid = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
            String name = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getName();
            String email = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getEmail();

            if (!StringUtils.isEmpty(uid) && !StringUtils.isEmpty(email))
            {
                FirebaseUser firebaseUser = new FirebaseUser(uid, name, email);
                this.firebaseUser = firebaseUser;
                return true;
            }
            else
            {
                return false;
            }
        }
            catch(InterruptedException | ExecutionException e)
            {
                this.firebaseUser = null;
                return false;
            }
        }


    public void delete(String id) {
        repo.deleteById(id);
    }

    public void deleteAll(List<User>user)
    {
        repo.deleteAll(user);
    }
}

