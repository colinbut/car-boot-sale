/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.carbootsale.db.dao.impl;

import com.mycompany.carbootsale.db.dao.ItemDao;
import com.mycompany.carbootsale.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;


@Repository
public class ItemDaoImpl implements ItemDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        LOGGER.info("Initializing {}", this.getClass().getSimpleName());
    }

    @Override
    public List<Item> getItems() {
        return jdbcTemplate.query("select name, description, price from item",
            (resultSet, i) -> {
                Item item = new Item();
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                return item;
            });
    }

    @Override
    public void addItem(Item item) {
        jdbcTemplate.update("insert into item (name, description, price) values (?,?,?)",
            item.getName(), item.getDescription(), item.getPrice());
    }

    @Override
    public void deleteItem(Item item) {
        jdbcTemplate.update("delete from item where id = ?", 1);
    }

    @Override
    public Item getItem(int id) {
        return jdbcTemplate.queryForObject("select name, description, price from item where id = ?",
            new Object[] {1L},
            (resultSet, i) -> {
                Item item = new Item();
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                return item;
            });
    }

}
