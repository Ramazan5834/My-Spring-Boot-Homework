package net.springboot.homework.service;

import java.util.List;

import net.springboot.homework.entities.Bill;

public interface BillService {
	List<Bill> getAllBills();
	void saveBill(Bill bill);
	Bill getBillById(long id);
	void deleteBillById(long id);
}
