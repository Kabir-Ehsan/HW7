package com.example.HW4.Resource;

import com.example.HW4.Model.Album;
import com.example.HW4.Service.AlbumServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/albums")
public class AlbumReso {
    @Autowired
    private AlbumServ Serv;

    @GetMapping
    public List<Album> getAlbum()
    {
        return Serv.getAlbum();
    }

    @PostMapping
    public void saveAlbum(@Validated @RequestBody Album album)
    {
        Serv.save(album);
    }

    @PutMapping("/{id}")
    public void editAlbum(@Validated @RequestBody Album album, @PathVariable("id") String id)
    {
        album.setId(id);
        Serv.edit(album);
    }

    @DeleteMapping
    public void deleteAllAlbum()
    {
        //album.setId(id);
        Serv.deleteAll(getAlbum());
    }


    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable("id") String id)
    {
        Serv.delete(id);
    }

    /*@DeleteMapping("/all/{id}")
    public void deletePhotosComment(@PathVariable("id") String id)
    {
        //album.setId(id);
        Serv.deletePhotosComment(id);
    }*/
}