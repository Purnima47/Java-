public class MyException extends Exception {
    // constructor
    MyException(String str) {
        super(str);
    }

    public static void usingThrows() throws MyException {
        int arr[] = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);

            if (arr[i] < 3) {
                // to create your own exception first create constructor then use throws keyword
                // or use try catch.
                MyException me = new MyException("Value is less than 3");
                throw me;
            }
        }
    }

    public static void usingTryCatch() {
        int arr[] = { 1, 2, 3, 4, 5 };
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(arr[i]);

                if (arr[i] < 3) {
                    MyException me = new MyException("Value is less than 3");
                    throw me;
                }
            }
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws MyException {
        // usingThrows();
        usingTryCatch();
    }
}
