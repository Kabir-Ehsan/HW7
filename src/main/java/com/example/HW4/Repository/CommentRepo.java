package com.example.HW4.Repository;

import com.example.HW4.Model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepo extends MongoRepository<Comment, String>
{
    void deleteByPhotoId(String id);

    boolean existsByPhotoId(String photoId);

    //Comment findById(String id);

    //void deleteCommentsByAlbumId(String id);

    //void deleteByAlbumId(String id);

    //void deleteByAlbumId(String albumId);

    //void deleteComments(Object byAlbumId);
    //Optional<Album> findById(String s);

}

