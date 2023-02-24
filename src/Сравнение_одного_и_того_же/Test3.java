package Сравнение_одного_и_того_же;
//Записи его с помощью функционального интерфейса и создания анонимного класса:

import java.util.function.Consumer;
import java.util.function.Function;

public class Test3 {
    public static void main(String[] args) {

        // Создаем объект someObj из интерфейса SomeInterface
        SomeInterface someObj = new SomeInterface() {
            @Override
            public int num(int a) {
                // Переопределяем метод,
                // добавляем операцию сложения с единицей
                return a + 1;
            }
        };

        //Выводим результат в консоль
        System.out.println(someObj.num(5));
    }

// Создаем функциональный интерфейс
@FunctionalInterface
interface SomeInterface {
    // Добавляем метод num
    public int num(int a);
}
}
