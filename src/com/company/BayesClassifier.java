package com.company;

import com.company.model.classifier.GroupStats;
import com.company.model.problem.Debtor;

import java.util.*;
import java.util.stream.Collectors;

public class BayesClassifier {

    private Map<Boolean, GroupStats> groupStatsMap = new HashMap<>();

    void configure(Collection<Debtor> trainingSet) {
        trainingSet.stream()
                .collect(Collectors.groupingBy(Debtor::getLoanWasRepaid))
                .forEach(this::addGroupStats);
    }

    private void addGroupStats(Boolean group, List<Debtor> debtors) {
        groupStatsMap.put(group, new GroupStats(debtors));
    }

    void classify(Debtor debtor) {
        Boolean group = groupStatsMap.entrySet()
                .stream()
                .map(entry -> Map.entry(entry.getKey(), entry.getValue().calculateProximityFactor(debtor)))
                .max(Comparator.comparingDouble(Map.Entry::getValue)).orElseThrow().getKey();
        debtor.setLoanWasRepaid(group);
    }

    @Override
    public String toString() {
        return "BayesClassifier{" +
                "groupStatsMap=\n" + groupStatsMap +
                "}";
    }
}
