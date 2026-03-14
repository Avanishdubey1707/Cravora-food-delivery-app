package in.putin.foodiesapi.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.putin.foodiesapi.entity.CartEntity;
import in.putin.foodiesapi.io.CartRequest;
import in.putin.foodiesapi.io.CartResponse;
import in.putin.foodiesapi.repository.CartRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserService userService;

    @Override
    public CartResponse addToCart(CartRequest request) {

        String loggedInUserId = userService.findByUserId();
        Optional<CartEntity> cartOptional = cartRepository.findByUserId(loggedInUserId);
        CartEntity cart= cartOptional.orElseGet(()-> new CartEntity(loggedInUserId,new HashMap<>()));
        Map<String , Integer> cartItems=cart.getItems();
        cartItems.put(request.getFoodId(),cartItems.getOrDefault(request.getFoodId(), 0)+1);
        cart.setItems(cartItems);
        cart=cartRepository.save(cart);
        return convertToResponse(cart);
    }
    public CartResponse convertToResponse(CartEntity cartEntity){
        return CartResponse.builder()
                .id(cartEntity.getId())
                .userId(cartEntity.getUserId())
                .items(cartEntity.getItems())
                .build();
    }
    @Override
    public CartResponse getCart() {
       String loggedInUserId = userService.findByUserId();
       CartEntity entity = cartRepository.findByUserId(loggedInUserId)
                  .orElse(new CartEntity(null,loggedInUserId,new HashMap<>()));
        return convertToResponse(entity);
    }

}
