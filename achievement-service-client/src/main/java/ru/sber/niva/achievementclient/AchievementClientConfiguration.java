package ru.sber.niva.achievementclient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages= "ru.sber.niva.achievementclient")
public class AchievementClientConfiguration {
}
