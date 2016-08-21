/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.carbootsale.service;

import com.mycompany.carbootsale.db.dao.ItemDao;
import com.mycompany.carbootsale.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> listItems() {
        return itemDao.getItems();
    }

    @Override
    public void addItem(Item item) {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    @Override
    public Item removeItem(Item item) {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    @Override
    public Item getItem(Item item) {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

}
