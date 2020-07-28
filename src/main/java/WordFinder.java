import WordFinderComponents.LineReader;
import WordFinderComponents.Reader;
import WordFinderComponents.WordOccurrence;

import java.util.*;

public class WordFinder {

    private final static LineReader LINE_READER = LineReader.getInstance();
    private final static Reader READER = Reader.getInstance();
    private List<WordOccurrence> wordOccurrenceList;

    public WordFinder() {
        this.wordOccurrenceList = new ArrayList<>();
    }

    public void sortWordOccurrenceList() {
        wordOccurrenceList.sort(WordOccurrence.comparator);
    }

    public void addWord(String word) {
        WordOccurrence wordOccurrence = new WordOccurrence();
        wordOccurrence.addWord(word);
        wordOccurrenceList.add(wordOccurrence);
    }

    public boolean checkWordOccurrence(String word) {
        for (WordOccurrence presence : wordOccurrenceList) {
            if (presence.checkWord(word)) {
                return false;
            }
        }
        return true;
    }

    public void changeWordData(String word, int line) {
        for (WordOccurrence presence : wordOccurrenceList) {
            if (presence.checkWord(word)) {
                presence.addLineWhereWordOccurred(word, line);
                presence.increaseWordDataNumberOfOccurrences(word);
            }
        }
    }

    public static LineReader getLineReader() {
        return LINE_READER;
    }

    public static Reader getREADER() {
        return READER;
    }

    public void removeAllRecords() {
        wordOccurrenceList.clear();
    }

    @Override
    public String toString() {
        return "WordFinder { \n" + wordOccurrenceList + '}';
    }
}
