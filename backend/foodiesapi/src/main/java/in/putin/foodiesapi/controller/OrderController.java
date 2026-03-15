package in.putin.foodiesapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.RazorpayException;

import in.putin.foodiesapi.io.OrderRequest;
import in.putin.foodiesapi.io.OrderResponse;
import in.putin.foodiesapi.service.OrderService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    
    @PostMapping("/create")
    public OrderResponse createOrderWithPayment(@RequestBody OrderRequest request) throws RazorpayException{
        OrderResponse response = orderService.createOrderWithPayment(request);
        return response;
    }
     
    @GetMapping("/verify")
    public void verifyPayment(@RequestBody Map<String,String> paymentData){
        orderService.verifyPayment(paymentData, "paid");
    }
    @GetMapping
    public List<OrderResponse> getOrders(){
        return orderService.setUserOrders();
    }


}
