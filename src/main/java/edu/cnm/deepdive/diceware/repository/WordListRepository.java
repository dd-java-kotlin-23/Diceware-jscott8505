package edu.cnm.deepdive.diceware.repository;

public interface WordListRepository {

  String get(int position);

  String getRandom();

  int size();

}
