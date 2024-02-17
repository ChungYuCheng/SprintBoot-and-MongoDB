package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrdersService(@Autowired val ordersRepository:OrdersRepository) {
	fun getAllOrders() : List<Orders> = ordersRepository.findAll()

	fun getOrdersSize(): Int = ordersRepository.findAll().size

	fun getOrderByCustNo(): Orders {
		return ordersRepository.findByCustNo("201810324907")
	}
}
