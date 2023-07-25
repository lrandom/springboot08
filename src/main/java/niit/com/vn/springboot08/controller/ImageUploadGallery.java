package niit.com.vn.springboot08.controller;

import niit.com.vn.springboot08.dao.ImageDao;
import niit.com.vn.springboot08.models.Image;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

@Controller("ImageUploadGallery")
public class ImageUploadGallery {
    @Value("${UPLOAD_DIR}")
    public String uploadDir;

    @GetMapping("/image-upload-gallery")
    public String index(Model model) {
        ImageDao imageDao = new ImageDao();
        ArrayList<Image> images = imageDao.getAll();
        model.addAttribute("images", images);
        return "image-upload-gallery";
    }

    @PostMapping("/upload-image-gallery")
    public String uploadImage(@RequestParam("img") MultipartFile file) {
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
            String relativePath = newDir + File.separator + System.currentTimeMillis() + file.getOriginalFilename();
            String absolutePath = uploadDir + relativePath;

            FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
            fileOutputStream.write(file.getBytes());

            //save to database
            ImageDao imageDAO = new ImageDao();
            imageDAO.insert(relativePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:image-upload-gallery";
    }
}
