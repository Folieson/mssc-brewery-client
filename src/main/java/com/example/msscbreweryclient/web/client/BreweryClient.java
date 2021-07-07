package com.example.msscbreweryclient.web.client;

import com.example.msscbreweryclient.web.model.BeerDto;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
@Setter
public class BreweryClient {
  private final String BEER_PATH = "/api/v1/beer/";
  private final RestTemplate restTemplate;
  private String apiHost;

  public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public BeerDto getBeerById(UUID id) {
    return restTemplate.getForObject(apiHost + BEER_PATH + id.toString(), BeerDto.class);
  }

  public URI saveNewBeer(BeerDto beerDto) {
    return restTemplate.postForLocation(apiHost + BEER_PATH, beerDto);
  }

  public void updateBeer(UUID id, BeerDto beerDto) {
    restTemplate.put(apiHost + BEER_PATH + id.toString(), beerDto);
  }
}
