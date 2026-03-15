package in.putin.foodiesapi.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import in.putin.foodiesapi.entity.OrderEntity;
import in.putin.foodiesapi.io.OrderRequest;
import in.putin.foodiesapi.io.OrderResponse;
import in.putin.foodiesapi.repository.OrderRepository;


@Service

public class OrderServiceImpl implements OrderService {
    @Autowired
    private  OrderRepository orderRepository;
    @Autowired
    private  UserService userService;

    @Value("${razorpay_key}")
    private String RAZORPAY_KEY;
    @Value("${razorpay_secret}")
    private String RAZORPAY_SECRET;


    @Override
    public OrderResponse createOrderWithPayment(OrderRequest request) throws RazorpayException {
        OrderEntity newOrder= convertToEntity(request);
        newOrder=orderRepository.save(newOrder);


        // create razorpay payment order

        RazorpayClient razorpayClient = new RazorpayClient(RAZORPAY_KEY, RAZORPAY_SECRET);
        JSONObject orderRequest = new JSONObject();

        int amount = (int)(Double.parseDouble(newOrder.getAmount()) * 100);


        orderRequest.put("amount", amount);
        orderRequest.put("currency", "INR");
        orderRequest.put("payment_capture", 1);

        Order razorpayOrder = razorpayClient.orders.create(orderRequest);
        newOrder.setRazorpayOrderId(razorpayOrder.get("id"));
        String loggedInUserId = userService.findByUserId();
        newOrder.setUserId(loggedInUserId);
        newOrder=orderRepository.save(newOrder);
        return convertToResponse(newOrder);
        
    }

    private OrderResponse convertToResponse(OrderEntity newOrder) {
          return OrderResponse.builder()
               .id(newOrder.getId())
               .amount(newOrder.getAmount())
               .userAddress(newOrder.getUserAddress())
               .razorpayOrderId(newOrder.getRazorpayOrderId())
               .paymentStatus(newOrder.getPaymentStatus())
               .orderStatus(newOrder.getOrderStatus())
               .email(newOrder.getEmail())
               .phoneNumber(newOrder.getPhoneNumber())
               .build();
    }

    private OrderEntity convertToEntity(OrderRequest request){
        return OrderEntity.builder()
               
               .userAddress(request.getUserAddress())
               .amount(String.valueOf(request.getAmount()))
               .orderedItems(request.getOrderedItems())
               .email(request.getEmail())
               .phoneNumber(request.getPhoneNumber())
               .orderStatus(request.getOrderStatus())
               .build();
               


    }

}
