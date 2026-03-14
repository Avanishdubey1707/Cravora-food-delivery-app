package in.putin.foodiesapi.service;

import in.putin.foodiesapi.io.UserRequest;
import in.putin.foodiesapi.io.UserResponse;

public interface UserService {
      UserResponse registerUser(UserRequest request);

      String findByUserId();



}
