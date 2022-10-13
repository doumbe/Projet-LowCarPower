package com.mycompanylowcarpower.lowcarbpricemock.service;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mycompanylowcarpower.lowcarbpricemock.service.bo.MomentPrice;

@Service
public class QuotingService  {
  @Autowired
  private PriceEnergyServiceMock priceEnergyServiceMock;

  @Autowired
  private RestTemplate restTemplate;

  public QuotingService(PriceEnergyServiceMock priceEnergyServiceMock) {
    this.priceEnergyServiceMock = priceEnergyServiceMock;
  }

  // Retourne le prix actuel en fonction du nbkwh fournit par l'utilisateur
  public BigDecimal getPriceByNbKwh(BigDecimal nbkwh) {

    BigDecimal priceKwhMixEnergie = getPriceMixEnergie(nbkwh);
    BigDecimal monthlyEstimate = nbkwh.multiply(priceKwhMixEnergie);

    return monthlyEstimate;
  }

  // Calcul price KwhMix Energie pour obtenir le prix des deux energies
  private BigDecimal getPriceMixEnergie(BigDecimal nbkw) {

    BigDecimal priceCoalFired = getPriceFromCoalFired(nbkw);
    MomentPrice priceLowCarb = priceEnergyServiceMock.getPrice();
    BigDecimal priceKwhMixEnergie = priceCoalFired.multiply(BigDecimal.valueOf(19)).
        add(priceLowCarb.getPrice()).multiply(BigDecimal.valueOf(81));
    return priceKwhMixEnergie;
  }

  // Calcul prix fixe de 10 dollars pour 256kwh pour l’énergie carbonée.
  private BigDecimal getPriceFromCoalFired(BigDecimal nbkwh) {
    BigDecimal price =
        BigDecimal.valueOf(10);
    BigDecimal priceCoalFired =
        price.multiply(nbkwh).divide(BigDecimal.valueOf(256));
    return priceCoalFired;
  }

  public RestTemplate getRestTemplate() {
    return restTemplate;
  }

  public void setRestTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

}


















 /*
  @Override
  public BigDecimal getDisplayInvoice(BigDecimal nbKwh) {
    //IPriceEnergyService priceEnergy = new PriceEnergyServiceMock();
    //int price=  priceEnergy * lowcar * 10 + coalfired * 5;
    monthly_estimate = nbKwh.multiply(price_Kwh_Mix_Energie);
    price_Kwh_Mix_Energie =
        price_Kwh_Coal.multiply(BigDecimal.valueOf(19)).divide(BigDecimal.valueOf(100))
            .add(price_Kwh_LowCard.multiply(BigDecimal.valueOf(81).divide(BigDecimal.valueOf(100))));
    //return price_Kwh_Mix_Energie;
    return BigDecimal.ZERO;
  }
*/
//@Override
  /*
  public BigDecimal getQuoting() {

    BigDecimal nbKwh = BigDecimal.valueOf(256);
    BigDecimal monthly_estimate = nbKwh.multiply(price_Kwh_Mix_Energie);
    price_Kwh_Mix_Energie =
        price_Kwh_Coal.multiply(BigDecimal.valueOf(19)).divide(BigDecimal.valueOf(100))
            .add(monthly_estimate.multiply(BigDecimal.valueOf(81).divide(BigDecimal.valueOf(100))));
    return price_Kwh_Mix_Energie;
  }
*/