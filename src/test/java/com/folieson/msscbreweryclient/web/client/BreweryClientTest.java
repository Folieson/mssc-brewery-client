package com.folieson.msscbreweryclient.web.client;

import com.folieson.msscbreweryclient.web.model.BeerDto;
import com.folieson.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

  @Autowired
  private BreweryClient client;

  @Test
  void getBeerById() {
    BeerDto dto = client.getBeerById(UUID.randomUUID());
    assertNotNull(dto);
  }

  @Test
  void saveNewBeer() {
    BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
    URI uri = client.saveNewBeer(beerDto);

    assertNotNull(uri);
    System.out.println(uri);
  }

  @Test
  void updateBeer() {
    BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
    client.updateBeer(UUID.randomUUID(), beerDto);
  }

  @Test
  void deleteBeer() {
    client.deleteBeer(UUID.randomUUID());
  }

  @Test
  void getCustomerById() {
    CustomerDto dto = client.getCustomerById(UUID.randomUUID());
    assertNotNull(dto);
  }

  @Test
  void saveNewCustomer() {
    CustomerDto customerDto = CustomerDto.builder().name("John").build();
    URI uri = client.saveNewCustomer(customerDto);

    assertNotNull(uri);
    System.out.println(uri);
  }

  @Test
  void updateCustomer() {
    CustomerDto customerDto = CustomerDto.builder().name("John").build();
    client.updateCustomer(UUID.randomUUID(), customerDto);
  }

  @Test
  void deleteCustomer() {
    client.deleteCustomer(UUID.randomUUID());
  }
}