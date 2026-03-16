package in.putin.foodiesapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
     
    @PostMapping("/verify")
    public void verifyPayment(@RequestBody Map<String,String> paymentData){
        orderService.verifyPayment(paymentData, "paid");
    }
    @GetMapping
    public List<OrderResponse> getOrders(){
        return orderService.setUserOrders();
    }
    
    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable String orderId){
        orderService.removeOrder(orderId);
    }
    //  Admin panel 
    @GetMapping("/all")
    public List<OrderResponse> getOrdersOfAllUsers(){
        return orderService.getOrderOfAllUsers();
    }
     
    // Admin panel
    @PatchMapping("/status/{orderId}")
    public void updateOrderStatus(@PathVariable String orderId , @RequestParam String status){
        orderService.updateOrderStatus(orderId, status);
    }


}
