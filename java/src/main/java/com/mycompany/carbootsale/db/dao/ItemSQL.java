/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.carbootsale.db.dao;

/**
 * Having these SQL as constants in a separate class just incase Repository needs to use them as well.
 */
public final class ItemSQL {

    public static final String SELECT_ALL_ITEMS_SQL = "select id, name, description, price from item";

    public static final String INSERT_ITEM_SQL = "insert into item (name, description, price) values (?,?,?)";

    public static final String DELETE_ITEM_SQL = "delete from item where id = ?";

    public static final String SELECT_ONE_ITEM_SQL = "select id, name, description, price from item where id = ?";

    private ItemSQL() {}

}
