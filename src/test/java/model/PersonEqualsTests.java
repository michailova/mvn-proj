package model;

import model.itstep.Cat;
import model.itstep.Person;

public class PersonEqualsTests {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("John");
        p.setLastName("Johnson");
        p.setAge(55);
        p.setId(100);

        Person p2 = new Person(100, "John", "Johnson", 55);

        System.out.println("p == p2? " + (p == p2)); //объекты никогда не равны


        Person p100 = p;
        System.out.println("p100 == p? " + (p100 == p));

        // II equals. по умолчанию проверяет ссылки, т.е. смотрите пункт 1

        Cat cat1 = new Cat("Murzik");
        Cat cat2 = new Cat("Murzik");
        Person person1 = new Person(123, "Mike", "Tyson", 56);
        person1.setCat(cat1);
        Person person2 = new Person(123, "Mike", "Tyson", 56);
        person2.setCat(cat2);

        // для корректного сравнения объектов необходимо переопределить метод сравнения equals, как правило объекты
        // сравниваются по полям
        //System.out.println("person1 == person2 ?" + person1.equals(person2));


        // hash code - функция которая вернет целое число

        System.out.println("person1 hashcode - " + person1.hashCode());
        System.out.println("person2 hashcode - " + person2.hashCode());
        System.out.println("cat1 hashcode - " + cat1.hashCode());
        System.out.println("cat2 hashcode - " + cat2.hashCode());

        // если hash коды равны это не значит, что входные объекты равны (т.к. hashcode ограничен int) искуственно
        // это переопределенный hash код, который всегда для всех объектов возвращает например 1
        // если hash коды разные это всегда значит, что объекты разные
    }
}
