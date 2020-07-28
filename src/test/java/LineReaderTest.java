import WordFinderComponents.LineReader;
import org.junit.Assert;
import org.junit.Test;

public class LineReaderTest {

    @Test
    public void getInstance() {
        LineReader lineReader = LineReader.getInstance();
        System.out.println(lineReader);
        LineReader lineReader1 = LineReader.getInstance();
        Assert.assertNotNull(lineReader);
        Assert.assertNotNull(lineReader1);
        Assert.assertSame(lineReader, lineReader1);
        System.out.println(lineReader == lineReader1);
    }

    @Test
    public void setAndGetLine() {
        StringBuffer sb = new StringBuffer("I have started, my. adventure ..with programming from ");
        LineReader.getInstance().setLine(sb);
        Assert.assertNotNull(LineReader.getInstance().getLine());
        Assert.assertEquals("I have started, my. adventure ..with programming from ",
                LineReader.getInstance().getLine().toString());
    }


    @Test
    public void getSeparators() {
        String separators = LineReader.getInstance().getSeparators();
        Assert.assertNotNull(separators);
        Assert.assertEquals(":.,/- ()\"",separators);
        Assert.assertEquals(":.,/- ()\"", LineReader.getInstance().getSeparators());
    }

    @Test
    public void setAndGetWordReader() {
        StringBuffer sb = new StringBuffer("I have started, my. adventure ..with programming from ");
        LineReader.getInstance().setLine(sb);

        LineReader.getInstance().setWordReader(
                LineReader.getInstance().getLine(),
                LineReader.getInstance().getSeparators());

        Assert.assertNotNull(LineReader.getInstance().getWordReader());
    }


    @Test
    public void readWord() {
        StringBuffer sb = new StringBuffer("I have started, my. adventure ..with programming from ");
        LineReader.getInstance().setLine(sb);

        LineReader.getInstance().setWordReader(
                LineReader.getInstance().getLine(),
                LineReader.getInstance().getSeparators());
        String word = LineReader.getInstance().readWord();
        Assert.assertNotNull(word);
        Assert.assertEquals("have", LineReader.getInstance().readWord());
        Assert.assertEquals("started", LineReader.getInstance().readWord());
        Assert.assertEquals("my", LineReader.getInstance().readWord());
        Assert.assertEquals("adventure", LineReader.getInstance().readWord());
        Assert.assertEquals("with", LineReader.getInstance().readWord());
    }


    @Test
    public void hasMoreWords() {
        StringBuffer sb = new StringBuffer("I have started, my. adventure ..with programming from ");
        LineReader.getInstance().setLine(sb);

        LineReader.getInstance().setWordReader(
                LineReader.getInstance().getLine(),
                LineReader.getInstance().getSeparators());

        Assert.assertTrue(LineReader.getInstance().hasMoreWords());

        StringBuffer sb2 = new StringBuffer("");
        LineReader.getInstance().setLine(sb2);
        LineReader.getInstance().setWordReader(
                LineReader.getInstance().getLine(),
                LineReader.getInstance().getSeparators());
        Assert.assertFalse(LineReader.getInstance().hasMoreWords());

    }
}