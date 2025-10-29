package ru.klgd.javadev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.klgd.javadev.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByDate(Date date);

}
