package com.mycompanylowcarpower.lowcarbpricemock.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompanylowcarpower.lowcarbpricemock.service.IPriceEnergyService;
import com.mycompanylowcarpower.lowcarbpricemock.service.bo.MomentPrice;

@RestController
@RequestMapping("/lowcarprice")
public class PriceEnergyController {

  private final IPriceEnergyService priceEnergy;

  public PriceEnergyController(IPriceEnergyService priceEnergy) {
    this.priceEnergy = priceEnergy;
  }
/*
  @GetMapping("/latest")
  public ResponseEntity<BigDecimal> getPrice() {
    return ResponseEntity.ok(priceEnergy.getPrice());
  }
*/
@GetMapping("/latest")
  public @ResponseBody MomentPrice getPrice() {
    return priceEnergy.getPrice();
  }

}
