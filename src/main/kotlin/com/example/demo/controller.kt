package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/orders")
class OrderController(@Autowired val ordersService: OrdersService) {
	@GetMapping("/all")
	fun getAllOrders(): ResponseEntity<List<Orders>>
		= ResponseEntity.ok(ordersService.getAllOrders())

	@GetMapping("/size")
	fun getOrdersCount(): ResponseEntity<Int>
		= ResponseEntity.ok(ordersService.getOrdersSize())

	@GetMapping("/custNo")
	fun getOrdersByCustNo(): ResponseEntity<String> {
		return ResponseEntity.ok("找到的品號是 -> ${ordersService.getOrderByCustNo().custNo}")
	}
}
