import React from 'react';
import './Cart.css'

const Cart = () => {
    return (
        <div className="container mt-5">
            <div className="row">

                <div className="col-lg-8">
                    <h3>Your Shopping Cart</h3>


                    <div className="cart-item d-flex justify-content-between">
                        <div className="d-flex">
                            <img src="https://via.placeholder.com/100" alt="Product" className="product-img me-3" />
                            <div>
                                <h5>Product Name 1</h5>
                                <p className="text-muted">Description of the product.</p>
                                <input type="number" className="form-control w-25" />
                            </div>
                        </div>
                        <div className="d-flex flex-column justify-content-between">
                            <span>$25.99</span>
                            <button className="btn btn-sm btn-danger">Remove</button>
                        </div>
                    </div>


                    <div className="cart-item d-flex justify-content-between">
                        <div className="d-flex">
                            <img src="https://via.placeholder.com/100" alt="Product" className="product-img me-3" />
                            <div>
                                <h5>Product Name 2</h5>
                                <p className="text-muted">Another product description.</p>
                                <input type="number" className="form-control w-25" />
                            </div>
                        </div>
                        <div className="d-flex flex-column justify-content-between">
                            <span>$19.99</span>
                            <button className="btn btn-sm btn-danger">Remove</button>
                        </div>
                    </div>

                </div>

                <div className="col-lg-4">
                    <div className="cart-summary">
                        <h4>Cart Summary</h4>
                        <ul className="list-unstyled">
                            <li className="d-flex justify-content-between">
                                <span>Subtotal:</span>
                                <span>$45.98</span>
                            </li>
                            <li className="d-flex justify-content-between">
                                <span>Shipping:</span>
                                <span>$5.00</span>
                            </li>
                            <li className="d-flex justify-content-between">
                                <span className="total-price">Total:</span>
                                <span className="total-price">$50.98</span>
                            </li>
                        </ul>
                        <button className="btn btn-checkout w-100">Proceed to Checkout</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Cart;