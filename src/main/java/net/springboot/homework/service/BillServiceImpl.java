package net.springboot.homework.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.springboot.homework.entities.Bill;
import net.springboot.homework.repositories.BillRepository;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	private BillRepository billRepository;
	
	@Override
	public List<Bill> getAllBills() {
		return billRepository.findAll();
	}

	@Override
	public void saveBill(Bill bill) {
		this.billRepository.save(bill);
	}

	@Override
	public Bill getBillById(long id) {
		Optional<Bill> optional = billRepository.findById(id);
		Bill bill = null;
		if (optional.isPresent()) {
			bill = optional.get();
		} else {
			throw new RuntimeException("Bill not found for id :: " + id);
		}
		return bill;
	}

	@Override
	public void deleteBillById(long id) {
		this.billRepository.deleteById(id);
	}

}
