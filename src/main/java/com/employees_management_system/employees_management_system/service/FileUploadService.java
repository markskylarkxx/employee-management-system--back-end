package com.employees_management_system.employees_management_system.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class FileUploadService {
    private static final String UPLOAD_DIRECTORY = "C:\\uploads\\";
    private static final Integer ALLOWED_IMAGE_SIZE= 20000;


    private static  String chars ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String uploadFile(MultipartFile passport) throws Exception {

        if(passport.isEmpty()) throw new FileNotFoundException("File not available for upload");
        if(verifyFilesize(passport) && verifyFileExtension(passport)) {
            //upload file
            File file = new File(UPLOAD_DIRECTORY + passport.getOriginalFilename());
            byte[] bytes = passport.getBytes();
            OutputStream stream = new
                    BufferedOutputStream(new FileOutputStream(file));

            stream.write(bytes);
            stream.close();
            return file.toString();
        }

        return null;

    }

    private static boolean verifyFilesize(MultipartFile file) {

        return file.getSize() < ALLOWED_IMAGE_SIZE;
    }


    private static boolean verifyFileExtension(MultipartFile file) {
        List<String> validExtensions = Arrays.asList("jpg","jpeg","png");
        String fileName = file.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        return validExtensions.stream().filter(f -> f.equalsIgnoreCase(fileExtension)).findAny().isPresent();
    }

//EXCEPTIONS


    private  static  boolean imageSizeExtension(MultipartFile file) throws  Exception{
        if (file.getSize() >= ALLOWED_IMAGE_SIZE){
            throw  new RuntimeException("Image cannot be uploaded");
        }
        return  false;

    }


//    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public  String handleFileException()














    private  static String getGenerateRandomPassword(int len){
        System.out.println(UUID.randomUUID().toString());
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        //each iteration of the loop
        // randomly chooses character from the given
        // ASCII rannge and append it to the StringBuilder instance;

      for (int i = 0; i < len; i++){
          int randomIndex= secureRandom.nextInt(chars.length());
          sb.append(chars.charAt(randomIndex));
      }return sb.toString();

      }


//      private static  final  String lCase = "abcdefghijklmnopqrstuvwxyz";
//      private static  final  String uCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//      private static  final  String sCase ="!@$%^&*";
//      private static  final String digits = "0123456789";
//      private static Random random = new Random();
//      private  static  StringBuilder sb = new StringBuilder();
//
//      private  static  final  int len = 10;
//
//public   static String generateRandomPassword(){
//     while (sb.length() != len){
//   int rPick = random.nextInt(4);
//   if (rPick == 0){
//       int spot  = random.nextInt(26);
//       sb.append(lCase.charAt(spot));
//   } else if (rPick ==1 ) {
//       int spot= random.nextInt(26);
//       sb.append(uCase.charAt(spot));
//
//   } else if (rPick ==2) {
//       int spot = random.nextInt(8);
//       sb.append(sCase.charAt(spot));
//
//   } else  {
//
//       int spot = random.nextInt(10);
//       sb.append(digits.charAt(spot));
//
//   }
//         System.out.println(sb.toString());
//     }
//     return sb.toString();
// }
//  public  static  String hello(){
//      System.out.println("This is java");
//      return  "hi";
//  }
//
}




//}
//1. Ensure only jpg, jpeg and png images are uploaded  ---- file extension
//2. Max size of upload should be 2M    --- file size
//3. No documents are allowed
//how do you view uploaded files and also delete uploaded files in java;



