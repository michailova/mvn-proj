package model.itstep;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Person {

    private int id;
    private String name;
    private String lastName;
    private int age;
    private Cat cat;

    public Person(int i, String mike, String tyson, int i1) {
    }
    //   @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return id == person.id;
//    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return id == person.id && age == person.age && Objects.equals(name, person.name) && Objects.equals(lastName, person.lastName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, lastName, age);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && name.equals(person.name) && lastName.equals(person.lastName)
                && cat.equals(person.cat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, age, cat);
    }
}
