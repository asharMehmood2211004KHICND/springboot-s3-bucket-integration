package com.xloop.resourceloop.creatingstaff.controller;


import com.xloop.resourceloop.creatingstaff.entity.Staff;
import com.xloop.resourceloop.creatingstaff.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/staff")

public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("save")
    public Staff saveStaff(@ModelAttribute Staff staff){
        return staffService.saveStaff(staff);
    }

    @PostMapping("upload")
    public String uploadFile(@RequestParam(value = "file")MultipartFile file){
        //return  new ResponseEntity<>(staffService.uploadFile(file), HttpStatus.OK);
        return staffService.uploadFile(file);
    }

}
