package com.example.HW4.Repository;

import com.example.HW4.Model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepo extends MongoRepository<Album, String>
{
    Optional<Album> findById(String s);

    boolean existsByCoverPhotoUrl(String s);
}
