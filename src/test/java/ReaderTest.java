import WordFinderComponents.Reader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class ReaderTest {

    private Reader reader = Reader.getInstance();

    @Test
    public void createReaderInstanceTest() {
        System.out.println(reader);
        Assert.assertNotNull(reader);
        Reader reader1 = Reader.getInstance();
        Reader reader2 = Reader.getInstance();
        Assert.assertEquals(reader1,reader2);
    }

    @Test
    public void setAndGetFileAddress() {
        File resourcesDirectory = new File("src/main/resources/zadanie.txt");
        String directory = resourcesDirectory.getAbsolutePath();
        reader.setFileAddress(directory);
        Assert.assertNotNull(reader.getFileAddress());
    }

    @Test
    public void readLine() {
        File resourcesDirectory = new File("src/main/resources/zadanie.txt");
        String directory = resourcesDirectory.getAbsolutePath();
        reader.setFileAddress(directory);
        reader.setStream();
        String line = reader.readLine();
        Assert.assertNotNull(line);
    }


}