package com.api.pharmaPOS.repository;

import org.springframework.data.repository.CrudRepository;
import com.api.pharmaPOS.entity.SalesOrderItem;

public interface SalesOrderItemRepository extends CrudRepository<SalesOrderItem, Integer> {

}
