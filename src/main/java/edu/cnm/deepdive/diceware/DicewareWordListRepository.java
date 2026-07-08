package edu.cnm.deepdive.diceware;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
class DicewareWordListRepository implements WordListRepository {

  private static final Pattern WORD_EXTRACTOR = Pattern.compile("^\\S+\\s+(\\S+)$");
  private final List<String> words;
  private final RandomGenerator rng;

  @Autowired
  DicewareWordListRepository(
     @Value("${diceware.wordlist}") String wordListResource,
      RandomGenerator rng
  ) throws IOException {
    this.rng = rng;
    // TODO: 7/8/26 Read word listResource content and create/populate words.
    Resource resource = new ClassPathResource(wordListResource);
    try (Stream<String> lines = Files.lines(Paths.get(resource.getURI()))) {
      words = lines
          .map(String::strip)
          .filter((line) -> !line.isEmpty())
          .map(WORD_EXTRACTOR::matcher)
          .filter(Matcher::matches)
          .map((matcher) -> matcher.group(1))
          .collect(Collectors.toCollection(ArrayList::new));
    }
  }

  @Override
  public String get(int position) {
    return words.get(position);
  }

  @Override
  public String getRandom() {
    return words.get(rng.nextInt(words.size()));
  }

  @Override
  public int size() {
    return words.size();
  }
}
