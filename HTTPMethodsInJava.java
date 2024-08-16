import java.io.*;
import java.net.*;

public class HTTPMethodsInJava {

    public static void getMethod() {
        try {
            URL url = new URI("https://www.baeldung.com/java-http-request").toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int resCode = connection.getResponseCode();

            if (resCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                String res = "";
                while ((line = reader.readLine()) != null) {
                    res += line;
                }
                reader.close();
                System.out.println("Response is: " + res);
            } else {
                System.out.println("Error: " + resCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void postMethod() {
        try {
            URL url = new URI("https://www.baeldung.com/java-http-request").toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            String postData = "post-->";
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(postData);
            outputStream.flush();
            outputStream.close();

            int resCode = connection.getResponseCode();

            if (resCode == HttpURLConnection.HTTP_OK) {
                // Process response
            } else {
                // handle error
                System.out.println("Error: " + resCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void putMethod() {
        try {
            URL url = new URI("https://www.baeldung.com/java-http-request").toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);

            String putData = "put-->(update)";
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(putData);
            outputStream.flush();
            outputStream.close();

            int resCode = connection.getResponseCode();

            if (resCode == HttpURLConnection.HTTP_OK) {
                // Process response
            } else {
                // handle error
                System.out.println("Error: " + resCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void deleteMethod() {
        try {
            URL url = new URI("https://api.ex.com/resource/123").toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            int resCode = connection.getResponseCode();
            if (resCode == HttpURLConnection.HTTP_NO_CONTENT) {
                // resource deleted successfully
            } else if (resCode == HttpURLConnection.HTTP_NOT_FOUND) {
                // not found
            } else {
                // handle other errors
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // getMethod();
        // postMethod();
        // putMethod();
        // deleteMethod();
    }
}
