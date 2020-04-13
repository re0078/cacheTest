package com.springTests.twoMongoDBTesting.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "outer")
class OuterEntity
(
        @Id
        val id: String,
        val inners: Map<String, InnerEntity>,
        val extra: Int
)
