import axios from "axios";
import { API_URL } from "./authService";
// const API_URL=`${API_URI}/cart`;

export const addToCart = async (foodId,token) =>{
    try {
        await axios.post(
            API_URL +"/cart",
            {foodId},
            {headers:{Authorization:`Bearer ${token}`}}
        );

    } catch (error) {
        console.error('Error while adding the cart data',error);
        
    }
}

export const removeQtyFromCart = async (foodId,token) =>{
    try {
        await axios.post(
            API_URL+"/cart/remove",{foodId},
            {headers:{Authorization: `Bearer ${token}`}}
        );
        
    } catch (error) {
        console.error('Error while removing qty from cart',error);
        
    }
}

export const getCartData = async (token) =>{
    try {
         const response = await axios.get(API_URL + "/cart", {headers:{Authorization: `Bearer ${token}`}});
         return response.data.items;
    } catch (error) {
        console.error('Error while fetching the cart data',error);
        
    }
}