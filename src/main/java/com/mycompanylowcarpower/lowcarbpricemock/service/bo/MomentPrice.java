package com.mycompanylowcarpower.lowcarbpricemock.service.bo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MomentPrice {

  private BigDecimal price;
  private LocalDate date;

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "MomentPrice{" +
        "price=" + price +
        ", date=" + date +
        '}';
  }

}
