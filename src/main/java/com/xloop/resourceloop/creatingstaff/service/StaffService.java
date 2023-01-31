package com.xloop.resourceloop.creatingstaff.service;

import com.xloop.resourceloop.creatingstaff.entity.Staff;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface StaffService {

    public Staff saveStaff(Staff staff);

    public String uploadFile(MultipartFile file);

    public List<Staff> getStaff();
}