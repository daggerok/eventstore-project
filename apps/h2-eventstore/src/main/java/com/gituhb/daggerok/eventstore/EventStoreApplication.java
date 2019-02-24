package com.gituhb.daggerok.eventstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.OffsetDateTime;
import java.util.Optional;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
    EventStoreApplication.class,
    Jsr310JpaConverters.class,
})
@EnableJpaAuditing(dateTimeProviderRef = "zonedDateTimeProvider")
public class EventStoreApplication {

  @Bean(name = "zonedDateTimeProvider")
  public DateTimeProvider zonedDateTimeProvider() {
    return () -> Optional.of(OffsetDateTime.now());
  }

  public static void main(String[] args) {
    SpringApplication.run(EventStoreApplication.class, args);
  }
}
