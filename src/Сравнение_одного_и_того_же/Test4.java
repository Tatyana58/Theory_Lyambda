package Сравнение_одного_и_того_же;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

//Использования лямбда-выражения:
public class Test4 {
    public static void main(String[] args) {

        // Пишем лямбда-выражение,
        // где someObj ссылается на интерфейс SomeInterface,
        // а в качестве параметра принимается 'а'.
        // Тип int указывать не нужно — он уже указан в интерфейсе.
        // В теле метода мы переопределяем его,
        // возвращая прибавления единицы ко входному числу.
        SomeInterface someObj = (a -> a+1);
        System.out.println(someObj.num(5));
//Ссылка на нестатический метод любого объекта конкретного типа
        Consumer<String> consumer = str -> System.out.println(str);
        Function<String, String> function = s -> s.toLowerCase();
        System.out.println(function.apply("JAVA 8"));
//перепишем
        Function<String, String> function1 = String::toLowerCase;
        System.out.println(function1.apply("JAVA 8"));
//Ссылка на нестатический метод конкретного объекта
        Integer integer = 5;
        Supplier<String> supplier = integer::toString;
        System.out.println(supplier.get());
//Ссылка на статический метод
        Function<String, Boolean> function2 = e -> Boolean.valueOf(e);
        System.out.println(function2.apply("TRUE"));

        //Перепишем с помощью ссылки:

        Function<String, Boolean> function3 = Boolean::valueOf;
        System.out.println(function3.apply("TRUE"));

//Ссылка на конструктор
        Function<String, Integer> function4 = (d) -> new Integer(d);
        System.out.println(function4.apply("4"));

        //Перепишем:

        Function<String, Integer> function5 = Integer::new;
        System.out.println(function5.apply("4"));


    }


// Создаем функциональный интерфейс
@FunctionalInterface
interface SomeInterface {
    // Добавляем метод num
    public int num(int a);
}
}
