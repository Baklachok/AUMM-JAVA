public class OuterClass {
    private int outerValue;

    public OuterClass(int value) {
        this.outerValue = value;
    }

    // Обычный внутренний класс
    public class InnerClass {
        public void printOuterValue() {
            System.out.println("Outer Value: " + outerValue);
        }
    }

    // Статический внутренний класс
    public static class StaticInnerClass {
        public void printStaticMessage() {
            System.out.println("Static Inner Class Message");
        }
    }

    // Локальный класс внутри метода
    public void printOuterValueFromLocal() {
        class LocalClass {
            public void printOuterValue() {
                System.out.println("Outer Value (from Local Class): " + outerValue);
            }
        }

        LocalClass localObj = new LocalClass();
        localObj.printOuterValue();
    }
}