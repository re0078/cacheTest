package com.springTests.twoMongoDBTesting.entities

import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class SubPostConstruct {

    @PostConstruct
    fun test(){
        println("here in sub class post construct")
    }
}