package edu.cnm.deepdive.diceware;

public interface WordListRepository {

  String get(int position);

  String getRandom();

  int size();

}
