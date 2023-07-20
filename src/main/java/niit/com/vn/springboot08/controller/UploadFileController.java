package niit.com.vn.springboot08.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
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
            FileOutputStream fileOutputStream = new FileOutputStream(uploadDir + newDir + "/" + System.currentTimeMillis()+file.getOriginalFilename());
            fileOutputStream.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:upload-file";
    }
}
