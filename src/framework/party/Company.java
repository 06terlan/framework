package framework.party;

import java.util.List;

public class Company extends Party implements IOrganization {

    private List<Person> employees;

    public Company(String name, String street, String city, String state, int zip, String email) {
        super(name, street, city, state, zip, email);
    }

    public void hirePerson(Person person) {
        employees.add(person);
    }

    public void firePerson(Person person) {
        employees.remove(person);
    }

    public int employeesNumber() {
        return employees.size();
    }

}
