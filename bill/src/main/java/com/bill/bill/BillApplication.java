package com.bill.bill;

import com.bill.bill.model.Bill;
import com.bill.bill.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BillApplication.class, args);
	}

	@Autowired
	private BillRepository billRepository;

	@Override
	public void run(String... args) throws Exception {
		Bill bill = new Bill();
		bill.setFirstName("kamal");
		bill.setLastName("rathnayake");
		bill.setUnits("60units");
		bill.setBillAmount("6500.00LKR");
		bill.setCusEmail("kamal@gmail.com");
		billRepository.save(bill);

		Bill bill1 = new Bill();
		bill1.setFirstName("amal");
		bill1.setLastName("karunanayake");
		bill1.setUnits("20units");
		bill1.setBillAmount("500.00LKR");
		bill1.setCusEmail("amal@gmail.com");
		billRepository.save(bill1);

	}
}
