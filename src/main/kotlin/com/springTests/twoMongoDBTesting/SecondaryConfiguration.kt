package com.springTests.twoMongoDBTesting

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoDbFactory
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(basePackages = ["com.springTests.twoMongoDBTesting.secondary"], mongoTemplateRef = "secondary_mongo_template")
class SecondaryConfiguration {


}


@Configuration
@EnableMongoRepositories(basePackages = ["com.springTests.twoMongoDBTesting.primary"], mongoTemplateRef = "primary-mongo-template")
class primaryConfiguration {


}