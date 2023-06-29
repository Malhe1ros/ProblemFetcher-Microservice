package ufrn.br.codeforces.configuration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableCaching
public class ApplicationConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }

    @Bean
    public RedissonReactiveClient redissonReactiveClient() {
        Config config = new Config();
        // Configure Redis connection details
        config.useSingleServer().setAddress("redis://localhost:6380");
        // Additional configuration if needed

        return Redisson.createReactive(config);
    }

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<Cache> caches = new ArrayList<Cache>();
        caches.add(new ConcurrentMapCache("myCache"));
        cacheManager.setCaches(caches);
        return cacheManager;
    }


}
