package com.example.HW4.Resource;

import com.example.HW4.Exceptions.InvalidAlbumIdException;
import com.example.HW4.Exceptions.InvalidPhotoIdException;
import com.example.HW4.Model.Comment;
import com.example.HW4.Model.Photo;
import com.example.HW4.Service.CommentServ;
import com.example.HW4.Service.PhotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/albums/photos/comments")
public class CommentReso {
    @Autowired
    private CommentServ Serv;

    @Autowired
    PhotoServ photoServ;

    @GetMapping
    public List<Comment> getComment()
    {
        return Serv.getComment();
    }

    @PostMapping
    public void saveComment(@RequestBody Comment comment, String PhotoId) throws Exception
    {
        if (Serv.photoExists(PhotoId))
        {
            Serv.save(comment);
        }
        else
        {
            throw new InvalidPhotoIdException("Photo does not exists");
        }
    }


    @PutMapping("/{id}")
    public Comment editComment(@Validated @RequestBody Comment comment, @PathVariable("id") String id) {
        //try {
            /*Comment comment2 = Serv.getByCommentId(id);
            comment.setId(comment2.getId());*/
            return Serv.edit(comment);
        //}catch(Exception exc){
           // return null;
        //}
    }

    @DeleteMapping(value="/{id}")
    public void deleteComment(@PathVariable("id") String id)
    {
        //album.setId(id);
        Serv.delete(id);
    }

    @DeleteMapping
    public void deleteAllComment()
    {
        //album.setId(id);
        Serv.deleteAll(getComment());
    }

}

