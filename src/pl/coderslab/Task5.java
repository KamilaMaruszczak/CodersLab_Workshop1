package pl.coderslab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Task5 {
    public static void main(String[] args) {
        headersInFile("Interia.txt", "http://www.interia.pl");
        String[] cens = {"Tak", "ryba",};
        filter("Interia.txt", cens);

    }

    public static void headersInFile(String filename, String url) {
        Path path = Paths.get(filename);
        Connection connect = Jsoup.connect(url);
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            ArrayList<String> outList = new ArrayList<>();
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                outList.add(elem.text());
            }
            Files.write(path, outList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void filter(String filename, String[] censored) {
        Path path = Paths.get(filename);
        Path path1 = Paths.get("Filtered " + filename);

        try {
            if (!Files.exists(path1)) {
                Files.createFile(path1);
            }

            ArrayList<String> outList = new ArrayList<>();
            for (String line : Files.readAllLines(path)) {

                StringBuilder sb = new StringBuilder();
                String[] result = line.split(" ");

                for (int i = 0; i < result.length; i++) {
                    String word = result[i].toLowerCase();

                    if (word.length() > 3) {
                        boolean cens = false;

                        for (int j = 0; j < censored.length; j++) {
                            if (word.equalsIgnoreCase(censored[j])) {
                                cens = true;
                                break;
                            }
                        }

                        if (!cens) {
                            sb.append(word);
                            sb.append(" ");
                        }
                    }
                }
                outList.add(sb.toString());
            }
            Files.write(path1, outList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
