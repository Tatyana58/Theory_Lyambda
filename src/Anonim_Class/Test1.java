package Anonim_Class;

public class Test1 {
    public static void main(String[] args) {

        TestInter testInter = new TestInter() {
            @Override
            public void test() {
                System.out.println("реализация метода test() через Анонимный класс ");
            }
        };

        testInter.test();
    }
}

interface TestInter {
    void test();
}

