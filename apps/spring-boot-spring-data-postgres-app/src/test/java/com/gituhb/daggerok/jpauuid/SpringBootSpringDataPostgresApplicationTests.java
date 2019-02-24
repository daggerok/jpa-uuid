package com.gituhb.daggerok.jpauuid;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Objects;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Collections.singletonMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SpringBootSpringDataPostgresApplicationTests {

  @Autowired
  WebTestClient webTestClient;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  public void test_MyAutoEntity() {
    String expected = "hello pg auto data!!111oneoneone";
    webTestClient.post().uri("/auto")
                 .accept(APPLICATION_JSON_UTF8)
                 .body(Mono.just(singletonMap("message", expected)), Map.class)
                 .exchange()
                 .expectStatus().is2xxSuccessful()
                 .expectHeader().contentType(APPLICATION_JSON_UTF8)
                 .expectBody()
                 .jsonPath("$.timestamp").isNotEmpty()
                 .jsonPath("$.modifiedAt").isNotEmpty()
                 .jsonPath("$.createdAt").isNotEmpty()
                 .jsonPath("$.id").isNotEmpty()
                 .jsonPath("$.message").isEqualTo(expected)
                 .consumeWith(result -> {
                   byte[] maybeResponseData = result.getResponseBody();
                   byte[] responseData = Objects.requireNonNull(maybeResponseData);
                   String responseBody = new String(responseData, UTF_8);
                   assertThat(responseBody).isNotBlank();
                   assertThat(responseBody).contains(expected);
                   log.info("auto body: {}", responseBody);
                 })
    ;
  }

  @Test
  public void test_MyManualEntity() {
    String expected = "hello pg manual data!";
    webTestClient.post().uri("/auto")
                 .accept(APPLICATION_JSON_UTF8)
                 .body(Mono.just(singletonMap("message", expected)), Map.class)
                 .exchange()
                 .expectStatus().is2xxSuccessful()
                 .expectHeader().contentType(APPLICATION_JSON_UTF8)
                 .expectBody()
                 .jsonPath("$.timestamp").isNotEmpty()
                 .jsonPath("$.modifiedAt").isNotEmpty()
                 .jsonPath("$.createdAt").isNotEmpty()
                 .jsonPath("$.id").isNotEmpty()
                 .jsonPath("$.message").isEqualTo(expected)
                 .consumeWith(result -> {
                   byte[] maybeResponseData = result.getResponseBody();
                   byte[] responseData = Objects.requireNonNull(maybeResponseData);
                   String responseBody = new String(responseData, UTF_8);
                   assertThat(responseBody).isNotBlank();
                   assertThat(responseBody).contains(expected);
                   log.info("manual body: {}", responseBody);
                 })
    ;
  }
}
