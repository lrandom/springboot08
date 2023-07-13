package niit.com.vn.springboot08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;

@Controller("uploadFileController")
public class UploadFileController {
    @GetMapping("/upload-file")
    public String uploadFile() {
        return "upload-file";
    }

    @PostMapping("/upload-file-handler")
    public String uploadFileHandler(@RequestParam("img") MultipartFile file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/lrandom/Documents/uploads/"+file.getOriginalFilename());
            fileOutputStream.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:upload-file";
    }
}
