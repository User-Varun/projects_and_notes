package com.quickcommerce.engine.customer;

import com.quickcommerce.engine.common.exceptions.CartNotFoundException;
import com.quickcommerce.engine.common.exceptions.UserNotFoundException;
import com.quickcommerce.engine.customer.dto.AddToCartRequest;
import com.quickcommerce.engine.customer.dto.GetNearestStoreRequest;
import com.quickcommerce.engine.customer.model.CartItem;
import com.quickcommerce.engine.customer.model.CustomerAddress;
import com.quickcommerce.engine.customer.model.CustomerCart;
import com.quickcommerce.engine.customer.model.CustomerProfile;
import com.quickcommerce.engine.customer.repository.CartItemRepository;
import com.quickcommerce.engine.customer.repository.CustomerCartRepository;
import com.quickcommerce.engine.customer.repository.CustomerRepository;
import com.quickcommerce.engine.common.exceptions.InvalidQuantityException;
import com.quickcommerce.engine.common.exceptions.ProductNotFoundException;
import com.quickcommerce.engine.darkstore.DarkStoreRepository;
import com.quickcommerce.engine.darkstore.DarkStoreService;
import com.quickcommerce.engine.darkstore.model.DarkStore;
import com.quickcommerce.engine.inventory.DarkStoreInventoryRepository;
import com.quickcommerce.engine.inventory.model.InventoryItem;
import com.quickcommerce.engine.product.model.Product;
import com.quickcommerce.engine.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final CustomerCartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final DarkStoreService darkStoreService;
    private final DarkStoreInventoryRepository darkStoreInventoryRepository;


    @Transactional
    public String addProductToCart(Long userId , AddToCartRequest request){

        // check for invalid quantity
        if(request.getQuantity() <= 0) throw new InvalidQuantityException(String.valueOf(request.getQuantity()));

        // find user's coords
        CustomerProfile customer = customerRepository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException(String.valueOf(userId)));


        // handle customer with no saved address
        if(customer.getAddresses().get(0) == null){
            return "no saved addresses, can't add product to cart";
        }

        CustomerAddress  address = customer.getAddresses().get(0);


        // get nearest darkstore
        DarkStore darkStore = darkStoreService.getNearestStore(address.getLatitude() , address.getLongitude()).orElse(null);

        // if darkstore not found
        if(darkStore == null) return "darkstore not found , can't add item to cart";


        // check if item present in the inventory at nearest darkstore
        InventoryItem item = darkStoreInventoryRepository
                .findByDarkStoreIdAndProductId(darkStore.getId() , request.getProductId())
                .orElse(null);

        if(item == null) return "no item found with given product id or item not available at darkstore";


        // find customer cart
        CustomerCart cart =  cartRepository.findByCustomerId(userId).orElseThrow(() -> new CartNotFoundException(String.valueOf(userId)));


        // check if product exists in customer's cart
        CartItem cartItem  = cartItemRepository.findByProductId(request.getProductId()).orElse(null);


        if(cartItem != null){
            // increase quantity;
            if(item.getOnHandQuantity() > request.getQuantity()){
                cartItem.setQuantity(item.getOnHandQuantity());
            }else{
                cartItem.setQuantity(cartItem.getQuantity() + request.getQuantity());
            }


        }else{
            cartItem = new CartItem();

            cartItem.setQuantity(request.getQuantity());
            cartItem.setCart(cart);

            Product product = productRepository.findById(request.getProductId()).orElse(null);

            if(product == null) return "can't find product in the repository, so can't add product to cart";

            cartItem.setProduct(product);
        }

        // save the item;
        CartItem saved = cartItemRepository.save(cartItem);

        return "Saved to cart Successfully " + saved.toString();
    }

    public String addAddress(long userId , double lat , double lng , boolean isDefault){

        CustomerProfile customerProfile = customerRepository.findByUserId(userId).orElse(null);

        if(customerProfile == null) return "user Profile not found";

        CustomerAddress address = new CustomerAddress();

        address.setCustomer(customerProfile);
        address.setLatitude(lat);
        address.setLongitude(lng);
        address.setIs_default(isDefault);

        customerProfile.getAddresses().add(address);

        customerRepository.save(customerProfile);

        return "address saved successfully";
    }
}
