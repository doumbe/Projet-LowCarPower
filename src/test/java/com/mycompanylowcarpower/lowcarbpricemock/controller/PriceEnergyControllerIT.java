package com.mycompanylowcarpower.lowcarbpricemock.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class PriceEnergyControllerIT {

  private static final String PATH = "/api";

  @Autowired
  private MockMvc mockMvc;

  /**
   * @throws Exception
   */
  @Test
  void testGetAllLowCarPrice() throws Exception {
    mockMvc.perform(
        get(PATH + "/lowcarprice/")
    ).andExpect(status().isOk());
  }

}
