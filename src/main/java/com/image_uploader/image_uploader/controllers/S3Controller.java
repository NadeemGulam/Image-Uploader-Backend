package com.image_uploader.image_uploader.controllers;

import com.image_uploader.image_uploader.services.ImageUploader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/s3")
@CrossOrigin(origins = "http://localhost:4200")
public class S3Controller {

    public S3Controller(ImageUploader uploader) {
        this.uploader = uploader;
    }

    private ImageUploader uploader;


//    Upload image
    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam MultipartFile file){
    return ResponseEntity.ok(uploader.uploadImage(file));
    }

//    Get ALl File

    @GetMapping
    public List<String> getAllFiles(){
        return uploader.allFiles();
    }

//    get URL by Name
    @GetMapping("/{fileName}")
    public String urlByName(@PathVariable("fileName") String fileName){
        return uploader.getImageURLByName(fileName);
    }
}
