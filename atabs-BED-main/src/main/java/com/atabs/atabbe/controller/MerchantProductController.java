package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.FiberEntity;
import com.atabs.atabbe.entity.MerchantProductEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.Farmer;
import com.atabs.atabbe.model.MerchantProduct;
import com.atabs.atabbe.model.Transaction;
import com.atabs.atabbe.model.TransactionMerchant;
import com.atabs.atabbe.service.MerchantProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant")
@CrossOrigin
public class MerchantProductController {

    @Autowired
    MerchantProductService merchantProductService;

    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody MerchantProduct merchantProduct) {
        return new ResponseEntity(merchantProductService.addProduct(merchantProduct), HttpStatus.CREATED);
    }

    @GetMapping("/getAllProducts")
    public List<MerchantProductEntity> findAllProducts(){
        return merchantProductService.getProduct();
    }

    @PostMapping("/updateProduct")
    public ResponseEntity updateProduct(@RequestBody MerchantProduct merchantProduct){
        return new ResponseEntity(merchantProductService.updateProduct(merchantProduct), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("name") String name) {
        return new ResponseEntity(merchantProductService.searchProductByName(name), HttpStatus.OK);
    }


    @PostMapping("/saveTransaction")
    public ResponseEntity addPosBulk(@RequestBody TransactionMerchant transactions) {
        try {
            return new ResponseEntity(merchantProductService.insertTransaction(transactions), HttpStatus.CREATED);
        } catch (NotFoundException n) {
            return new ResponseEntity(n.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity addPosBulk() {
        try {
            return new ResponseEntity(merchantProductService.getAll(), HttpStatus.CREATED);
        } catch (NotFoundException n) {
            return new ResponseEntity(n.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
