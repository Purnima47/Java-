import java.io.*;

public class StreamsInJava {

    public static void readInFileByByteStream() {
        try {
            // open file
            FileInputStream inputStream = new FileInputStream("input.txt");
            // data (int) --> character
            int data;
            String str = "";
            while ((data = inputStream.read()) != -1) {
                str = str + (char) data;
            }
            System.out.println(str);
            inputStream.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void writeInFileByByteStream() {
        try {
            FileOutputStream outputStream = new FileOutputStream("output.txt");
            // data to be written
            String data = "ANSHIKA TYAGI";
            // convert the data to byte array
            byte dataInBytes[] = data.getBytes();
            // to write data in text file use write().
            outputStream.write(dataInBytes);
            // close the file if used.
            outputStream.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void readInFileByCharStream() {
        try {
            FileReader reader = new FileReader("input.txt");
            int data;
            String str = "";
            while ((data = reader.read()) != -1) {
                str = str + (char) data;
            }
            System.out.println(str);
            reader.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void writeInFileByCharStream() {
        try {
            FileWriter writer = new FileWriter("output.txt");
            // data to be written
            String data = "ANSHIKA TYAGI";
            // convert the data to char array
            char dataInChar[] = data.toCharArray();
            // to write data in text file use write().
            writer.write(dataInChar);
            // close the file if used.
            writer.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // readInFileByByteStream();
        writeInFileByByteStream();
        // readInFileByCharStream();
        writeInFileByCharStream();
    }
}
