package net.springboot.homework.service;
import java.util.List;

import net.springboot.homework.entities.SoldProduct;

public interface SoldProductService {
	List<SoldProduct> getAllSoldProducts();
	void saveSoldProduct(SoldProduct soldProduct);
	SoldProduct getProductById(long id);
	void deleteSoldProductById(long id);
	void deleteSoldProductAllById(List<Long> soldProductIds);
	void deleteSoldProductBeObject(SoldProduct soldProduct);
	 void deleteWithRawSqlQuery(long sp_id);
}
