/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.carbootsale.db.dao;

import com.mycompany.carbootsale.domain.Item;

import java.util.List;

public interface ItemDao {

    List<Item> getItems();

    void addItem(Item item);

    void deleteItem(Item item);

    Item getItem(int id);

}
