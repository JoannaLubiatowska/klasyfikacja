package com.company;

import com.company.model.problem.ClassificationProblem;
import com.company.model.problem.Debtor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static String filePath = "klasyfikacja.txt";

    public static void main(String[] args) throws IOException {
        ClassificationProblem problem = readFromFile(filePath);
        //System.out.println(problem);

        BayesClassifier classifier = new BayesClassifier();
        classifier.configure(problem.getTrainingSet());
        System.out.println(classifier);

        problem.getTestSet().forEach(classifier::classify);
        System.out.println(problem.getTestSet());
    }

    private static ClassificationProblem readFromFile(String path) throws IOException {
        Map<Boolean, List<Debtor>> recordsMap = Files.readAllLines(new File(path).toPath(), Charset.defaultCharset())
                .stream()
                .filter(s -> !s.isEmpty())
                .map(record -> record.split(" "))
                .map(Debtor::new)
                .collect(Collectors.groupingBy(debtor -> Objects.isNull(debtor.getLoanWasRepaid())));

        return new ClassificationProblem(new HashSet<>(recordsMap.get(false)), new HashSet<>(recordsMap.get(true)));
    }
}
