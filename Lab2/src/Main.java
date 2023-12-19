import java.util.ArrayList;
import java.util.List;

import java.util.HashSet;
import java.util.Set;

import java.util.HashMap;
import java.util.Map;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    // 3. Функциональные интерфейсы
    // Пример 1: Лямбда-выражение для сложения
    interface MathOperation {
        int operate(int a, int b);
    }

    private static int operate(int a, int b, MathOperation operation) {
        return operation.operate(a, b);
    }

    // Пример 5: Интерфейс с одним абстрактным методом для вывода строки
    interface Printer {
        void print(String message);
    }

    public static void main(String[] args)  {

        // 1. Коллекции

        // Создание списка
        List<String> myList = new ArrayList<>();

        // Добавление элементов
        myList.add("Элемент 1");
        myList.add("Элемент 2");
        myList.add("Элемент 3");

        // Вывод элементов
        for (String element : myList) {
            System.out.println(element);
        }

        System.out.println();

        // Создание множества
        Set<Integer> mySet = new HashSet<>();

        // Добавление элементов
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(2); // Дубликаты не допускаются

        // Вывод элементов
        for (Integer element : mySet) {
            System.out.println(element);
        }

        System.out.println();

        // Создание отображения
        Map<String, Integer> myMap = new HashMap<>();

        // Добавление пар ключ-значение
        myMap.put("Ключ 1", 10);
        myMap.put("Ключ 2", 20);
        myMap.put("Ключ 3", 30);

        // Получение значения по ключу
        int value = myMap.get("Ключ 2");
        System.out.println("Значение для Ключа 2: " + value);

        // Вывод всех пар ключ-значение
        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();

        // 2. Лямбда-выражения

        // Пример 1: Лямбда-выражение для сложения
        MathOperation addition = (a, b) -> a + b;
        System.out.println("Результат сложения: " + operate(10, 5, addition));

        // Пример 2: Лямбда-выражение для вычитания
        MathOperation subtraction = (a, b) -> a - b;
        System.out.println("Результат вычитания: " + operate(10, 5, subtraction));

        // Пример 3: Лямбда-выражение для умножения
        MathOperation multiplication = (a, b) -> a * b;
        System.out.println("Результат умножения: " + operate(10, 5, multiplication));

        // Пример 4: Лямбда-выражение для деления
        MathOperation division = (a, b) -> a / b;
        System.out.println("Результат деления: " + operate(10, 5, division));

        // Пример 5: Лямбда-выражение для вывода строки
        Printer printer = message -> System.out.println("Сообщение: " + message);
        printer.print("Привет, мир!");

        System.out.println();

        // 5. Stream API
        List<String> strings = Arrays.asList("apple", "orange", "banana", "kiwi");

        List<String> filteredList = strings.stream()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());

        System.out.println(filteredList);  // Вывод: [apple]

        List<String> upperCaseList = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseList);  // Вывод: [APPLE, ORANGE, BANANA, KIWI]

        List<String> sortedList = strings.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedList);  // Вывод: [apple, banana, kiwi, orange]

        System.out.println();

        // 6. Многопоточное программирование в Java 8

        // Пример использования параллельного стрима для обработки коллекции данных
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        // Параллельное выполнение операции фильтрации
        numbers.parallelStream().filter(n -> n % 2 == 0).forEach(System.out::println);

        // Пример использования лямбда-выражения и интерфейса Runnable
        Runnable myRunnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Пример использования лямбда-выражения и интерфейса Runnable с анонимным классом
        Runnable myRunnable2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 2: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // Создание и запуск потока
        Thread thread1 = new Thread(myRunnable);
        thread1.start();

        // Создание и запуск второго потока
        Thread thread2 = new Thread(myRunnable2);
        thread2.start();
    }
}