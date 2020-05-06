package com.example.HW4.Resource;


import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.example.HW4.Service.FileStorageServ;
import org.apache.catalina.webresources.FileResource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/files")
public class FileStorageReso {
    //private static final LOGGER LOG = LoggerFactory.getLogger(FileResource.class);

    @Autowired
    private FileStorageServ fileStorageServ;

    @PostMapping
    public void uploadFile(@RequestParam(value="file") MultipartFile file ){
        try{
            fileStorageServ.uploadFile(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @GetMapping
    public void viewFile(@RequestParam(name="key") String key, HttpServletResponse response){
        S3Object object = fileStorageServ.getFile(key);
        try{
            response.setContentType(object.getObjectMetadata().getContentType());
            response.getOutputStream().write(object.getObjectContent().readAllBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam(name="key") String key) {
        S3Object object = fileStorageServ.getFile(key);


        try {
            String contentType = object.getObjectMetadata().getContentType();
            ByteArrayResource resource = new ByteArrayResource(object.getObjectContent().readAllBytes());
            if (contentType == null) {
                contentType = "application/octate-stream";
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\" " + key + "\"")
                    .body(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping
    public void deleteFile(@RequestParam("key") String key )
    {
        fileStorageServ.deleteFile(key);
    }
}
