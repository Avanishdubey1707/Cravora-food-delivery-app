package in.putin.foodiesapi.service;

import org.springframework.web.multipart.MultipartFile;

public interface FoodService {

    String uploadFile(MultipartFile file);


}
