package in.putin.foodiesapi.service;

import java.util.Map;

import com.razorpay.RazorpayException;

import in.putin.foodiesapi.io.OrderRequest;
import in.putin.foodiesapi.io.OrderResponse;

public interface OrderService {

    
 OrderResponse createOrderWithPayment(OrderRequest request) throws RazorpayException;
   

 void verifyPayment(Map<String , String> paymentData, String status);
 

 }
