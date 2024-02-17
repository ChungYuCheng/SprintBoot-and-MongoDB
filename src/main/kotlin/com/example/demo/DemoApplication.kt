package com.example.demo

import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import org.bson.Document
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.pojo.PojoCodecProvider
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)

	val mongoClient = MongoClients.create("mongodb://localhost:27017")
	val database = mongoClient.getDatabase("demo").withCodecRegistry(
			CodecRegistries.fromRegistries(
				MongoClientSettings.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
			)
	)
	val collection: MongoCollection<Document> = database.getCollection("orders")

	val document = Document("custNo", "201810324907")
	println("Inserted a document with the following id: ${document}")

	try {
        collection.drop()
		collection.insertOne(document)
	} catch (e: Exception) {
		println("exception -> ${e}")
	}

}
