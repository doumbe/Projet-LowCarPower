package com.mycompanylowcarpower.lowcarbpricemock.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompanylowcarpower.lowcarbpricemock.service.IPriceEnergyService;

@RestController
@RequestMapping("/lowcarprice")
public class PriceEnergyController {

  private final IPriceEnergyService priceEnergy;

  public PriceEnergyController(IPriceEnergyService priceEnergy) {
    this.priceEnergy = priceEnergy;
  }

  /*
  @GetMapping("/latest")
  public ResponseEntity<Price> getPrice() {
    Price price = new Price();
    Double randomValue = priceEnergy.getPrice().doubleValue();
    price.setPrice(randomValue.toString());
    return ResponseEntity.ok().body(price);
  }
   */

  @GetMapping("/latest")
  public String getPrice() {
    priceEnergy.getPrice().doubleValue();
    return ResponseEntity.ok(priceEnergy).toString();
  }

}
