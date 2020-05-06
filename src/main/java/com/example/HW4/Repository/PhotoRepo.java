package com.example.HW4.Repository;

import com.example.HW4.Model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepo extends MongoRepository<Photo, String>
{
    void deleteByAlbumId(String albumId);
    //Optional<Photo> findById(String s);

    //Photo getPhotoByAlbumId(String id);

    //Photo findByPhotoId(String id);

    Photo findByAlbumId(String albumId);

    boolean existsByAlbumId(String albumId);
    // Object findByAlbumId(String id);


    //String findByAlbumId(String id);
    //Optional<Album> findById(String s);

}
