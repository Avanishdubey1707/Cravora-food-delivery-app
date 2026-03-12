import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";
import axios from "axios";

export const StoreContext = createContext(null);

export const StoreContextProvider = (props) =>{

    const [foodList, setFoodList] = useState([]);
   
    const contextValue={
        foodList
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