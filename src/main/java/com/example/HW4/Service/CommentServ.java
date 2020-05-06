package com.example.HW4.Service;

import com.example.HW4.Model.Comment;
import com.example.HW4.Repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServ {
    @Autowired
    private CommentRepo repo;

   // @Autowired
    //AlbumRepo albumRepo;

    public List<Comment> getComment()
    {
        return repo.findAll();
        //return new ArrayList<>();
    }

    public void save(Comment comment)
    {
        repo.save(comment);
    }

    public Comment edit(Comment comment)
    {
        repo.save(comment);
        return comment;
    }

    public void delete(String id)
    {
        repo.deleteById (id);
    }

    public void deleteByPhotoId(String photoId)
    {
        repo.deleteByPhotoId(photoId);
    }
    public void deleteAll(List<Comment>comment)
    {
        repo.deleteAll(comment);
    }

    public void deleteComments(String photoId) {
        repo.deleteByPhotoId(photoId);
    }

    public boolean photoExists(String photoId) {
        return repo.existsByPhotoId(photoId);
    }

    /*public boolean photoIdExists(String photoId) {
        return repo.findByPhotoId(photoId);
    }*/

    //public Comment getByCommentId(String id) {
        //return repo.findById(id);
    //}

    //public void deleteByAlbumId(String albumId) {
       //repo.deleteByAlbumId(albumId);
  // }


    //public void deleteComments(Object byAlbumId) {
       //repo.deleteComments(byAlbumId);
    //}
}
