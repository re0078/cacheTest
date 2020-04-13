package com.springTests.twoMongoDBTesting

import com.fasterxml.jackson.databind.ObjectMapper
import com.springTests.twoMongoDBTesting.CacheConfig.Companion.CACHE_MANAGER_NAME
import com.springTests.twoMongoDBTesting.entities.*
import com.springTests.twoMongoDBTesting.primary.inner.PrimaryRepo
import com.springTests.twoMongoDBTesting.secondary.SecondaryRepo
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/save")
class Controller(
        @Value("#{'\${spring.list}'.split(',')}")
        val list: List<String>,
//        @Value("#{SPELTest(-1, -1) == SPELTest(-1, -2)}")
//        val bool: Boolean,
        val mapper: ObjectMapper,
        @Value("#{250 > 200 and 200 < 4000}") // true
        val bool2: Boolean,
        val mongoOperations: MongoOperations,
        val mongoTemplate: MongoTemplate,
        val primaryRepo: PrimaryRepo,
        val secondaryRepo: SecondaryRepo
) {

    @PostMapping("/")
    fun save(@RequestBody publisherStat: PublisherStat): String {
        primaryRepo.save(publisherStat)
        secondaryRepo.save(publisherStat)
        return "ok"
    }

    @PostMapping("dynamic-field")
    fun dynamicSave(@RequestBody field: DynamicField): String {
        val update = Update()
        update.set(field.fieldName, field.value)
        val criteria = Criteria("_id").`is`(field.id)
        mongoOperations.upsert(Query(criteria), update, "publisher_alert_stat")
        return "done"
    }

    @GetMapping("dynamic-get")
    fun dynamicGet(@RequestBody id: String): PublisherStat? {
        println("in dynamic get $id")
        val stat = primaryRepo.findById(id)
        println("stat catch")
        return if (stat.isPresent) stat.get() else null
    }

    @GetMapping("get-all")
    fun getAll(): MutableList<PublisherStat> {
        return primaryRepo.findAll()
    }

    @Cacheable(cacheNames = ["test"], cacheManager = CACHE_MANAGER_NAME, key = "#integer")
    fun cachedFun(integer: Int): Int {
        println("in cached function")
        return 50
    }

    @PostConstruct
    fun init() {
        cachedFun(1)
        cachedFun(1)
    }
}

