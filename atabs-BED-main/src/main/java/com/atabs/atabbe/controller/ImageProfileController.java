package com.atabs.atabbe.controller;

import com.atabs.atabbe.helper.FileCreated;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequestMapping("image")
@CrossOrigin
public class ImageProfileController {
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
}
