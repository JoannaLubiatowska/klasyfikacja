package com.company.model.classifier;

import com.company.model.problem.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class GroupStats {

    private final int debtorsNo;
    private final Map<Gender, Double> genderPercentMap = new HashMap<>();
    private final Map<Salary, Double> salaryPercentMap = new HashMap<>();
    private final Map<Education, Double> educationPercentMap = new HashMap<>();
    private final Map<TypeOfEmployment, Double> typeOfEmploymentPercentMap = new HashMap<>();
    private final Map<Age, Double> agePercentMap = new HashMap<>();


    public GroupStats(List<Debtor> debtors) {
        debtorsNo = debtors.size();
        calculateFieldStats(debtors, genderPercentMap, Debtor::getGender, Gender.values());
        calculateFieldStats(debtors, salaryPercentMap, Debtor::getSalary, Salary.values());
        calculateFieldStats(debtors, educationPercentMap, Debtor::getEducation, Education.values());
        calculateFieldStats(debtors, typeOfEmploymentPercentMap, Debtor::getTypeOfEmployment, TypeOfEmployment.values());
        calculateFieldStats(debtors, agePercentMap, Debtor::getAge, Age.values());
    }

    private <T> void calculateFieldStats(List<Debtor> debtors, Map<T, Double> percentMap, Function<Debtor, T> fieldValue, T[] enumValues) {
        for (T enumValue : enumValues) {
            double partOf = debtors.stream().filter(debtor -> fieldValue.apply(debtor).equals(enumValue)).count() / (double) debtorsNo;
            percentMap.put(enumValue, partOf);
        }
    }

    public double calculateProximityFactor(Debtor debtor) {
        Double genderPercent = genderPercentMap.get(debtor.getGender());
        Double salaryPercent = salaryPercentMap.get(debtor.getSalary());
        Double educationPercent = educationPercentMap.get(debtor.getEducation());
        Double typeOfEmploymentPercent = typeOfEmploymentPercentMap.get(debtor.getTypeOfEmployment());
        Double agePercent = agePercentMap.get(debtor.getAge());
        return genderPercent * salaryPercent * educationPercent * typeOfEmploymentPercent * agePercent;
    }

    @Override
    public String toString() {
        return "\nGroupStats{" +
                "\ndebtorsNo=" + debtorsNo +
                ",\ngenderPercentMap=" + genderPercentMap +
                ",\nsalaryPercentMap=" + salaryPercentMap +
                ",\neducationPercentMap=" + educationPercentMap +
                ",\ntypeOfEmploymentPercentMap=" + typeOfEmploymentPercentMap +
                ",\nagePercentMap=" + agePercentMap +
                '}';
    }
}
