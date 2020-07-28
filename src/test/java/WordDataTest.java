import WordFinderComponents.WordOccurrenceComponents.WordData;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WordDataTest {

    @Test
    public void createInstanceAndAddLinesOfWordData(){
        WordData wordData1 = new WordData();
        System.out.println(wordData1.getLinesWhereWordOccurred());
        Assert.assertNotNull(wordData1.getLinesWhereWordOccurred());
    }


    @Test
    public void incrementOccurrences() {
        WordData wordData = new WordData();
        System.out.println(wordData.getNumberOfOccurrences());
        assertEquals(0, wordData.getNumberOfOccurrences());
        wordData.incrementOccurrences();
        assertEquals(1, wordData.getNumberOfOccurrences());
        System.out.println(wordData.getNumberOfOccurrences());

    }

    @Test
    public void addLineToOccurrences() {
        WordData wordData = new WordData();

        wordData.addLineToOccurrences(1);
        wordData.addLineToOccurrences(2);
        wordData.addLineToOccurrences(4);

        Assert.assertNotNull(wordData.getLinesWhereWordOccurred());
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(4);

        Assert.assertEquals(integerArrayList,wordData.getLinesWhereWordOccurred());
    }
}