package org.rookedsysc.coutableuuid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);        // 기본적으로 유지되는 스레드 수
        executor.setMaxPoolSize(50);         // 최대 스레드 수
        executor.setQueueCapacity(1000);     // 대기열에 들어갈 수 있는 작업 수
        executor.setThreadNamePrefix("UUID-Service-");
        executor.initialize();
        return executor;
    }
    @Bean(name = "taskExecutor2")
    public Executor taskExecutor2() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);        // 기본적으로 유지되는 스레드 수
        executor.setMaxPoolSize(50);         // 최대 스레드 수
        executor.setQueueCapacity(1000);     // 대기열에 들어갈 수 있는 작업 수
        executor.setThreadNamePrefix("UUID-Service-");
        executor.initialize();
        return executor;
    }
    @Bean(name = "taskExecutor3")
    public Executor taskExecutor3() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);        // 기본적으로 유지되는 스레드 수
        executor.setMaxPoolSize(50);         // 최대 스레드 수
        executor.setQueueCapacity(1000);     // 대기열에 들어갈 수 있는 작업 수
        executor.setThreadNamePrefix("UUID-Service-");
        executor.initialize();
        return executor;
    }
}
