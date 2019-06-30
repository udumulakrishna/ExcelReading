package com.thoneh.Excelreading.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.thoneh.Excelreading.model.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

}
