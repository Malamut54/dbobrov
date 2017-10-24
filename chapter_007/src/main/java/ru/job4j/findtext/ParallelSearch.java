package ru.job4j.findtext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 23.10.2017
 */

public class ParallelSearch {

    private List<String> resultFiles;
    private List<String> intermediate = new ArrayList<>();

    public void searchText(String rootDir, String text, List<String> ext) throws IOException {

        Thread findFiles = new Thread(new FindFiles(rootDir, ext));
        findFiles.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class FindFiles implements Runnable {
        String rootDir;
        List<String> ext;

        public FindFiles(String rootDir, List<String> ext) {
            this.rootDir = rootDir;
            this.ext = ext;
        }

        @Override
        public void run() {
            getFiles(rootDir, ext);
        }

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
                            intermediate.add(file.toString());
                        }
                    }
                } else {
                    getFiles(rootDir + File.separator + directoryList[i], ext);
                }
            }
            System.out.println(intermediate);
        }
    }
}
