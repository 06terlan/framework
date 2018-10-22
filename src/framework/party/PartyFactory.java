package framework.party;

import java.time.LocalDate;

public class PartyFactory {

    public static Company createCompany(String name, String street, String city, String state, int zip, String email) {
        return new Company(name, street, city, state, zip, email);
    }

    public static Person createPerson(String name, String street, String city, String state, int zip, String email, LocalDate birthDay) {
        return new Person(name, street, city, state, zip, email, birthDay);
    }

}
