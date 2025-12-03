package com.mongodbtz.mongotz;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public RedisCacheManager cacheManager (RedisConnectionFactory redisConnectionFactory) {

        String cacheMin = System.getProperty("param3");

        Map<String, RedisCacheConfiguration> cacheConfigurations = new HashMap<>();

        cacheConfigurations.put("cache_min_1", defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(cacheMin == null || cacheMin.isEmpty() ? 1
                        : Integer.parseInt(cacheMin))));

        cacheConfigurations.put("cache_min_2", defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(cacheMin == null || cacheMin.isEmpty() ? 2
                        : Integer.parseInt(cacheMin))));

        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(defaultCacheConfig())
                .withInitialCacheConfigurations(cacheConfigurations);

        return builder.build();
    }

    private RedisCacheConfiguration defaultCacheConfig() {

        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(
                        new GenericJackson2JsonRedisSerializer()));

    }

}