package Interface;

public class Main {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.test();
    }
}
    interface TestInter {
    void test();
    }
    class TestClass implements TestInter {
    @Override
    public void test() {
        System.out.println("реализация метода test() через интерфейс ");
    }
}


