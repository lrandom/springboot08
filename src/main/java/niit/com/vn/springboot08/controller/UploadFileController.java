package niit.com.vn.springboot08.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.Calendar;

@Controller("uploadFileController")
public class UploadFileController {
    @Value("${UPLOAD_DIR}")
    public String uploadDir;

    @GetMapping("/upload-file")
    public String uploadFile() {
        return "upload-file";
    }

    @PostMapping("/upload-file-handler")
    public String uploadFileHandler(@RequestParam("img") MultipartFile file) {
        try {
            //get current month
            //get current year
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);//lấy về năm
            int month = calendar.get(Calendar.MONTH) + 1;//lấy về tháng
            String newDir = month + "_" + year; //7_2023
            //check xem thư mục mới này đã có trong đường dẫn upload chưa
            File folder = new File(uploadDir + newDir);
            if (!folder.exists() || folder.isFile()) {
                //tạo thư mục mới
                folder.mkdir();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(uploadDir + newDir + File.separator + System.currentTimeMillis() + file.getOriginalFilename());
            fileOutputStream.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:upload-file";
    }

    @GetMapping("/file")
    public ResponseEntity<byte[]> serveFile(@RequestParam("file-name") String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(uploadDir + fileName);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/read-file/{fileName}")
    public ResponseEntity<byte[]> readFile(@PathVariable String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(uploadDir + "7_2023/"+fileName);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
