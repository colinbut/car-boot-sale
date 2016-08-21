/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.carbootsale.endpoints;

import com.mycompany.carbootsale.domain.Item;
import com.mycompany.carbootsale.exception.ItemNotFoundException;
import com.mycompany.carbootsale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item/")
public class ItemEndpoint {

    @Autowired
    private ItemService itemService;

    @RequestMapping(path = "list/", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getItems() {
        return itemService.listItems();
    }

    @RequestMapping(path = "get/", method = RequestMethod.GET)
    public ResponseEntity<Item> getItem(Item requestItem) {
        Item item = null;
        try {
            item = itemService.getItem(requestItem);
        } catch (ItemNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(item);
        }
        return ResponseEntity.ok(item);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
        ResponseEntity.notFound().build();
    }

    @RequestMapping(path = "/remove", method = RequestMethod.DELETE)
    public Item removeItem(@RequestBody Item requestItem) {
        Item item = null;
        try {
            item = itemService.removeItem(requestItem);
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        }
        return item;
    }


}
