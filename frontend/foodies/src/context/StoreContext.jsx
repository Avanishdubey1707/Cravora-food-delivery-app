import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";
import axios from "axios";

export const StoreContext = createContext(null);

export const StoreContextProvider = (props) =>{

    const [foodList, setFoodList] = useState([]);
    const [quantities,setQuantities] = useState({});
    const [token ,setToken] = useState("");

    
    const increaseQty = async (foodId) => {
        setQuantities((prev) => ({...prev, [foodId]: (prev[foodId] || 0) +1}));

        await axios.post(
            "http://localhost:8080/api/cart",
            {foodId},
            {headers:{Authorization:`Bearer ${token}`}}
        );


    };
    const decreaseQty = (foodId) => {
        setQuantities((prev) => ({...prev, [foodId]: prev[foodId] >0 ? prev[foodId]-1:0}));

        axios.post('http://localhost:8080/api/cart/remove',{foodId},
            {headers:{Authorization: `Bearer ${token}`}}
        );
    };

    const removeFromCart = (foodId) => {
        setQuantities((prevQuantities)=> {
            const updatedQuantities = {...prevQuantities};
            delete updatedQuantities[foodId];
            return updatedQuantities;
        });
    };

   
    const contextValue={
        foodList,
        increaseQty,
        decreaseQty ,
        quantities,
        removeFromCart,
        token,
        setToken
    };
     const fetchFoodList = async () => {
        const response = await axios.get("http://localhost:8080/api/foods");
        return response.data;
    };

    useEffect(() => {
        async function loadData() {
           const data = await fetchFoodList();
           setFoodList(data);
           if(localStorage.getItem("token")){
            setToken(localStorage.getItem("token"));
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