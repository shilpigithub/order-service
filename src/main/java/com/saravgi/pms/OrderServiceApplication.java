package com.saravgi.pms;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saravgi.pms.model.Order;
import com.saravgi.pms.repository.OrderDao;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class OrderServiceApplication {

	@Autowired
	private OrderDao orderDao;

	@GetMapping
	public List<Order> fetchOrders() {
		return orderDao.getOrders();
		// code modification after deployment
		//return orderDao.getOrders().stream().sorted(Comparator.comparing(Order::getPrice)).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
