package com.atabs.atabbe.controller;

import com.atabs.atabbe.model.Account;
import com.atabs.atabbe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/authenticate")
    public ResponseEntity<com.atabs.atabbe.entity.AccountEntity> authenticate(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.authenticate(account), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<java.util.List<Account>> search(@RequestParam("username") String username) {
        return new ResponseEntity<>(accountService.searchAccountByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/getAccount/{id}")
    public ResponseEntity<com.atabs.atabbe.entity.AccountEntity> getAccountByID(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(accountService.getAccountInfo(id), HttpStatus.OK);
    }


    @PutMapping("/updateAccount")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
    }

    @PostMapping("/addAccount")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.addAccount(account), HttpStatus.CREATED);
//
//        try{
//            Set<ImageModelEntity> images = uploadImage(file);
//            account.setAccountImages(images);
//            accountService.addAccount(account,HttpStatus.CREATED);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    public Set<ImageModelEntity> uploadImage(MultipartFile[] multipartFiles) throws IOException {
//        Set<ImageModelEntity> imageModelEntities = new HashSet<>();
//
//        for (MultipartFile file : multipartFiles) {
//            ImageModelEntity imageModelEntity = new ImageModelEntity(
//                    file.getOriginalFilename(),
//                    file.getContentType(),
//                    file.getBytes()
//            );
//            imageModelEntities.add(imageModelEntity);
//        }
//        return imageModelEntities;
    }

}