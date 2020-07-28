package WordFinderComponents.WordOccurrenceComponents;

import java.util.ArrayList;
import java.util.List;

public class WordData {

    private List<Integer> linesWhereWordOccurred;
    private int numberOfOccurrences;

    public WordData() {
        this.linesWhereWordOccurred = new ArrayList<>();
        this.numberOfOccurrences = 0;
    }

    public List<Integer> getLinesWhereWordOccurred() {
        return linesWhereWordOccurred;
    }

    @Override
    public String toString() {
        return
                "lines Where Word Occurred: " + linesWhereWordOccurred +
                        ", number Of Occurrences: " + numberOfOccurrences;
    }

    public int getNumberOfOccurrences() {
        return numberOfOccurrences;
    }


    public void incrementOccurrences() {
        numberOfOccurrences++;
    }

    public void addLineToOccurrences(int line) {
        linesWhereWordOccurred.add(line);
    }


}
