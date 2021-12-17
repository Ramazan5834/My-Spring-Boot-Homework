package net.springboot.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.springboot.homework.entities.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

}
