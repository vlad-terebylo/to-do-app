package com.tvo.configuration;

import com.tvo.repository.TaskRepository;
import com.tvo.repository.jdbc.JdbcTaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

@Configuration
public class AppConfig {
    @Bean
    public TaskRepository getTaskRepository(NamedParameterJdbcOperations jdbcTemplate) {
        return new JdbcTaskRepository(jdbcTemplate);
    }
}
