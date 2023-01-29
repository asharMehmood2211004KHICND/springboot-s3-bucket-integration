package com.xloop.resourceloop.creatingstaff.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.xloop.resourceloop.creatingstaff.entity.Staff;
import com.xloop.resourceloop.creatingstaff.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//import static com.sun.crypto.provider.AESCrypt.log;

@Service
@Slf4j
public class StaffServiceImpl implements StaffService {

//
//    public StaffServiceImpl(StaffRepository staffRepository, String bucketName, AmazonS3 s3Cient) {
//        this.staffRepository = staffRepository;
//        this.bucketName = bucketName;
//        this.s3Cient = s3Cient;
//    }
//
//    public StaffServiceImpl() {
//    }

    @Autowired
    private StaffRepository staffRepository;


    @Value("${application.bucket.name}")
    private String bucketName;


    @Autowired
    private AmazonS3 s3Client ;


    @Override
    public Staff saveStaff(Staff staff){
        return staffRepository.save(staff);
    }


    @Override
    public String uploadFile(MultipartFile file){
        File fileObbj =  convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName,fileName, fileObbj ));
        fileObbj.delete();
        return "file uploaded : "+ fileName;
    }



    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }


}
