package com.mycompagny.lowcarbpower.lowcarpower.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompagny.lowcarbpower.lowcarpower.model.Price;
import com.mycompagny.lowcarbpower.lowcarpower.service.PriceEnergy;
import com.mycompagny.lowcarbpower.lowcarpower.service.PriceEnergyService;

@RestController
@RequestMapping("/lowcarprice")
public class PriceEnergyController {

  private final PriceEnergy priceEnergy;

  public PriceEnergyController(PriceEnergy priceEnergy) {
    this.priceEnergy = priceEnergy;
  }

  @GetMapping("/latest")
  public ResponseEntity<Price> getPrice() {
    Price price = new Price();
    Double randomValue = priceEnergy.getPrice().doubleValue();
    price.setPrice(randomValue.toString());
    return ResponseEntity.ok().body(price);
  }

}
