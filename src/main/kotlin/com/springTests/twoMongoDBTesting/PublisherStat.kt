package com.springTests.twoMongoDBTesting

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document(collection = "publisher_alert_stat")
class PublisherStat(
        @Id
        val publisherId: String,
        var risk: Double
)