package com.springTests.twoMongoDBTesting.secondary

import com.springTests.twoMongoDBTesting.PublisherStat
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SecondaryRepo : MongoRepository<PublisherStat, String>