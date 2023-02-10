import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        task1WithoutLambda();
        task1WithLambda();
        System.out.println();
        task2WithoutLambda();
        task2WithLambda();
        System.out.println();
        task3WithoutLambda();
        task3WithLambda();
        System.out.println();
        task4WithoutLambda();
        task4WithLambda();
        System.out.println();
        task5();

    }

    public static void task1WithoutLambda() {
        System.out.print("Введите целое число: ");
        Predicate<Integer> isNumberPositive = new Predicate<>() {
            @Override
            public boolean test(Integer number) {
                return number >= 0;
            }
        };
        System.out.println(isNumberPositive.test(Integer.valueOf(in.nextLine())));
    }

    public static void task1WithLambda() {
        System.out.print("Введите целое число: ");
        Predicate<Integer> isNumberPositive = number -> number >= 0;
        System.out.println(isNumberPositive.test(Integer.valueOf(in.nextLine())));
    }

    public static void task2WithoutLambda() {
        System.out.print("Введите имя: ");
        Consumer<String> greeting = new Consumer<>() {
            @Override
            public void accept(String name) {
                System.out.println("Привет, " + name + "!");
            }
        };
        greeting.accept(in.nextLine());
    }

    public static void task2WithLambda() {
        System.out.print("Введите имя: ");
        Consumer<String> greeting = name -> System.out.println("Привет, " + name + "!");
        greeting.accept(in.nextLine());
    }

    public static void task3WithoutLambda() {
        double number = 123.456d;
        Function<Double, Long> doubleToLong = new Function<>() {
            @Override
            public Long apply(Double numberDouble) {
                return (long) Math.round(numberDouble);
            }
        };
        System.out.println(doubleToLong.apply(number));
    }

    public static void task3WithLambda() {
        double number = 123.456d;
        Function<Double, Long> doubleToLong = numberDouble -> (long) Math.round(numberDouble);
        System.out.println(doubleToLong.apply(number));
    }

    public static void task4WithoutLambda() {
        Supplier<Integer> getNumber = new Supplier<>() {
            @Override
            public Integer get() {
                return (new Random()).nextInt(101);
            }
        };
        System.out.println(getNumber.get());
    }

    public static void task4WithLambda() {
        Supplier<Integer> getNumber = () -> (new Random()).nextInt(101);
        System.out.println(getNumber.get());
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static void task5() {
        System.out.print("Введите произвольную строку для вычисления её длины: ");
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> stringLength = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(stringLength.apply(in.nextLine()));
    }
}