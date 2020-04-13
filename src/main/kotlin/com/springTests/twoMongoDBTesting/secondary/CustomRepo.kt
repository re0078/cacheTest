package com.springTests.twoMongoDBTesting.secondary

import com.springTests.twoMongoDBTesting.PublisherStat
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomRepo : MongoRepository<PublisherStat, String> {
}