package com.atabs.atabbe.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("status")
public class StatusController {

    @GetMapping()
    public String checkStatus(){
        return "Running...";
    }
}
