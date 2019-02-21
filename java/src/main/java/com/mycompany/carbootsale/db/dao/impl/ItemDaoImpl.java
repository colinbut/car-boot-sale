/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.carbootsale.db.dao.impl;

import com.mycompany.carbootsale.db.dao.ItemDao;
import com.mycompany.carbootsale.db.dao.ItemSQL;
import com.mycompany.carbootsale.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class ItemDaoImpl implements ItemDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final ItemRowMapper itemRowMapper;

    public ItemDaoImpl() {
        itemRowMapper = new ItemRowMapper();
    }

    @PostConstruct
    public void init() {
        LOGGER.info("Initializing {}", this.getClass().getSimpleName());
    }

    @Override
    public List<Item> getItems() {
        return jdbcTemplate.query(ItemSQL.SELECT_ALL_ITEMS_SQL, itemRowMapper);
    }

    @Override
    public void addItem(Item item) {
        jdbcTemplate.update(ItemSQL.INSERT_ITEM_SQL, item.getName(), item.getDescription(), item.getPrice());
    }

    @Override
    public void deleteItem(int id) {
        jdbcTemplate.update(ItemSQL.DELETE_ITEM_SQL, id);
    }

    @Override
    public Item getItem(int id) {
        return jdbcTemplate.queryForObject(ItemSQL.SELECT_ONE_ITEM_SQL, new Object[] {id}, itemRowMapper);
    }

    private class ItemRowMapper implements RowMapper<Item> {

        @Override
        public Item mapRow(ResultSet resultSet, int i) throws SQLException {
            Item item = new Item();
            item.setId(resultSet.getInt("id"));
            item.setName(resultSet.getString("name"));
            item.setDescription(resultSet.getString("description"));
            item.setPrice(resultSet.getDouble("price"));
            return item;
        }

    }

}
