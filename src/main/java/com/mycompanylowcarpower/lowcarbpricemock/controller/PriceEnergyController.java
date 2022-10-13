package com.mycompanylowcarpower.lowcarbpricemock.controller;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mycompanylowcarpower.lowcarbpricemock.service.IPriceEnergyService;
import com.mycompanylowcarpower.lowcarbpricemock.service.QuotingService;
import com.mycompanylowcarpower.lowcarbpricemock.service.bo.MomentPrice;

@RestController
@RequestMapping("api/lowcarprice")
public class PriceEnergyController {
  private final IPriceEnergyService priceEnergy;
  private final QuotingService quotingService;
  public PriceEnergyController(IPriceEnergyService priceEnergy, QuotingService quotingService) {
    this.priceEnergy = priceEnergy;
    this.quotingService = quotingService;
  }
  /*
  @GetMapping("/latest")
  public ResponseEntity<MomentPrice> getPrice() {
    return ResponseEntity.ok(priceEnergy.getPrice());
  }
*/
  @GetMapping("/latest")
  public @ResponseBody MomentPrice getPrice() {
    return priceEnergy.getPrice();
  }
  @GetMapping("/nbkwh")
  public @ResponseBody BigDecimal getPriceByNbKwh(@PathVariable("nbkwh") BigDecimal nbkwh) {
    return quotingService.getPriceByNbKwh(nbkwh);
  }

}
