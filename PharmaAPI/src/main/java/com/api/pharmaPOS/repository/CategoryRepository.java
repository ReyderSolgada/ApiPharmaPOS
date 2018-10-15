package com.api.pharmaPOS.repository;

import org.springframework.data.repository.CrudRepository;
import com.api.pharmaPOS.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
