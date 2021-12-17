package net.springboot.homework.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sold_products")
public class SoldProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "piece")
	private int piece;
	
	@Column(name = "in_basket")
	private Boolean in_basket;

	@Column(name = "product_id")
	private long product_id;
	
	@Column(name = "bill_id")
	private long bill_id;

	public SoldProduct() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}
	
	public Boolean getIn_basket() {
		return in_basket;
	}

	public void setIn_basket(Boolean in_basket) {
		this.in_basket = in_basket;
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public long getBill_id() {
		return bill_id;
	}

	public void setBill_id(long bill_id) {
		this.bill_id = bill_id;
	}




}
