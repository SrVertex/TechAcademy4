package com.backEnd.Tecnolo.controller;

import com.backEnd.Tecnolo.repository.Item_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private Item_Repository repository;

}
