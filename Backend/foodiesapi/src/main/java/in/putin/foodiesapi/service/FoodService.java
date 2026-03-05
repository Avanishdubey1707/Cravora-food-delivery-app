package in.putin.foodiesapi.service;

import org.springframework.web.multipart.MultipartFile;

import in.putin.foodiesapi.io.FoodRequest;
import in.putin.foodiesapi.io.FoodResponse;

public interface FoodService {

    String uploadFile(MultipartFile file);

    FoodResponse addFood(FoodRequest request,MultipartFile file);


}
