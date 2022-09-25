package com.mycompagny.lowcarbpower.lowcarpower.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class PriceEnergyService implements PriceEnergy {

  private static final double MIN_VALUE = 0.8;
  private static final double MAX_VALUE = 0.9;
  private static final int PRECISION = 4;
  private final Random randomValue;

  public PriceEnergyService() {
    this.randomValue = new Random();
  }

  @Override
  public BigDecimal getPrice() {
    Double value = randomValue.doubles(1, MIN_VALUE, MAX_VALUE).findAny().orElse(0.8675);
    BigDecimal valueBigdecimal = BigDecimal.valueOf(value);
    return valueBigdecimal.round(new MathContext(PRECISION));
  }
}
