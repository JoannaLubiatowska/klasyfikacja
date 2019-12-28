package com.company.model.problem;

import java.util.Set;

public class ClassificationProblem {

    private Set<Debtor> trainingSet;
    private Set<Debtor> testSet;

    public ClassificationProblem(Set<Debtor> trainingSet, Set<Debtor> testSet) {
        this.trainingSet = trainingSet;
        this.testSet = testSet;
    }

    public Set<Debtor> getTrainingSet() {
        return trainingSet;
    }

    public Set<Debtor> getTestSet() {
        return testSet;
    }

    @Override
    public String toString() {
        return "Classification{" +
                "trainingSet=" + trainingSet +
                ",\n testSet=" + testSet +
                '}';
    }
}
