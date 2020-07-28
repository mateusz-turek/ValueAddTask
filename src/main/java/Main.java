import java.io.File;

public class Main {

    public static void main(String[] args) {

        String path = "C:\\Users\\Mateusz\\Desktop\\zadanie.txt";
        ThreadManager threadManager = new ThreadManager();

        try {
            threadManager.runWithStringAsMethodParameter(path);
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        } finally {
            System.out.println("==========================================================");
            File resourcesDirectory = new File("src/main/resources/zadanie.txt");
            threadManager.runWithStringAsMethodParameter(resourcesDirectory.getAbsolutePath());
        }

        //threadManager.runWithTypingPathInConsole();
    }
}
