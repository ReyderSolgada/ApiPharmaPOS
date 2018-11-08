package com.api.pharmaPOS.repository;

import org.springframework.data.repository.CrudRepository;
import com.api.pharmaPOS.entity.SalesOrder;

public interface SalesOrderRepository extends CrudRepository<SalesOrder, Integer> {

}
