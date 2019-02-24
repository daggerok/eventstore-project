package com.gituhb.daggerok.eventstore;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Objects;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class EventStoreApplicationTests {

  @Autowired
  WebTestClient webTestClient;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  public void testEventStore() {
    String expected = "to be continued...";
    webTestClient.get().uri("/")
                 .accept(APPLICATION_JSON_UTF8)
                 .exchange()
                 .expectStatus().is2xxSuccessful()
                 .expectHeader().contentType(APPLICATION_JSON_UTF8)
                 .expectBody()
                 .jsonPath("$.id").isNotEmpty()
                 .jsonPath("$.message").isEqualTo(expected)
                 .consumeWith(result -> {
                   byte[] maybeResponseBody = result.getResponseBody();
                   byte[] responseBody = Objects.requireNonNull(maybeResponseBody);
                   String body = new String(responseBody, UTF_8);
                   assertThat(body).isNotBlank();
                   assertThat(body).contains(expected);
                   log.info("body: {}", body);
                 })
    ;
  }
}
