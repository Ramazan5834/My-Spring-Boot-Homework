package net.springboot.homework.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bills")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "customer_name")
	private String customer_name;

	@Column(name = "customer_surname")
	private String customer_surname;

	@Column(name = "total_price")
	private int total_price;

	@Column(name = "bill_date")
	@Temporal(TemporalType.DATE)
	private Date bill_date;

	@Column(name = "admin_confirmed")
	private Boolean admin_confirmed;

	@Column(name = "employee_confirmed")
	private Boolean employee_confirmed;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "bill_id", referencedColumnName = "id")
	List<SoldProduct> sold_products = new ArrayList<>();

	public Bill() {

	}

	public Bill(String customer_name, String customer_surname, int total_price, Date bill_date, Boolean admin_confirmed,
			Boolean employee_confirmed, List<SoldProduct> sold_products) {
		super();
		this.customer_name = customer_name;
		this.customer_surname = customer_surname;
		this.total_price = total_price;
		this.bill_date = bill_date;
		this.admin_confirmed = admin_confirmed;
		this.employee_confirmed = employee_confirmed;
		this.sold_products = sold_products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_surname() {
		return customer_surname;
	}

	public void setCustomer_surname(String customer_surname) {
		this.customer_surname = customer_surname;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public Date getBill_date() {
		return bill_date;
	}

	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}

	public Boolean getAdmin_confirmed() {
		return admin_confirmed;
	}

	public void setAdmin_confirmed(Boolean admin_confirmed) {
		this.admin_confirmed = admin_confirmed;
	}

	public Boolean getEmployee_confirmed() {
		return employee_confirmed;
	}

	public void setEmployee_confirmed(Boolean employee_confirmed) {
		this.employee_confirmed = employee_confirmed;
	}

	public List<SoldProduct> getSold_products() {
		return sold_products;
	}

	public void setSold_products(List<SoldProduct> sold_products) {
		this.sold_products = sold_products;
	}

}
