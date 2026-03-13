import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";
import axios from "axios";

export const StoreContext = createContext(null);

export const StoreContextProvider = (props) =>{

    const [foodList, setFoodList] = useState([]);
    const [quantities,setQuantities] = useState({});

    const increaseQty = (foodId) => {
        setQuantities((prev) => ({...prev, [foodId]: (prev[foodId] || 0) +1}));
    }
    const decreaseQty = (foodId) => {
        setQuantities((prev) => ({...prev, [foodId]: prev[foodId] >0 ? prev[foodId]-1:0}));
    }

   
    const contextValue={
        foodList,
        increaseQty,
        decreaseQty ,
        quantities
    };
     const fetchFoodList = async () => {
        const response = await axios.get("http://localhost:8080/api/foods");
        return response.data;
    };

    useEffect(() => {
        async function loadData() {
           const data = await fetchFoodList();
           setFoodList(data);
            
        }
        loadData();
    },[]);


    return (
        <StoreContext.Provider value={contextValue}>
            {props.children}
        </StoreContext.Provider>
    )
}