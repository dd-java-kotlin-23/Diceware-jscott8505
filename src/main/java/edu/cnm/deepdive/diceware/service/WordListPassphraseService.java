package edu.cnm.deepdive.diceware.service;

import edu.cnm.deepdive.diceware.repository.WordListRepository;
import java.util.function.Supplier;
import java.util.stream.Stream;
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
    return Stream.generate(repository::getRandom)
        .limit(length)
        .toArray(String[]::new);
  }

}
