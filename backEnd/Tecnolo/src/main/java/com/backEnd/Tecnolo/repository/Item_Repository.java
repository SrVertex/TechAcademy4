package com.backEnd.Tecnolo.repository;

import com.backEnd.Tecnolo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Item_Repository extends JpaRepository<Item, Integer> {
}
