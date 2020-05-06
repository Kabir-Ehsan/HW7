package com.example.HW4.Resource;

import com.example.HW4.Exceptions.InvalidAlbumIdException;
import com.example.HW4.Model.Photo;
import com.example.HW4.Service.PhotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/albums/photos")
public class PhotoReso {
    @Autowired
    private PhotoServ Serv;

    @GetMapping
    public List<Photo> getPhoto()
    {
        return Serv.getPhoto();
    }

    @PostMapping
    public void savePhoto(@RequestBody Photo photo, String AlbumId) throws Exception
    {
        if (Serv.albumExists(AlbumId))
        {
            Serv.save(photo);
        }
        else
        {
            throw new InvalidAlbumIdException("Album does not exists");
        }
    }

    @PutMapping("/{id}")
    public void editPhoto(@RequestBody Photo photo, @PathVariable("id") String id)
    {
        photo.setId(id);
        Serv.edit(photo);
    }

    @DeleteMapping(value="/{id}")
    public void deletePhoto(@PathVariable("id") String id)
    {
        Serv.delete(id);
    }

    @DeleteMapping
    public void deleteAllPhoto()
    {
        //album.setId(id);
        Serv.deleteAll(getPhoto());
    }
}