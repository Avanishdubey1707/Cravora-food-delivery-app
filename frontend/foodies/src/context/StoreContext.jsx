import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";
import axios from "axios";
import { addToCart, getCartData, removeQtyFromCart } from "../service/cartService";
import { API_URL } from "../service/authService";

export const StoreContext = createContext(null);

export const StoreContextProvider = (props) =>{

    const [foodList, setFoodList] = useState([]);
    const [quantities,setQuantities] = useState({});
    const [token ,setToken] = useState("");

    
   const increaseQty = async (foodId) => {

    setQuantities((prev)=>({
        ...prev,
        [foodId]:(prev[foodId] || 0)+1
    }));

    if(token){
        await addToCart(foodId,token);
    }
};
   const decreaseQty = async (foodId) => {

    setQuantities((prev)=>({
        ...prev,
        [foodId]: prev[foodId] > 0 ? prev[foodId]-1 : 0
    }));

    if(token){
        await removeQtyFromCart(foodId,token);
    }
};

    const removeFromCart = (foodId) => {
        setQuantities((prevQuantities)=> {
            const updatedQuantities = {...prevQuantities};
            delete updatedQuantities[foodId];
            return updatedQuantities;
        });
    };

    const loadCartData= async (token) => {
       const items=await getCartData(token);
       setQuantities(items || {});
    };

   
    const contextValue={
        foodList,
        increaseQty,
        decreaseQty ,
        quantities,
        removeFromCart,
        token,
        setToken,
        setQuantities,
        loadCartData
    };
     const fetchFoodList = async () => {
        const response = await axios.get(`${API_URL}/foods`);
        return response.data;
    };

    useEffect(() => {
    async function loadData() {

        const data = await fetchFoodList();
        setFoodList(data);

        const storedToken = localStorage.getItem("token");

        if(storedToken){
            setToken(storedToken);
            await loadCartData(storedToken);
        }

    }

    loadData();

},[]);


    return (
        <StoreContext.Provider value={contextValue}>
            {props.children}
        </StoreContext.Provider>
    )
}