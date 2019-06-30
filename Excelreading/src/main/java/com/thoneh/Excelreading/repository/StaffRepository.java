package com.thoneh.Excelreading.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.thoneh.Excelreading.model.Staff;

public interface StaffRepository extends PagingAndSortingRepository<Staff, Long> {

	Staff findByStaffId(String string);

}
