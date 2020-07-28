package WordFinderComponents;

import WordFinderComponents.WordOccurrenceComponents.WordData;

import java.util.*;

public class WordOccurrence {

    private HashMap<String, WordData> wordOccurrence;

    public WordOccurrence() {
        this.wordOccurrence = new HashMap<>();
    }

    public static Comparator<WordOccurrence> comparator = (o1, o2) -> {
        int value = o1.toString().toLowerCase().compareTo(o2.toString().toLowerCase());
        if (value == 0) {
            value = o2.toString().toLowerCase().compareTo(o1.toString().toLowerCase());
        }
        return value;
    };

    public void addWord(String word) {
        wordOccurrence.put(word, new WordData());
    }

    public boolean checkWord(String word) {
        return wordOccurrence.containsKey(word);
    }


    public Integer getWordOccurrenceForParticularWord(String word) {
        // StringBuilder wordOccurrences = new StringBuilder("");
        // wordOccurrences.append("For").append(word).append(" ");

        if (wordOccurrence.containsKey(word)) {
            return wordOccurrence.get(word).getNumberOfOccurrences();
        }
        return null;
        //return wordOccurrences.toString();
    }

    public void increaseWordDataNumberOfOccurrences(String word) {
        if (wordOccurrence.containsKey(word)) {
            wordOccurrence.get(word).incrementOccurrences();
        }
    }

    public void addLineWhereWordOccurred(String word, int line) {
        if (wordOccurrence.containsKey(word)) {
            wordOccurrence.get(word).addLineToOccurrences(line);
        }
    }

    public List<Integer> getLinesWhereWordOccurred(String word) {
        if (wordOccurrence.containsKey(word)) {
            return wordOccurrence.get(word).getLinesWhereWordOccurred();
        }
        return null;
    }

    @Override
    public String toString() {
        return wordOccurrence + "\n";
    }
}
