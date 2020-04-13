package com.springTests.twoMongoDBTesting

import org.cache2k.Cache2kBuilder
import org.cache2k.extra.spring.SpringCache2kCacheManager
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.util.function.Function


@Configuration
@EnableCaching
class CacheConfig {
    @Primary
    @Bean(name = [CACHE_MANAGER_NAME])
    fun cacheManager(): CacheManager {
        val caches = mutableListOf<Function<Cache2kBuilder<*, *>, Cache2kBuilder<*, *>>>()
        caches.add(buildCache2K("test", 100))
        return SpringCache2kCacheManager(CACHE_MANAGER_NAME).addCaches(*caches.toTypedArray())
    }

    fun buildCache2K(name: String, capacity: Long): Function<Cache2kBuilder<*, *>, Cache2kBuilder<out Any, out Any>> {
        return Function { b: Cache2kBuilder<*, *> ->
            b.entryCapacity(capacity)
                    .name(name)
                    .eternal(true)
        }
    }

    companion object {
        const val CACHE_MANAGER_NAME = "cache2KCacheManager"
    }
}