package ru.klgd.javadev.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.klgd.javadev.entity.Order;
import ru.klgd.javadev.repository.OrderRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public List<Order> getOrders() {
        return repository.findAll();
    }

    public Order getOrderById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void deleteAllOrders() {
        repository.deleteAll();
    }

    public List<Order> getOrdersByDate(Date date) {
        return repository.findAllByDate(date);
    }
}
