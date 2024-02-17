package com.example.demo

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.stereotype.Component

@Component
@Document("orders")
data class Orders(
	@Id
	val id: ObjectId = ObjectId(),
	val custNo: String = ""
)
