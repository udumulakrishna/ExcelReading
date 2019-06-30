package com.thoneh.Excelreading.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thoneh.Excelreading.model.BankAccount;
import com.thoneh.Excelreading.model.Category;
import com.thoneh.Excelreading.model.Data_Designation;
import com.thoneh.Excelreading.model.EPFNumber;
import com.thoneh.Excelreading.model.ESINumber;
import com.thoneh.Excelreading.model.Photo;
import com.thoneh.Excelreading.model.SocsoNumber;
import com.thoneh.Excelreading.model.Staff;
import com.thoneh.Excelreading.model.TAXNumber;
import com.thoneh.Excelreading.repository.BankAccountRepository;
import com.thoneh.Excelreading.repository.CategoryRepository;
import com.thoneh.Excelreading.repository.Data_DesignationRepository;
import com.thoneh.Excelreading.repository.EPFNumberRepository;
import com.thoneh.Excelreading.repository.ESINumberRepository;
import com.thoneh.Excelreading.repository.SocsoNumberRepository;
import com.thoneh.Excelreading.repository.StaffRepository;
import com.thoneh.Excelreading.repository.TAXNumberRepository;
import com.thoneh.Excelreading.util.ExcelReader;

@RestController
@RequestMapping(value = "/upload")
public class UploadContrller {

	private Path rootLocation = Paths.get("C:/dasu/uploads");

	@Value("${fileUploadPath}")
	private String fileUploadPath;

	@Autowired
	private ExcelReader excelReader;

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private Data_DesignationRepository dataDesignationRepository;

	@Autowired
	private EPFNumberRepository epfNumberRepository;

	@Autowired
	private ESINumberRepository esiNumberRepository;

	@Autowired
	private SocsoNumberRepository socsoNumberRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private TAXNumberRepository taxNumberRepository;

	@RequestMapping(value = "/organizationData", method = RequestMethod.POST)
	public Photo uploadExcelSheet(@RequestBody MultipartFile file) throws IOException, InvalidFormatException {
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		if (!(extension.equalsIgnoreCase("xlsx") || extension.equalsIgnoreCase("xls"))) {

			throw new RuntimeException("Please select file with .xlsx or .xls");
		}

		String random = UUID.randomUUID().toString() + "." + extension;

		Files.copy(file.getInputStream(), this.rootLocation.resolve(random));
		System.out.println("uploaded success");
		String path = fileUploadPath + random;
		excelReader.readExcel(path);
		return new Photo(random, random, null);
	}

	
}
