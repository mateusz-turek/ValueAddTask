package WordFinderComponents;

import java.util.StringTokenizer;

public class LineReader {

    private StringTokenizer wordReader;

    private final String separators = ":.,/- ()\"";

    private StringBuffer line;

    private static final LineReader LINE_READER = new LineReader();

    private LineReader() {
        if (LINE_READER != null) {
            throw new IllegalStateException("WordFinderComponents.Reader already exist");
        }
    }

    public static LineReader getInstance() {
        return LINE_READER;
    }

    public void setLine(StringBuffer line) {
        this.line = line;
    }

    public StringBuffer getLine() {
        return line;
    }

    public String getSeparators() {
        return separators;
    }

    public void setWordReader(StringBuffer line, String separators) {
        this.wordReader = new StringTokenizer(line.toString(), separators);
    }

    public StringTokenizer getWordReader() {
        return wordReader;
    }

    public String readWord() {
        return LineReader.getInstance().getWordReader().nextToken();
    }

    public boolean hasMoreWords() {
        return LineReader.getInstance().getWordReader().hasMoreTokens();
    }

}
