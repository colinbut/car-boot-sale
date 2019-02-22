/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.carbootsale.carbootsale.controller

import com.mycompany.carbootsale.carbootsale.model.Item
import com.mycompany.carbootsale.carbootsale.repository.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/item/")
class ItemController {

    @Autowired
    private lateinit var itemRepository: ItemRepository

    @RequestMapping(path = ["/list"], method = [RequestMethod.GET])
    fun getItems() : List<Item> {
       return itemRepository.findAll().toList()
    }

    @RequestMapping(path = ["/get"], method = [RequestMethod.GET])
    fun getItem(@RequestParam("id") id : Int) : ResponseEntity<Item> {
        return ResponseEntity.ok(itemRepository.findById(id).get())
    }

    @RequestMapping(path = ["/add"], method = [RequestMethod.POST])
    fun addItem(@RequestBody item: Item) : ResponseEntity<Void> {
        itemRepository.save(item)
        return ResponseEntity.ok().build()
    }

    @RequestMapping(path = ["/remove"], method = [RequestMethod.DELETE])
    fun removeItem(@RequestParam("id") id : Int) : ResponseEntity<Void> {
        itemRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}