package com.xloop.resourceloop.creatingstaff.controller;


import com.xloop.resourceloop.creatingstaff.entity.Staff;
import com.xloop.resourceloop.creatingstaff.service.StaffService;

import java.util.List;

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
    public Staff saveStaff(@ModelAttribute Staff staff,@RequestParam(value = "file") MultipartFile file ){
        staff.setImageUrl(staffService.uploadFile(file));
        // staff.setFullName(staffService.s);
        return staffService.saveStaff(staff);
    }


    @GetMapping("get")
    public List<Staff> getStaff(){
        return staffService.getStaff();
    }


    // @PostMapping("upload")
    // public String uploadFile(@RequestParam(value = "file")MultipartFile file){
    //     //return  new ResponseEntity<>(staffService.uploadFile(file), HttpStatus.OK);
    //     return staffService.uploadFile(file);
    // }

}
