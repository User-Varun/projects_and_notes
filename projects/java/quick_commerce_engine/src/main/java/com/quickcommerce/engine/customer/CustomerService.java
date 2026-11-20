package com.quickcommerce.engine.customer;

import com.quickcommerce.engine.common.exceptions.CartNotFoundException;
import com.quickcommerce.engine.common.exceptions.UserNotFoundException;
import com.quickcommerce.engine.customer.dto.AddToCartRequest;
import com.quickcommerce.engine.customer.model.CartItem;
import com.quickcommerce.engine.customer.model.CustomerCart;
import com.quickcommerce.engine.customer.model.CustomerProfile;
import com.quickcommerce.engine.customer.repository.CartItemRepository;
import com.quickcommerce.engine.customer.repository.CustomerCartRepository;
import com.quickcommerce.engine.customer.repository.CustomerRepository;
import com.quickcommerce.engine.common.exceptions.InvalidQuantityException;
import com.quickcommerce.engine.common.exceptions.ProductNotFoundException;
import com.quickcommerce.engine.product.model.Product;
import com.quickcommerce.engine.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final CustomerCartRepository cartRepository;
    private final CartItemRepository cartItemRepository;


    public void getProducts(){

    }

    @Transactional
    public void addProductToCart(Long userId , AddToCartRequest request){

        // check for invalid quantity
        if(request.getQuantity() <= 0) throw new InvalidQuantityException(String.valueOf(request.getQuantity()));

        // find product from id;
        Product product = productRepository.findById(request.getProduct_id())
                .orElseThrow(() -> new ProductNotFoundException( String.valueOf(request.getProduct_id())));

        // find the customer profile
        CustomerProfile customer = customerRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.valueOf(userId)));

        // find customer cart
        CustomerCart cart =  cartRepository.findByCustomerId(userId).orElseThrow(() -> new CartNotFoundException(String.valueOf(userId)));
        
        // check if product exists
        CartItem item  = cartItemRepository.findByCartIdAndProductId(cart.getId() , product.getId()).orElse(null);

        if(item != null){
            // increase quantity;
            item.setQuantity(item.getQuantity() + request.getQuantity());


        }else{
            item = new CartItem();

            item.setQuantity(request.getQuantity());
            item.setCart(cart);
            item.setProduct(product);
        }

        // save the item;
        cartItemRepository.save(item);
    }
}
