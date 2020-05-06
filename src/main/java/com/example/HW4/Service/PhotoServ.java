package com.example.HW4.Service;


import com.example.HW4.Model.Photo;
import com.example.HW4.Repository.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoServ{

    @Autowired
    PhotoRepo repo;

    @Autowired
    CommentServ commentServ;

    public List<Photo> getPhoto()
    {
        return repo.findAll();
        //return new ArrayList<>();
    }

    public void save(Photo photo) {
        repo.save(photo);
    }

    public void edit(Photo photo) {
        repo.save(photo);
    }

    public void delete(String id) {
        repo.deleteById(id);
        commentServ.deleteByPhotoId(id);
    }

    public void deleteByAlbumId(String albumId) {
        repo.deleteByAlbumId(albumId);
        //commentServ.deleteByPhotoId(albumId);
    }

    public void deleteAll(List<Photo>photo)
    {
        repo.deleteAll(photo);
    }

  public Photo getPhotoByAlbumId(String id) {
        return repo.findByAlbumId(id);
    }

    public boolean albumExists(String albumId) {
        return repo.existsByAlbumId(albumId);
    }

    /*public Photo getPhotoById(String photoId) {
        return repo.findById(photoId);
    }*/

    //public Optional<Photo> findById(String id) {
        //return repo.findById(id);
    //}

    //public Object findByAlbumId(String id) {
        //return repo.findByAlbumId(id);
    //}

    /*public String findByAlbumId(String id) {
        return repo.findByAlbumId(id);
    }*/
}