import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;

public class Main {
    
    public static int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо\n");
        }
        return numerator / denominator;
    }

    public static void main(String[] args) {
        // 1. Интерфейсы
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        // Вычисляем и выводим площади фигур
        System.out.println("Площадь круга: " + circle.getArea());
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());

        System.out.println();
        
        // 2. Внутренние классы
        OuterClass outerObj = new OuterClass(42);

        // Создание и использование обычного внутреннего класса
        OuterClass.InnerClass innerObj = outerObj.new InnerClass();
        innerObj.printOuterValue();

        // Создание и использование статического внутреннего класса
        OuterClass.StaticInnerClass staticInnerObj = new OuterClass.StaticInnerClass();
        staticInnerObj.printStaticMessage();

        // Использование локального класса в методе
        outerObj.printOuterValueFromLocal();

        System.out.println();

        // 3. Исключения
        int numerator = 10;
        int denominator = 0;

        try {
            int result = divide(numerator, denominator);
            System.out.println("Результат деления: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Произошла ошибка деления на ноль: " + e.getMessage());
        }

        System.out.println();

        // 4. Утверждения
        int age = 17;

        // Проверяем, что возраст больше или равен 18
        assert age >= 18 : "Несовершеннолетние не допускаются";

        System.out.println();

        // 5. Протоколирование
        Logger logger = Logger.getLogger(Main.class.getName());

        // Создание обработчика для вывода в консоль
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);

        // Создание форматтера для вывода сообщений
        SimpleFormatter formatter = new SimpleFormatter();
        consoleHandler.setFormatter(formatter);

        // Добавление обработчика к логгеру
        logger.addHandler(consoleHandler);

        // Установка уровня важности сообщений
        logger.setLevel(Level.ALL);

        // Пример записи разных уровней сообщений
        logger.severe("Это сообщение об ошибке");
        logger.warning("Это предупреждение");
        logger.info("Это информационное сообщение");
        logger.config("Это сообщение о конфигурации");
        logger.fine("Это детальное сообщение");
        logger.finest("Это самое детальное сообщение");

        System.out.println();
        }
    }