/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.carbootsale.endpoints;

import com.mycompany.carbootsale.domain.Item;
import com.mycompany.carbootsale.exception.ItemNotFoundException;
import com.mycompany.carbootsale.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/item/")
public class ItemEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemEndpoint.class);

    @Autowired
    private ItemService itemService;


    @PostConstruct
    public void init() {
        LOGGER.info("Initializing {}", this.getClass().getSimpleName());
    }


    @RequestMapping(path = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getItems() {
        LOGGER.info("Retrieving items");
        return itemService.listItems();
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity<Item> getItem(@RequestParam("id") int id) {
        Item item = null;
        try {
            LOGGER.info("Getting item with item id: {}", id);
            item = itemService.getItem(id);
        } catch (ItemNotFoundException ex) {
            LOGGER.error("Error getting item - {}", ex);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(item);
        }
        return ResponseEntity.ok(item);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public void addItem(@RequestBody Item item) {
        LOGGER.error("Adding new item {}", item);
        itemService.addItem(item);
        ResponseEntity.notFound().build();
    }

    @RequestMapping(path = "/remove", method = RequestMethod.DELETE)
    public void removeItem(@RequestParam("id") int id) {
        try {
            itemService.removeItem(id);
        } catch (ItemNotFoundException ex) {
            LOGGER.error("Trying to remove an item that is not there - {}", ex);
        }
    }


}
