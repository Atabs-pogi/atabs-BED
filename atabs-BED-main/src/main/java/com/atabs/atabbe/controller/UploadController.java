package com.atabs.atabbe.controller;

import com.atabs.atabbe.helper.FileCreated;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("upload")
@CrossOrigin
public class UploadController {

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
        return new ResponseEntity(FileCreated.UPLOADDIRECTORY+"/"+name, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{name}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getImage(@PathVariable("name") String imageProfile) throws IOException {
        File directory = new File(uploadPath);
        if (directory.isDirectory()) {
            File[] files =  directory.listFiles();
            for (File file: files) {
                String filename = file.getName();
                if (filename.equals(imageProfile)) {
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
                    headers.add("Pragma", "no-cache");
                    headers.add("Expires", "0");
                    InputStream io = new FileInputStream(file);
                    return IOUtils.toByteArray(io);
                }
            }
        }
        throw new IOException("Not Found");
    }
}
