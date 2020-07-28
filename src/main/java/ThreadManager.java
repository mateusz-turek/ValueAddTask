import WordFinderComponents.LineReader;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {

    private static final WordFinder WORD_FINDER;

    static {
        WORD_FINDER = new WordFinder();
    }

    private static void findWords(String path) {
        int line = 0;
        WordFinder.getREADER().setFileAddress(path);

        WordFinder.getREADER().setStream();
        String sb;
        while ((sb = WordFinder.getREADER().readLine()) != null) {
            line++;
            WordFinder.getLineReader().setLine(new StringBuffer(sb));

            WordFinder.getLineReader().setWordReader(
                    LineReader.getInstance().getLine(),
                    LineReader.getInstance().getSeparators());

            while (WordFinder.getLineReader().hasMoreWords()) {
                String currentWord = WordFinder.getLineReader().readWord();
                if (WORD_FINDER.checkWordOccurrence(currentWord)) {
                    WORD_FINDER.addWord(currentWord);
                    WORD_FINDER.changeWordData(currentWord, line);
                } else {
                    WORD_FINDER.changeWordData(currentWord, line);
                }
            }
        }
        WordFinder.getREADER().closeStream();
        WORD_FINDER.sortWordOccurrenceList();
        System.out.println(WORD_FINDER.toString());
        WORD_FINDER.removeAllRecords();


    }

    public void runWithStringAsMethodParameter(String path) {
        findWords(path);
    }

    public void runWithTypingPathInConsole() {

        Thread findWordsByTypingPath = new Thread(() -> {
            System.out.println("type path to txt file \n");
            Scanner sc = new Scanner(System.in);

            int line = 0;
            WordFinder.getREADER().setFileAddress(sc.nextLine());
            WordFinder.getREADER().setStream();
            String sb;
            while ((sb = WordFinder.getREADER().readLine()) != null) {
                line++;
                WordFinder.getLineReader().setLine(new StringBuffer(sb));

                WordFinder.getLineReader().setWordReader(
                        LineReader.getInstance().getLine(),
                        LineReader.getInstance().getSeparators());

                while (WordFinder.getLineReader().hasMoreWords()) {
                    String currentWord = WordFinder.getLineReader().readWord();
                    if (WORD_FINDER.checkWordOccurrence(currentWord)) {
                        WORD_FINDER.addWord(currentWord);
                        WORD_FINDER.changeWordData(currentWord, line);
                    } else {
                        WORD_FINDER.changeWordData(currentWord, line);
                    }
                }
            }
            WordFinder.getREADER().closeStream();
            sc.close();
            System.out.println(WORD_FINDER.toString());
            WORD_FINDER.removeAllRecords();
        });
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(findWordsByTypingPath);
        executorService.shutdown();
    }
}
