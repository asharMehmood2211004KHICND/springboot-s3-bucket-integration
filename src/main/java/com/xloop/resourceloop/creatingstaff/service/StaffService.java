package com.xloop.resourceloop.creatingstaff.service;

import com.xloop.resourceloop.creatingstaff.entity.Staff;
import org.springframework.web.multipart.MultipartFile;

public interface StaffService {

    public Staff saveStaff(Staff staff);

    public String uploadFile(MultipartFile file);
}