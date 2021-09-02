package com.example.gifGradle.controllers;


import com.example.gifGradle.entity.ForeignCurrency;
import com.example.gifGradle.enums.Currency;
import com.example.gifGradle.services.ServiceResponse;
import feign.FeignException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

  private final ServiceResponse serviceResponse;

  public MainController(ServiceResponse serviceResponse) {
    this.serviceResponse = serviceResponse;
  }

  @GetMapping("/")
  public String mainPage(Model model) {
    model.addAttribute("foreigncurrency", new ForeignCurrency());

    return "index";
  }

  @PostMapping("/check")
  public String gif(ForeignCurrency currency, Model model) {
    Currency choice = Currency.valueOf(currency.getCurrency());
    String ss = serviceResponse.getStatusGif(choice);
    model.addAttribute("gif", serviceResponse.getStatusGif(choice));
    model.addAttribute("foreigncurrency", currency);
    return "index";

  }

  @ExceptionHandler(IllegalArgumentException.class)
  public String illegalArgument(WebRequest request, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("currencyError", "Ошибка ввода валюты");
    return "redirect:/";
  }

  @ExceptionHandler(FeignException.Forbidden.class)
  public String feignException(WebRequest request, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("accessError", "Нет прав доступа");
    return "redirect:/";
  }

}
