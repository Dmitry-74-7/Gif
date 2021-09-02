package com.example.gifGradle.response;

import java.util.Map;
import lombok.Data;

@Data
public class ResponseCurrency {
  String disclaimer;
  String license;
  String timestamp;
  String base;
  Map<String, Double> rates;



}
