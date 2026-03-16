package in.putin.foodiesapi.service;

import java.util.List;
import java.util.Map;

import com.razorpay.RazorpayException;

import in.putin.foodiesapi.io.OrderRequest;
import in.putin.foodiesapi.io.OrderResponse;

public interface OrderService {

    
 OrderResponse createOrderWithPayment(OrderRequest request) throws RazorpayException;
   

 void verifyPayment(Map<String , String> paymentData, String status);


 List<OrderResponse> setUserOrders();

 void removeOrder(String orderId);

 List<OrderResponse> getOrderOfAllUsers();  

void updateOrderStatus(String orderId,String status);

 }
