package edu.cnm.deepdive.diceware.controller;

import edu.cnm.deepdive.diceware.service.PassphraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passphrases")
public class PassphraseController {

  private final PassphraseService service;

  @Autowired
  public PassphraseController(PassphraseService service) {
    this.service = service;
  }

  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public String[] get(@RequestParam(required = false, defaultValue = "5") int length) {
    return service.generate(length);
  }

}
