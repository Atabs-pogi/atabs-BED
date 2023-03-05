package com.atabs.atabbe.controller;

import com.atabs.atabbe.helper.FileCreated;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("image")
@CrossOrigin
public class ImageProfileController {

    @Value("${upload.path}")
    private String uploadPath;

    @PostMapping("/addProfile")
    public ResponseEntity addProfile(@ModelAttribute("profile")String imageProfile, @ModelAttribute("type")String identity, @RequestParam("img")MultipartFile file){
        String name=identity+"_"+imageProfile+".png";
        Path fileNameAndPath= Paths.get(FileCreated.UPLOADDIRECTORY,name);
        System.out.println(fileNameAndPath);
        try {
            Files.write(fileNameAndPath,file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity(name, HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity getImage(@PathVariable("name") String imageProfile) throws FileNotFoundException {
        File directory = new File(uploadPath);
        if (directory.isDirectory()) {
            File[] files =  directory.listFiles();
            for (File file: files) {
                System.out.println();
                String filename = file.getName();
                if (filename.equals(imageProfile)) {
                    HttpHeaders headers = new HttpHeaders();
                        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
                        headers.add("Pragma", "no-cache");
                        headers.add("Expires", "0");
                    InputStream io = new FileInputStream(file);
                    return ResponseEntity.ok()
                            .headers(headers)
                            .contentLength(file.length())
                            .contentType(MediaType.IMAGE_PNG)
                            .body(io);
                }
            }
        }

        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
}
