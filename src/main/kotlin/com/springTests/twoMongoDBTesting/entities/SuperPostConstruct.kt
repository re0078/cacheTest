package com.springTests.twoMongoDBTesting.entities

import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class SuperPostConstruct {

    @PostConstruct
    fun test(){
        println("here in super class post construct")
    }
}