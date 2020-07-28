import WordFinderComponents.WordOccurrence;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WordOccurrenceTest {

    @Test
    public void addWord() {
        WordOccurrence wordOccurrence = new WordOccurrence();
        WordOccurrence wordOccurrence1 = new WordOccurrence();
        wordOccurrence.addWord("Sample Word1");
        System.out.println(wordOccurrence);
        System.out.println(wordOccurrence1);
        System.out.println(wordOccurrence.toString());
        Assert.assertNotNull(wordOccurrence);
    }


    @Test
    public void increaseAndGetWordDataNumberOfOccurrences() {
        WordOccurrence wordOccurrence = new WordOccurrence();
        wordOccurrence.addWord("Sample Word1");
        wordOccurrence.increaseWordDataNumberOfOccurrences("Sample Word1");
        assertEquals(1, (int) wordOccurrence.getWordOccurrenceForParticularWord("Sample Word1"));
        wordOccurrence.increaseWordDataNumberOfOccurrences("Sample Word1");
        assertEquals(2, (int) wordOccurrence.getWordOccurrenceForParticularWord("Sample Word1"));
        System.out.println(wordOccurrence.toString());
    }

    @Test
    public void AddAndGetLinesWhereWordOccurred() {
        ArrayList<Integer> arrayList =new ArrayList<>();
        arrayList.add(1);
        WordOccurrence wordOccurrence = new WordOccurrence();
        wordOccurrence.addWord("Sample Word1");
        wordOccurrence.addLineWhereWordOccurred("Sample Word1",1);
        Assert.assertEquals(arrayList,wordOccurrence.getLinesWhereWordOccurred("Sample Word1"));
        System.out.println(wordOccurrence.toString());
        arrayList.add(2);
        wordOccurrence.addLineWhereWordOccurred("Sample Word1", 2);
        Assert.assertEquals(arrayList,wordOccurrence.getLinesWhereWordOccurred("Sample Word1"));
        System.out.println(wordOccurrence.toString());
    }

    @Test
    public void checkWord() {
        WordOccurrence wordOccurrence = new WordOccurrence();
        wordOccurrence.addWord("Sample Word1");
        Assert.assertTrue(wordOccurrence.checkWord("Sample Word1"));
    }
}