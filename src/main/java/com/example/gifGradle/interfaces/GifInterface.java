package com.example.gifGradle.interfaces;


import com.example.gifGradle.response.gif.ResponseGif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gif", url = "api.giphy.com/v1/gifs/")
public interface GifInterface {

  @GetMapping("/random")
  public ResponseGif getGif(@RequestParam("api_key") String apiKey,
      @RequestParam("tag") String tag);

}
