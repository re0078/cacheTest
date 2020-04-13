package com.springTests.twoMongoDBTesting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
class TwoMongoDbTestingApplication

fun main(args: Array<String>) {
	runApplication<TwoMongoDbTestingApplication>(*args)
}
