/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.carbootsale.service;

import com.mycompany.carbootsale.domain.Item;
import com.mycompany.carbootsale.exception.ItemNotFoundException;

import java.util.List;

public interface ItemService {

    List<Item> listItems();

    void addItem(Item item);

    void removeItem(int id) throws ItemNotFoundException;

    Item getItem(int id) throws ItemNotFoundException;

}
