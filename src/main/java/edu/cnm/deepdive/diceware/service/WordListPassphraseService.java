package edu.cnm.deepdive.diceware.service;

import edu.cnm.deepdive.diceware.WordListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
 class WordListPassphraseService implements PassphraseService {

  private final WordListRepository repository;


  @Autowired
  WordListPassphraseService(WordListRepository repository) {
    this.repository = repository;
  }

  @Override
  public String[] generate(int length) {
    String[] words = new String[length];
    for (int i = 0; i < words.length; i++){
      words[i] = repository.getRandom();
    }
    return words;
  }

}
