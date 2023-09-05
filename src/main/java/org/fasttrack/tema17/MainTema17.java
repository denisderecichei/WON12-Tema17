package org.fasttrack.tema17;

import java.util.Arrays;
import java.util.List;

public class MainTema17 {

    public static void main(String[] args) {
        Person p1 = new Person("Abra", "cadabra", 30, "Oradea");
        Person p2 = new Person("Ala", "bala", 13, "Cluj");
        Person p3 = new Person("Tenis", "Baschet", 70, "Cluj");
        List<Person> personList = Arrays.asList(p1, p2, p3);
        PersonService service = new PersonService(personList);
        System.out.println(service.getAllFullnames());
        System.out.println(service.getAdults());
        service.getAllFromCities("Oradea");
        service.getAllFromCities("Oradea", "Cluj");
        service.getAllFromCities("Oradea", "Cluj", "Bucuresti");
        service.getAllFromCities("Oradea", "Cluj", "Bucuresti", "Iasi");

    }
}
