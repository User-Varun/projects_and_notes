package com.quickcommerce.engine.customer.dto;

import com.quickcommerce.engine.inventory.model.InventoryItem;

import java.util.ArrayList;
import java.util.List;

public class PopulateHomePageResponse {

    private List<InventoryItemResponse> items;

    public PopulateHomePageResponse(List<InventoryItem> items) {
        
    }


    // show the products details and the onHandQuantity
//    public List<InventoryItemResponse> PopulateHomePageResponse(List<InventoryItem> inventoryItems){
//
//        items = new ArrayList<>();
//
//        if(inventoryItems == null) return null;
//
//        inventoryItems.forEach(item -> {
//           InventoryItemResponse newItem = new InventoryItemResponse();
//
//           newItem.
//           newItem.setOnHandQuantity(item.getOnHandQuantity());
//
//           items.add(newItem);
//        });
//
//        return items;
//
//
//    }
}
