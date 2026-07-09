package edu.cnm.deepdive.diceware.controller;

import edu.cnm.deepdive.diceware.service.PassphraseService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/passphrases")
 class PassphraseController {

  private final PassphraseService service;

  @Autowired
   PassphraseController(PassphraseService service) {
    this.service = service;
  }

  @ResponseBody
  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public String[] get(
      @RequestParam(required = false, defaultValue = "5")
          @Min(0)
          @Max(20)
      int length
  ) {
    return service.generate(length);
  }

  @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
  public String get(
      @RequestParam(required = false, defaultValue = "5")
          @Min(0)
          @Max(20)
      int length,
      Model model
  ) {
   model.addAttribute("words", service.generate(length));
   model.addAttribute("length", length);
   return "list";
  }

}
