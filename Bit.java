
public class Bit {
    public static void BinaryOp() {
        System.out.println(5 & 6); // Binary AND
        System.out.println(5 | 6); // Binary OR
        System.out.println(5 ^ 6); // Binary XOR
        System.out.println(~5); // Binary 1's Complement
        System.out.println(5 << 2);// Binary Left Shift (a<<b = a*2^b-->2 ki power b)
        System.out.println(6 >> 1);// Binary Right Shift (a>>b=a/2^b)
    }

    public static void OddEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            System.out.println("Even no.");
        } else {
            System.out.println("Odd no.");
        }
    }

    public static int GetBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else
            return 1;
    }

    public static void setithBit(int n, int i) {
        int bitMask = 1 << i;
        System.out.println(n | bitMask);
    }

    public static int clearithBit(int n, int i) {
        int bitMask = ~(1 << i);
        return (n & bitMask);
    }

    public static void updateithBit(int n, int i, int newBit) {
        n = clearithBit(n, i);
        int bitMask = newBit << i;
        System.out.println(n | bitMask);

    }

    public static void clearIbits(int n, int i) {
        int bitMask = (~0) << i;
        System.out.println(n & bitMask);
    }

    public static void clearRangebit(int n, int i, int j) {
        int a = (~0) << (j + 1);
        int b = (1 << i) - 1;
        int bitMask = a | b;
        System.out.println(n & bitMask);
    }

    public static boolean powerOf2(int n) {
        return (n & (n - 1)) == 0;
    }

    public static void CountSetBit(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        System.out.println(count);
    }

    public static void Exponential(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) { // if LSB is 1..
                ans *= a;
            }
            a *= a;
            n >>= 1;
        }
        System.out.println(ans);
    }

    public static void ModularExponential(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if (n % 2 == 0) {
                a = a * a;
                n = n / 2;
            } else {
                ans = ans * a;
                n = n - 1;
            }
        }
        System.out.println(ans);
    }

    public static void UpperToLower() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' '));
        }
        System.out.println();
    }

    public static void LowerToUpper() {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.print((char) (ch & ('_')));
        }
        System.out.println();
    }

    public static void Add1toInt(int n) {
        int sum;
        if ((n & 1) == 0) {
            sum = (n | 1);
            System.out.println(sum);
        } else {
            sum = -(~n);
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        BinaryOp();
        OddEven(6);
        System.out.println(GetBit(15, 4));
        setithBit(10, 2);
        System.out.println(clearithBit(3, 1));
        updateithBit(8, 3, 1);
        System.out.println(powerOf2(4));
        CountSetBit(10);
        Exponential(3, 5);
        ModularExponential(2, 5);
        UpperToLower();
        LowerToUpper();
        Add1toInt(7);
    }
}

// 01 -->1 10-->2
// 01
// 011-->3 100
// 001