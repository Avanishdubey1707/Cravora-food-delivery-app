import axios from "axios";
// import { API_URL } from "../../../foodies/src/service/authService";
export const API_URL = import.meta.env.VITE_BACKEND_URL;
const FOOD_API_URL=`${API_URL}/foods`;
export const addFood=async(foodData,image)=>{
    const formData = new FormData();
    formData.append('food',JSON.stringify(foodData));
    formData.append('file',image);


    try{ 
         await axios.post(FOOD_API_URL,formData,{headers:{"Content-Type":"multipart/form-data"}});
          
    
        }catch(error){
          console.log('Error',error);
          throw error;
    
        }

}

export const getFoodList = async () =>{
  try{
    const response= await axios.get(FOOD_API_URL);
    return response.data;
  }catch(error){
    console.log('Error fetching foot list',error);
    throw error;
  }
}
export const deleteFood = async (foodId) =>{
   try{
    const response = await axios.delete(FOOD_API_URL+"/"+foodId);
    return response.status === 204;

   }catch(error){
    console.log('Error while deleting the food.', error);
    throw error;
   }
}
