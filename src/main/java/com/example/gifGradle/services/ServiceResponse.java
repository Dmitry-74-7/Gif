package com.example.gifGradle.services;


import com.example.gifGradle.enums.Currency;
import com.example.gifGradle.interfaces.ForeignСurrency;
import com.example.gifGradle.interfaces.GifInterface;
import com.example.gifGradle.response.ResponseCurrency;
import com.example.gifGradle.response.gif.ResponseGif;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceResponse {

    @Value("${user.id.access}")
    private String id;

    @Value("${user.gif.key}")
    private String key;

    private final ForeignСurrency foreign;
    private final GifInterface gifInterface;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    public ServiceResponse(ForeignСurrency foreign,
        GifInterface gifInterface) {
      this.foreign = foreign;
      this.gifInterface = gifInterface;
    }

    public String getStatusGif(Currency currency) {

      boolean flag = getCurrentValueOfRub(currency) > getCurrentValueOfRubMinusDay(currency);
      return getGif(flag);

    }


    public Double getCurrentValueOfRub(Currency currency) {

      ResponseCurrency now = foreign.getList(id, currency.toString());
      return now.getRates().get("RUB");
    }


    public Double getCurrentValueOfRubMinusDay(Currency currency) {

      LocalDateTime currentDateMinusDay = LocalDateTime.now().minusDays(1);
      String dateMinusDay = currentDateMinusDay.format(formatter);

      ResponseCurrency now = foreign.getListHistorical(dateMinusDay ,id, currency.toString());
      return now.getRates().get("RUB");
    }


    public String getGif(Boolean flag) {

      if (flag) {
        ResponseGif gif = gifInterface.getGif(key,"rich");
        return gif.getData().getImages().getOriginal().getUrl();
      }

      ResponseGif gif = gifInterface.getGif(key,"broke");
        return gif.getData().getImages().getOriginal().getUrl();
    }



}
