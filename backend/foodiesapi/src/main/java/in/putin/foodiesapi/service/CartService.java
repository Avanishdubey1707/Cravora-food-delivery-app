package in.putin.foodiesapi.service;

import in.putin.foodiesapi.io.CartRequest;
import in.putin.foodiesapi.io.CartResponse;

public interface CartService {
   
    CartResponse addToCart(CartRequest request);

    CartResponse  getCart();

    void clearCart();

    CartResponse removeFromCart(CartRequest cartRequest);
    
}
