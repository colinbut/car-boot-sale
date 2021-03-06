/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.carbootsale.service;

import com.mycompany.carbootsale.db.dao.ItemDao;
import com.mycompany.carbootsale.domain.Item;
import com.mycompany.carbootsale.exception.ItemNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemDao itemDao;

    @PostConstruct
    public void init() {
        LOGGER.info("Initializing {}", this.getClass().getSimpleName());
    }

    @Override
    public List<Item> listItems() {
        return itemDao.getItems();
    }

    @Override
    public void addItem(Item item) {
        itemDao.addItem(item);
    }

    @Override
    public void removeItem(int id) throws ItemNotFoundException {
        try {
            itemDao.getItem(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ItemNotFoundException("Item with item id: " + id + " Not Found", ex);
        }
        itemDao.deleteItem(id);
    }

    @Override
    public Item getItem(int id) throws ItemNotFoundException {
        Item item;
        try {
            item = itemDao.getItem(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ItemNotFoundException("Item with item id: " + id + " Not Found", ex);
        }
        return item;
    }

}
