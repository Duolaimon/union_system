package spring;

/**
 * @author Duolaimon
 * 17-10-23 下午6:11
 */
public class InnerClassTest {

    public static int age = 10;

    private static class InClass {
        private static int num;

        static {
            System.out.println("inner");
        }
        class fd{

        }

        public void last() {
            System.out.println(age);
        }
    }

    public void test() {
        InClass inClass = new InClass();
    }

    public static void print() {
        System.out.println("Parent");
    }

    public static void main(String[] args) {
        InnerClassTest innerClassTest = new Sub();
        innerClassTest.print();
        System.out.println(innerClassTest.age);
        Sub sub = new Sub();
        sub.print();
        System.out.println(sub.age);
    }
}

class Sub extends InnerClassTest {
    public static int age = 9;

    public static void print() {
        System.out.println("Sub");
    }


}