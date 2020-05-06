package com.example.HW4.Service;

import com.example.HW4.Model.Album;
import com.example.HW4.Model.Comment;
import com.example.HW4.Repository.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumServ{

    @Autowired
    AlbumRepo repo;

    @Autowired
    PhotoServ photoServ;

    @Autowired
    CommentServ commentServ;

    public List<Album> getAlbum()
    {
        return repo.findAll();
        //return new ArrayList<>();
    }

    public void save(Album album)
    {
        repo.save(album);
    }

    public void edit(Album album)
    {
        repo.save(album);
    }

    public void delete(String id)
    {
        repo.deleteById(id);
        //photoServ.deleteByAlbumId(id);
        //commentServ.deleteComments((photoServ.getPhotoByAlbumId(id)).getId());
    }

        //commentServ.deleteComments((photoServ.getPhotoByAlbumId(id)).getId());
        //

    /*public void deletePhotosComment(String albumId) {
        commentServ.deleteCommentsByAlbumId(photoServ.getPhotoByAlbumId(albumId).getId());
        //photoServ.deleteByAlbumId(albumId);
    }*/

    public void deleteAll(List<Album>album)
    {
        repo.deleteAll(album);
    }

    public boolean coverPhotoExists(String s) {
        return !repo.existsByCoverPhotoUrl(s);
    }
}