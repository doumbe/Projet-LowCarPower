package com.mycompagny.lowcarbpower.lowcarpower.model;

public class Price {

  private String price;

  public Price() {
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return price;
  }
}
