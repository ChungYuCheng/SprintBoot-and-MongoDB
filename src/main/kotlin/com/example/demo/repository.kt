package com.example.demo

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OrdersRepository : MongoRepository<Orders, String> {
	@Query("{'custNo': ?0}")
	fun findByCustNo(name:String): Orders
}
