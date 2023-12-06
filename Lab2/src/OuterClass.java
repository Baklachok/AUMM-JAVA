// 4. Встроенные функциональные интерфейсы
public class OuterClass {
    // Внутренний функциональный интерфейс
    interface MyFunctionalInterface {
        void myMethod();
    }

    // Пример внутреннего класса
    static class InnerClass {
        void innerMethod() {
            System.out.println("Executing innerMethod");
        }
    }

    public static void main(String[] args) {

        // Использование внутреннего функционального интерфейса
        MyFunctionalInterface myFunctionalInterface = () -> {
            System.out.println("Executing myMethod");
        };

        myFunctionalInterface.myMethod();

        // Использование внутреннего класса
        InnerClass innerObject = new InnerClass();
        innerObject.innerMethod();
    }
}
