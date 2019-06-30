package com.thoneh.Excelreading.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thoneh.Excelreading.model.BankAccount;
import com.thoneh.Excelreading.model.Category;
import com.thoneh.Excelreading.model.Data_Designation;
import com.thoneh.Excelreading.model.EPFNumber;
import com.thoneh.Excelreading.model.ESINumber;
import com.thoneh.Excelreading.model.PendingData;
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

@Component
@Transactional
public class ExcelReader {

	public final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\startup\\Downloads\\Master.xls";

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Autowired
	private TAXNumberRepository taxNumberRepository;

	@Autowired
	private EPFNumberRepository epfNumberRepository;
	
	
	@Autowired
	private Data_DesignationRepository dataDesignationRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;


	@Autowired
	private ESINumberRepository esiNumberRepository;

	@Autowired
	private SocsoNumberRepository socsoNumberRepository;

	@Autowired
	private Data_DesignationRepository data_DesignationRepository;
	
	public void checkDataBase() {
		List<BankAccount> bankAccounts = (List<BankAccount>) bankAccountRepository.findAll();

		if (bankAccounts != null && bankAccounts.size() > 0) {
			throw new RuntimeException("Data Already Exists !!!");
		}
		List<Category> categorys = (List<Category>) categoryRepository.findAll();

		if (categorys != null && categorys.size() > 0) {
			throw new RuntimeException("Data Already Exists !!!");
		}

		List<Data_Designation> data_Designations = (List<Data_Designation>) dataDesignationRepository.findAll();

		if (data_Designations != null && data_Designations.size() > 0) {
			throw new RuntimeException("Data Already Exists !!!");
		}
		List<EPFNumber> epfNumbers = (List<EPFNumber>) epfNumberRepository.findAll();

		if (epfNumbers != null && epfNumbers.size() > 0) {
			throw new RuntimeException("Data Already Exists !!!");
		}
		List<ESINumber> esiNumbers = (List<ESINumber>) esiNumberRepository.findAll();
		if (esiNumbers != null && esiNumbers.size() > 0) {
			throw new RuntimeException("Data Already Exists !!!");
		}
		List<SocsoNumber> socsoNumbers = (List<SocsoNumber>) socsoNumberRepository.findAll();
		if (socsoNumbers != null && socsoNumbers.size() > 0) {
			throw new RuntimeException("Data Already Exists !!!");
		}
		List<Staff> staffList = (List<Staff>) staffRepository.findAll();
		if (staffList != null && staffList.size() > 0) {
			throw new RuntimeException("Data Already Exists !!!");
		}
		List<TAXNumber> taxNumbers = (List<TAXNumber>) taxNumberRepository.findAll();
		if (taxNumbers != null && taxNumbers.size() > 0) {
			throw new RuntimeException("Data Already Exists !!!");
		}
	}

	
	public void readExcel(String fileName) throws IOException, InvalidFormatException {
		if (fileName.endsWith(".xlsx")) {
			System.out.println(".xlsx file is detected...");
			readingExcel(fileName);
		} else if (fileName.endsWith(".xls")) {
			System.out.println(".xls file is detected...");
			readingExcel(fileName);
		} else {
			System.out.println("Unsupported file format");
		}
	}


	public void readingExcel(String filename) throws IOException, InvalidFormatException {
		checkDataBase();
		createBankAccount(filename);
		createTaxNumber(filename);
		createEPFAccount(filename);
		createEIS(filename);
		createSosco(filename);
		createDesignation(filename);
	}

	@Transactional
	void createBankAccount(String filename) throws EncryptedDocumentException, InvalidFormatException, IOException {

		Workbook workbook = WorkbookFactory.create(new File(filename));
		Sheet bankSheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
		Iterator<Row> rowIterator = bankSheet.rowIterator();
		Row row1 = rowIterator.next();
		Row row2 = rowIterator.next();
		//PendingData pendingData=new PendingData();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			// Now let's iterate over the columns of the current row
			Iterator<Cell> cellIterator = row.cellIterator();
			List<String> list = new ArrayList<String>();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = dataFormatter.formatCellValue(cell);
				list.add(cellValue);
				System.out.print(cellValue + "\t");
			}

			/**
			 * 
			 */
			Staff staff = new Staff();
			staff.setStaffId(list.get(0));
			staff.setFullName(list.get(1));
			staff = staffRepository.save(staff);

			BankAccount bankAccount = new BankAccount();
			bankAccount.setBankAccountNumber(list.get(2));
			bankAccount.setBankName(list.get(3));
			bankAccount.setBranchCode(list.get(4));
			bankAccount.setStaff(staff);
			bankAccountRepository.save(bankAccount);

			
		}
		workbook.close();

	}

	void createTaxNumber(String filename) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		Workbook workbook = WorkbookFactory.create(new File(filename));
		Sheet taxNumberSheet = workbook.getSheetAt(1);
		DataFormatter dataFormatter = new DataFormatter();
		System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
		Iterator<Row> rowIterator = taxNumberSheet.rowIterator();
		Row row1 = rowIterator.next();
		Row row2 = rowIterator.next();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			// Now let's iterate over the columns of the current row
			Iterator<Cell> cellIterator = row.cellIterator();
			List<String> list = new ArrayList<String>();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = dataFormatter.formatCellValue(cell);
				list.add(cellValue);
				System.out.print(cellValue + "\t");
			}

			/**
			 * 
			 */
			Staff staff = staffRepository.findByStaffId(list.get(0));
			TAXNumber taxNumber = new TAXNumber();
			taxNumber.setICNO(list.get(3));
			taxNumber.setTAXNO(list.get(2));
			taxNumber.setStaff(staff);
			taxNumberRepository.save(taxNumber);
	
		}
		workbook.close();

	}

	void createEPFAccount(String filename) throws EncryptedDocumentException, InvalidFormatException, IOException {

		Workbook workbook = WorkbookFactory.create(new File(filename));
		Sheet epfSheet = workbook.getSheetAt(2);
		DataFormatter dataFormatter = new DataFormatter();
		System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
		Iterator<Row> rowIterator = epfSheet.rowIterator();
		Row row1 = rowIterator.next();
		Row row2 = rowIterator.next();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			// Now let's iterate over the columns of the current row
			Iterator<Cell> cellIterator = row.cellIterator();
			List<String> list = new ArrayList<String>();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = dataFormatter.formatCellValue(cell);
				list.add(cellValue);
				System.out.print(cellValue + "\t");
			}

			/**
			 * 
			 */
			Staff staff = staffRepository.findByStaffId(list.get(0));
			EPFNumber epfNumber = new EPFNumber();
			epfNumber.setICNO(list.get(2));
			epfNumber.setICNO(list.get(3));
			epfNumber.setStaff(staff);
			epfNumberRepository.save(epfNumber);
		}
		workbook.close();
	}

	void createEIS(String filename) throws EncryptedDocumentException, InvalidFormatException, IOException {

		Workbook workbook = WorkbookFactory.create(new File(filename));
		Sheet eisSheet = workbook.getSheetAt(3);
		DataFormatter dataFormatter = new DataFormatter();
		System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
		Iterator<Row> rowIterator = eisSheet.rowIterator();
		Row row1 = rowIterator.next();
		Row row2 = rowIterator.next();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			// Now let's iterate over the columns of the current row
			Iterator<Cell> cellIterator = row.cellIterator();
			List<String> list = new ArrayList<String>();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = dataFormatter.formatCellValue(cell);
				list.add(cellValue);
				System.out.print(cellValue + "\t");
			}

			/**
			 * 
			 */
			Staff staff = staffRepository.findByStaffId(list.get(0));
			ESINumber esiNumber = new ESINumber();
			esiNumber.setESINO(list.get(2));
			esiNumber.setEIS_EMPLOYER_NO(list.get(3));
			esiNumber.setStaff(staff);
			esiNumberRepository.save(esiNumber);
		}
		workbook.close();

	}

	void createSosco(String filename) throws IOException, EncryptedDocumentException, InvalidFormatException {
		Workbook workbook = WorkbookFactory.create(new File(filename));
		Sheet soscoSheet = workbook.getSheetAt(4);
		DataFormatter dataFormatter = new DataFormatter();
		System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
		Iterator<Row> rowIterator = soscoSheet.rowIterator();
		Row row1 = rowIterator.next();
		Row row2 = rowIterator.next();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			// Now let's iterate over the columns of the current row
			Iterator<Cell> cellIterator = row.cellIterator();
			List<String> list = new ArrayList<String>();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = dataFormatter.formatCellValue(cell);
				list.add(cellValue);
				System.out.print(cellValue + "\t");
			}

			/**
			 * 
			 */
			Staff staff = staffRepository.findByStaffId(list.get(0));
			SocsoNumber socsoNumber = new SocsoNumber();
			socsoNumber.setStaff(staff);
			socsoNumber.setSocsoNo(list.get(2));
			socsoNumber.setSOCSO_EMPLOYER_NO(list.get(3));
			socsoNumberRepository.save(socsoNumber);

		}
		workbook.close();

	}

	void createDesignation(String filename) throws EncryptedDocumentException, InvalidFormatException, IOException {
		Workbook workbook = WorkbookFactory.create(new File(filename));
		Sheet epfSheet = workbook.getSheetAt(5);
		DataFormatter dataFormatter = new DataFormatter();
		System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
		Iterator<Row> rowIterator = epfSheet.rowIterator();
		Row row1 = rowIterator.next();
		Row row2 = rowIterator.next();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			// Now let's iterate over the columns of the current row
			Iterator<Cell> cellIterator = row.cellIterator();
			List<String> list = new ArrayList<String>();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = dataFormatter.formatCellValue(cell);
				list.add(cellValue);
				System.out.print(cellValue + "\t");
			}

			/**
			 * 
			 */
			Staff staff = staffRepository.findByStaffId(list.get(0));
			Data_Designation data_Designation=new Data_Designation();
			data_Designation.setStaff(staff);
			data_Designation.setReportno(list.get(6));
		//	data_Designation.setDatejoined(list.get(10));
			data_Designation.setCurrentDesignatonStartData(list.get(7));
			data_Designation.setCurrentDesignatonEndData(list.get(8));
			data_Designation.setCurrentPosition(list.get(9));
			data_DesignationRepository.save(data_Designation);
			
			
		}
		workbook.close();

	}

}
