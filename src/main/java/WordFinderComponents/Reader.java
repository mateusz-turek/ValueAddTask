package WordFinderComponents;

import java.io.*;

public class Reader {

    private String fileAddress;

    private BufferedReader stream;

    private static final Reader READER = new Reader();

    private Reader() {
        if (READER != null) {
            throw new IllegalStateException("WordFinderComponents.Reader already exist");
        }
    }

    public static Reader getInstance() {
        return READER;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setStream() {
        try {
            this.stream = new BufferedReader(new InputStreamReader(
                    new FileInputStream(getInstance().getFileAddress()), "Cp1250"));
        } catch (FileNotFoundException | UnsupportedEncodingException exception) {
            exception.printStackTrace();
        }
    }

    public void closeStream() {
        try {
            this.stream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public String readLine() {
        String line = "";
        try {
            line = this.stream.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return line;
    }
}
