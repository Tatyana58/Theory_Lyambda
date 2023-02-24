package Test2;

import java.util.*;
import java.util.function.*;

public class Main3 {
    public static void main(String[] args) {

        // Создаем несколько объектов класса Person
        Person person1 = new Person("Ted", 24);
        Person person2 = new Person("Mike", 9);
        Person person3 = new Person("Sarah", 17);
        Person person4 = new Person("John", 41);
        Person person5 = new Person("Katty", 30);

        // Создаем список
        List<Person> people = new ArrayList<>();

        // Наполняем список объектами
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);

//        // Создаем объект, реализующий функциональный интерфейс Predicate,
//        // и переопределяем его метод test() так, чтобы он возвращал true,
//        // если возраст меньше 18
        Predicate<Person> predicate = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() < 18;
            }
        };


//        // И передаем созданный объект предиката в параметр метода removeIf
//        people.removeIf(predicate);


        people.removeIf(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() < 18;
            }
        });

        // Теперь проверяем результат и видим, что из списка были
        // удалены объекты, возраст которых меньше 18
        for (Person person : people) {
            System.out.println(person);
        }

        // Создаем объект анонимного класса,
        // реализующего функциональный интерфейс Function
        // И сразу переопределяем его метод apply таким образом,
        // чтобы он принимал объект класса Person, а возвращал его возраст
        Function<Person, Integer> function = new Function<Person, Integer>() {
            @Override
            public Integer apply(Person person) {
                return person.getAge();
            }
        };

        // Далее просто передаем вызов переопределенного метода
        // в параметр при проходе списка
        for (Person person : people) {
            System.out.println(function.apply(person));
        }

//В этом случае мы создаем объект анонимного класса в цикле, сразу же переопределяем метод apply и вызываем его.

        for (Person person : people) {
            System.out.println(new Function<Person, Integer>() {
                @Override
                public Integer apply(Person person) {
                    return person.getAge();
                }
            }.apply(person));
        }

        UnaryOperator<Person> unaryOperator = new UnaryOperator<Person>() {
            @Override
            public Person apply(Person person) {
                person.setAge(person.getAge() + 10);
                return person;
            }
        };
        System.out.println("----------Увеличили на 10-----------");
        for (Person person : people) {
            System.out.println(unaryOperator.apply(person));
        }

        //С помощью этой функции мы можем заложить логику сравнения двух объектов в листе
        //Person
        System.out.println("----------Сравнили возраст 1 и 3 -----------");
        BinaryOperator<Person> binaryOperator = new BinaryOperator<Person>() {
            @Override
            public Person apply(Person person, Person person2) {
                if (person.getAge() > person2.getAge()) {
                    return person;
                }
                return person2;
            }
        };

        System.out.println(binaryOperator.apply(person3, person1));
//Простым примером будет программа, которая принимает на входе объект Person и выводит в консоль приветствие с именем.
        System.out.println("----------Приветствие и именем -----------");
        Consumer<Person> consumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("Hi! " + person.getName());
            }
        };

        for (Person person : people) {
            consumer.accept(person);
        }

        //Мы можем получить из списка любой объект
        //Person
        //, у которого возраст меньше 18 лет.
        System.out.println("----------Любой объект возраст которого меньше 60 -----------");
        Supplier<Person> supplier = new Supplier<Person>() {
            @Override
            public Person get() {
                Person personNew = null;
                for (Person person : people) {
                    if (person.getAge() < 60) {
                        personNew = person;
                    }
                }
                return personNew;
            }
        };

        System.out.println(supplier.get());

        System.out.println("----------&&&&& -----------");

        Set<Person> personSet = new TreeSet<>(people);

        for (Person person : personSet) {
            System.out.println(person);
        }
        System.out.println("----------Сортировка  -----------");

        // Вызываем у нашего списка метод sort
        // И в параметр передаем объект Comparator
        people.sort(new PersonSortingByAge());

        for (Person person : people) {
            System.out.println(person);
        }
    }

        // Создаем отдельный класс, в котором будет реализован алгоритм сортировки
// Имплементируем интерфейс Comparator и переопределяем метод compare
        static class PersonSortingByAge implements Comparator<Person> {

            // Реализация абстрактного метода, который определяет порядок сортировки.
            // В данном случае сортировка будет происходить по возрасту
            // от младших к старшим
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getAge() > o2.getAge()) {
                    return 1;
                } else if (o1.getAge() < o2.getAge()) {
                    return -1;
                }
                return 0;
            }
        }

}
