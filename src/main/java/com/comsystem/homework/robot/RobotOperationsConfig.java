package com.comsystem.homework.robot;

import com.comsystem.homework.model.RobotPlan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotOperationsConfig {
    @Bean
    public RobotOperations robotOperations() {
        return new RobotOperations();
    }
}