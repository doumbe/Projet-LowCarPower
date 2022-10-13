package com.mycompanylowcarpower.lowcarbpricemock.service;

import java.math.BigDecimal;

import com.mycompanylowcarpower.lowcarbpricemock.service.bo.MomentPrice;

public interface IPriceEnergyService {

  public MomentPrice getPrice();

 // public BigDecimal getDisplayInvoice(BigDecimal nbKwh);

  //public BigDecimal getQuoting(BigDecimal nbKwh);
}
