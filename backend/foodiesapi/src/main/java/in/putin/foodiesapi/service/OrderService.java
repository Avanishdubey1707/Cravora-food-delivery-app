package in.putin.foodiesapi.service;

import in.putin.foodiesapi.io.OrderRequest;
import in.putin.foodiesapi.io.OrderResponse;

public interface OrderService {

    
 OrderResponse createOrderWithPayment(OrderRequest request);

 }
