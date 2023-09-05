package org.fasttrack.tema17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonService {
    private List<Person> persons;

    public PersonService(List<Person> persons) {
        this.persons = persons;
    }

    public List<String> getAllFullnames() {
        return persons.stream()
                .map(pers -> pers.getFirstName() + " " + pers.getLastName())
                .collect(Collectors.toList());
    }

    public List<Person> getAdults() {
        return persons.stream()
                .filter(pers -> pers.getAge() >= 18)
                .collect(Collectors.toList());
    }

    public List<Person> getAllFromCity(String city) {
        return persons.stream()
                .filter(pers -> pers.getCity().equals(city))
                .collect(Collectors.toList());
    }

    public List<Person> getAllFromCities(List<String> cities) {
        return persons.stream()
                .filter(pers -> cities.contains(pers.getCity()))
                .collect(Collectors.toList());
    }

    public List<Person> getAllFromCities(String... cities) {
        List<String> myCities = Arrays.asList(cities);
        return persons.stream()
                .filter(pers -> myCities.contains(pers.getCity()))
                .collect(Collectors.toList());
    }

    public List<String> getFirstNamesCapitalized() {
        return persons.stream()
//                .map(pers -> pers.getFirstName().toUpperCase())
                .map(Person::getFirstName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public List<String> capitalized() {
        return persons.stream()
                .map(pers -> pers.getFirstName() + " " + pers.getLastName().charAt(0) + ".")
                .collect(Collectors.toList());
    }

    public List<Person> getBetweenAges() {
        return persons.stream()
                .filter(pers -> pers.getAge() >= 18 && pers.getAge() < 70)
                .collect(Collectors.toList());
    }

    public List<Person> startsWithA() {
        return persons.stream()
                .filter(pers -> pers.getFirstName().charAt(0) == 'A')
                .collect(Collectors.toList());
    }

    public Set<String> getUniques() {
        return persons.stream()
                .map(Person::getFirstName)
                .collect(Collectors.toSet());
//                .distinct()
//                .collect(Collectors.toList());
    }

    public List<Person> sortFirstName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    public List<Person> sortLastName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());
    }

    public List<Person> sortFirstLastAge() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                                    .thenComparing(Person::getLastName)
                                    .thenComparing(Person::getAge))
                .collect(Collectors.toList());
    }
}
