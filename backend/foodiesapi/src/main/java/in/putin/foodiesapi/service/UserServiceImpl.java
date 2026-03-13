package in.putin.foodiesapi.service;

import org.springframework.stereotype.Service;

import in.putin.foodiesapi.entity.UserEntity;
import in.putin.foodiesapi.io.UserRequest;
import in.putin.foodiesapi.io.UserResponse;
import in.putin.foodiesapi.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    

    @Override
    public UserResponse registerUser(UserRequest request){
        UserEntity newUser = convertToEntity(request);
        newUser = userRepository.save(newUser);
        return convertToResponse(newUser);



    }

    private UserEntity convertToEntity(UserRequest request){
        return UserEntity.builder()
               .email(request.getEmail())
               .password(request.getPassword())
               .name(request.getName())
               .build();
    }

    private UserResponse convertToResponse(UserEntity registeredUser){
        return UserResponse.builder()
               .id(registeredUser.getId())
               .name(registeredUser.getName())
               .email(registeredUser.getEmail())
               .build();
    }

}
