package com.example.gifGradle.interfaces;


import com.example.gifGradle.response.ResponseCurrency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "foreign", url = "https://openexchangerates.org/")
public interface ForeignСurrency {


  @GetMapping("/api/latest.json")
  ResponseCurrency getList(@RequestParam("app_id") String id,
                  @RequestParam("base") String base);

  @GetMapping("/api/historical/{date}.json")
  ResponseCurrency getListHistorical(@PathVariable("date") String date,
                              @RequestParam("app_id") String id,
                              @RequestParam("base") String base);


}
