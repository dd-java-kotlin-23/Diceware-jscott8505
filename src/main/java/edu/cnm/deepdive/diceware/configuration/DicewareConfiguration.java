package edu.cnm.deepdive.diceware.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@SuppressWarnings("JavadocDeclaration")
@Component
@ConfigurationProperties(prefix = "diceware")
public class DicewareConfiguration {

  private String wordList;

  /**
   * Returns the path (relative to the classpath) of the word list-file used for passphrase
   * generation.
   *
   * @return
   */
  public String getWordList() {
    return wordList;
  }

  /**
   * Sets the path (relative to the classpath) of the word list-file used for passphrase generation.
   *
   * @param wordList
   */
  public void setWordList(String wordList) {
    this.wordList = wordList;
  }

}
