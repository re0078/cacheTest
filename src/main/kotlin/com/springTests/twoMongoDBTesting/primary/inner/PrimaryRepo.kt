package com.springTests.twoMongoDBTesting.primary.inner

import com.springTests.twoMongoDBTesting.PublisherStat
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PrimaryRepo : MongoRepository<PublisherStat, String>