package Laymbda;

import java.util.function.Function;
import java.util.function.Predicate;

public class Test5 {
    static String testStr = "does the rose have flowers?";

    public static void main(String[] args) {

        System.out.println(replacesStrIf(conditionSubStr("flowers"),function).apply(testStr));
    }

    private static Function<String, String> replacesStrIf(
            Predicate<String> condition,
            Function<String, String> function)
    {
        return x -> {
            if (condition.test(x)) {
                return function.apply(x);
            }
            return x;
        };
    }
    private static Predicate<String> conditionSubStr(String subStr) {
        return s -> s.contains(subStr);
    }
    private static Predicate<String> condition = t -> t.startsWith(testStr);
    private static Function<String, String> function = s -> s.replace("flowers","thorns");
}
