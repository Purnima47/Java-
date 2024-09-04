public class ExceptionsInJava {

    public static void divisionByZero(int a) {
        try {
            int div = 50 / a;
            System.out.println(div);
            // System.out.println("1234");
        } catch (ArithmeticException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        System.out.println("-----end of example 1-----");
    }

    public static void multipleCatch() {
        try {
            int arr[] = new int[10];
            arr[12] = 30 / 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("array out of bound");
        } catch (ArithmeticException e) {
            // TODO: handle exception
            System.out.println("Arithmetic exception occurred " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("-----end of example 2-----");
    }

    public static void finallyBlock() {
        try {
            int div = 10 / 2;
            System.out.println(div);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("THIS IS ALWAYS EXECUTED");
        }
        System.out.println("-----end of example 3-----");
    }

    public static void throwKeyWord(int age) {
        try {
            if (age < 18) {
                throw new ArithmeticException("Not Eligible to Vote");
            } else {
                System.out.println("Eligible");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            System.out.println("FINALLY BLOCK");
        }

        // if (age < 18) {
        // throw new ArithmeticException("Not Eligible to Vote");
        // } else {
        // System.out.println("Eligible");
        // }
        // this is not executed
        System.out.println("-----end of example 4-----");
    }

    public static void main(String[] args) {
        // divisionByZero(0);
        // multipleCatch();
        // finallyBlock();
        // throwKeyWord(2);
    }
}
