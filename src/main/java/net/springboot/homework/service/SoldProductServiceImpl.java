package net.springboot.homework.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.springboot.homework.entities.SoldProduct;
import net.springboot.homework.repositories.SoldProductRepository;

@Service
public class SoldProductServiceImpl implements SoldProductService {

	@Autowired
	private SoldProductRepository soldProductRepository;

	@Override
	public List<SoldProduct> getAllSoldProducts() {
		return soldProductRepository.findAll();
	}

	@Override
	public void saveSoldProduct(SoldProduct soldProduct) {
		this.soldProductRepository.save(soldProduct);
	}

	@Override
	public SoldProduct getProductById(long id) {
		Optional<SoldProduct> optional = soldProductRepository.findById(id);
		SoldProduct soldProduct = null;
		if (optional.isPresent()) {
			soldProduct = optional.get();
		} else {
			throw new RuntimeException("SoldProduct not found for id :: " + id);
		}
		return soldProduct;
	}

	@Override
	public void deleteSoldProductById(long id) {
		this.soldProductRepository.deleteById(id);
	}
	
	@Override
	public void deleteSoldProductAllById(List<Long> soldProductIds) {
		this.soldProductRepository.deleteAllById(soldProductIds);
	}

	@Override
	public void deleteSoldProductBeObject(SoldProduct soldProduct) {
		this.soldProductRepository.delete(soldProduct);
	}

	public void deleteWithRawSqlQuery(long sp_id) {
		soldProductRepository.deleteWithRawSqlQuery(sp_id);
	}
}
