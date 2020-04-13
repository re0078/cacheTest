package com.springTests.twoMongoDBTesting

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoDbFactory
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory


@Configuration
@EnableConfigurationProperties
class Configuration(
        @Value("\${spring.mongodb.secondary.uri}")
//        @Value("mongodb://localhost:27017/")
        val secondaryURI:String,
        @Value("\${spring.mongodb.secondary.database}")
        val dbName: String
) {

    @Bean
    @Primary
    fun mongoDbFactory(): MongoDbFactory {
        return SimpleMongoDbFactory(MongoClient("localhost", "27017".toInt()), "primary_db")
    }


    @Bean("primary-mongo-template")
    @Primary
    fun mongoTemplate(): MongoTemplate {
        return MongoTemplate(mongoDbFactory())
    }

    @Bean(name = ["secondary_mongodb_factory"])
    fun secondaryMongoDbFactory(): MongoDbFactory {
        println("db name is $dbName and uri is $secondaryURI")
        return SimpleMongoDbFactory(MongoClient(MongoClientURI(secondaryURI)), dbName)
    }

    @Bean(name = ["secondary_mongo_template"])
    fun secondaryMongoTemplate(): MongoTemplate {
        return MongoTemplate(secondaryMongoDbFactory())
    }
}