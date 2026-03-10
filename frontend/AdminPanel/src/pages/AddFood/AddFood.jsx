import React from 'react';
import { assets } from '../../assets/assets';


const AddFood = () => {
  return (
    <div className="mx-2 mt-2">
      <div className="row ">
        <div className=" card col-md-4">
          <div className="card-body">
            <h2 className="mb-4">Add Food</h2>
            <form>
               <div className="mb-3">
                <label htmlFor="image" className="form-label">
                  <img src={assets.upload} alt="" width={98} />
                </label>
                <input type="file" className="form-control" id="image" required hidden/>
              </div>
              <div className="mb-3">
                <label htmlFor="name" className="form-label">Name</label>
                <input type="text" className="form-control" id="name" required name='name' />
              </div>
              <div className="mb-3">
                <label htmlFor="description" className="form-label">Description</label>
                <textarea className="form-control" id="description" rows="5" required name='description' ></textarea>

              </div>
              <div className="mb-3">
                <label htmlFor="category" className="form-label">Category</label>
                <select name="category" className='form-control'>
                  <option value="Cake" >Cake</option>
                  <option value="Ice Cream" >Ice Cream</option>
                  <option value="Pizza" >Pizza</option>
                  <option value="Biryani" >Biryani</option>
                  <option value="Rolls">Rolls</option>
                  <option value="Salad" >Salad</option>
                  <option value="Gulab jamun" >Gulab jamun</option>
                </select>
              </div>
              <div className="mb-3">
                <label htmlFor="price" className="form-label">Price</label>
                <input type="number" name="price" className="form-control" id="price" />
              </div>
              <button type="submit" className='btn btn-primary'>Save</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  )
}

export default AddFood
