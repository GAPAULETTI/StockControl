package com.gypdev.stock.controller;

import com.gypdev.stock.model.Inventory;
import com.gypdev.stock.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {
    @Autowired
    InventoryRepository repoInventory;




}
