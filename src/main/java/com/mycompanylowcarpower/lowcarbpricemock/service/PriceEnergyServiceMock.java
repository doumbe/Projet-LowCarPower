package com.mycompanylowcarpower.lowcarbpricemock.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.mycompanylowcarpower.lowcarbpricemock.service.bo.MomentPrice;

@Service
public class PriceEnergyServiceMock implements IPriceEnergyService {

  private static final Double MIN_VALUE = 0.8;
  private static final Double MAX_VALUE = 0.9;
  private static final Integer PRECISION = 4;
  private final Random randomValue;

  public PriceEnergyServiceMock() {
    this.randomValue = new Random();
  }

  @Override
  public MomentPrice getPrice() {
    double value = randomValue.doubles(1, MIN_VALUE, MAX_VALUE).findAny().orElse(0.8675);
    BigDecimal valueBigdecimal = BigDecimal.valueOf(value);

    MomentPrice momentPrice = new MomentPrice();
    momentPrice.setPrice(valueBigdecimal.round(new MathContext(PRECISION)));
    momentPrice.setDate(LocalDate.now());
    return momentPrice;
  }
}
