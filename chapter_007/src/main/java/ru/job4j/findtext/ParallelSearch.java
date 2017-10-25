package ru.job4j.findtext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Task parallel search.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 23.10.2017
 */

public class ParallelSearch {
    /**
     * List of the output files.
     */
    private List<String> resultFiles = new ArrayList<>();

    /**
     * Search text from directory.
     *
     * @param rootDir Directory for search.
     * @param text    input text for search.
     * @param ext     extensions.
     * @return List of file.
     */
    public List<String> searchText(String rootDir, String text, List<String> ext) {

        Thread findFiles = new Thread(new FindFiles(rootDir, ext, text));
        findFiles.start();
        try {
            findFiles.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultFiles;

    }

    /**
     * Class for find files.
     */
    class FindFiles implements Runnable {
        /**
         * Directory for search.
         */
        private String rootDir;
        /**
         * Text for search.
         */
        private String searchText;
        /**
         * Extensions.
         */
        private List<String> ext;
        /**
         * List of thread. This thread parse file and search input String.
         */
        private List<Thread> threadList = new ArrayList<>();

        /**
         * Constructor.
         *
         * @param rootDir    Directory.
         * @param ext        Extensions.
         * @param searchText Text for search.
         */
        FindFiles(String rootDir, List<String> ext, String searchText) {
            this.rootDir = rootDir;
            this.ext = ext;
            this.searchText = searchText;
        }

        @Override
        public void run() {
            getFiles(rootDir, ext);
            startThread();
        }

        /**
         * Search for files with specified extensions.
         * @param rootDir Directory
         * @param ext List of extensions.
         */
        private void getFiles(String rootDir, List<String> ext) {
            File root = new File(rootDir);
            if (!root.isDirectory()) {
                try {
                    throw new IOException("Directory not found" + root.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String[] directoryList = root.list();
            for (int i = 0; i < directoryList.length; i++) {
                File file = new File(root + File.separator + directoryList[i]);
                if (file.isFile()) {
                    for (int j = 0; j < ext.size(); j++) {
                        if (file.getName().endsWith(ext.get(j))) {
                            threadList.add(new Thread(new FindText(searchText, file.toString())));
                        }
                    }
                } else {
                    getFiles(rootDir + File.separator + directoryList[i], ext);
                }
            }

        }

        /**
         * Start thread which process files.
         */
        private void startThread() {
            for (Thread thread : threadList) {
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * Class for parsing files and search input String.
     */
    class FindText implements Runnable {
        /**
         * Text for search.
         */
        private String searchText;
        /**
         * Path to a file.
         */
        private String inputPath;
        /**
         * All text in file to one String.
         */
        private String stringAllText;

        /**
         * Constructor.
         *
         * @param searchText Text for search.
         * @param inputPath  Path to a file.
         */
        FindText(String searchText, String inputPath) {
            this.searchText = searchText;
            this.inputPath = inputPath;
        }

        @Override
        public void run() {
            try {
                stringAllText = new String(Files.readAllBytes(Paths.get(inputPath)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] tmp = stringAllText.split("[ #=,;:.!?\"+\\n\\t]");
            for (String s : tmp) {
                if (searchText.equals(s)) {
                    resultFiles.add(inputPath);
                    break;
                }
            }
        }

    }
}
