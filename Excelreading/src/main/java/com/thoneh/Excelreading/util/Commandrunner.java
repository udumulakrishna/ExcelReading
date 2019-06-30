package com.thoneh.Excelreading.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Commandrunner implements CommandLineRunner {

	@Autowired
	private ExcelReader excelReader;
	@Override
	public void run(String... args) throws Exception {
		//excelReader.readExcel();
	}

}
