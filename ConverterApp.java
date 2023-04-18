import java.net.*;
import java.text.ParseException;
import java.util.Scanner;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;


public class ConverterApp {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);

        System.out.println("¿Que quieres convertir?");
        System.out.println("1. Pesos chilenos a otras monedas");
        System.out.println("2. Otras monedas a pesos chilenos");
        System.out.println("3. Grados Kelvin, Celsius y Fahrenheit");
        System.out.print("Elige una opción (1, 2 o 3): ");

        int option = input.nextInt();

        if (option == 1) {
            System.out.println("¿Cuántos pesos chilenos quieres convertir?");
            double chileanPeso = input.nextDouble();

            String urlStr = "https://api.exchangeratesapi.io/latest?base=CLP";
            URL url;
            try {
                url = new URL(urlStr);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(content.toString());
                JSONObject rates = (JSONObject) jsonObject.get("rates");

                System.out.println(chileanPeso + " pesos chilenos equivalen a:");
                System.out.println(rates.get("USD") + " dólares estadounidenses");
                System.out.println(rates.get("EUR") + " euros");
                System.out.println(rates.get("GBP") + " libras esterlinas");
                System.out.println(rates.get("JPY") + " yenes");
                System.out.println(rates.get("IRR") + " riales");
                System.out.println(rates.get("RUB") + " rublos");
            } catch (MalformedURLException e) {
                System.out.println("La URL no es válida.");
                return;
            } catch (IOException e) {
                System.out.println("Error de conexión.");
                return;
            }
        } else if (option == 2) {
            System.out.println("¿Cuántos dólares quieres convertir?");
            double dollar = input.nextDouble();

            String urlStr = "https://api.exchangeratesapi.io/latest?base=USD";
            URL url;
            try {
                url = new URL(urlStr);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(content.toString());
                JSONObject rates = (JSONObject) jsonObject.get("rates");

                System.out.println(dollar + " dólares estadounidenses equivalen a:");
                System.out.println(rates.get("CLP") + " pesos chilenos");
            } catch (MalformedURLException e) {
                System.out.println("La URL no es válida.");
                return;
            } catch (IOException e) {
                System.out.println("Error de conexión.");
            }
        } else if (option == 3) {
            System.out.println("¿Qué escala quieres convertir?");
            System.out.println("1. Kelvin a Celsius y Fahrenheit");
            System.out.println("2. Celsius a Kelvin y Fahrenheit");
            System.out.println("3. Fahrenheit a Kelvin y Celsius");
            System.out.print("Elige una opción (1, 2 o 3): ");

            int tempOption = input.nextInt();

            if (tempOption == 1) {
                System.out.println("¿Cuántos grados Kelvin quieres convertir?");
                double kelvin = input.nextDouble();

                double celsius = kelvin - 273.15;
                double fahrenheit = celsius * 9/5 + 32;

                System.out.println(kelvin + " grados Kelvin equivalen a:");
                System.out.println(celsius + " grados Celsius");
                System.out.println(fahrenheit + " grados Fahrenheit");
            } else if (tempOption == 2) {
                System.out.println("¿Cuántos grados Celsius quieres convertir?");
                double celsius = input.nextDouble();

                double kelvin = celsius + 273.15;
                double fahrenheit = celsius * 9/5 + 32;

                System.out.println(celsius + " grados Celsius equivalen a:");
                System.out.println(kelvin + " grados Kelvin");
                System.out.println(fahrenheit + " grados Fahrenheit");
            } else if (tempOption == 3) {
                System.out.println("¿Cuántos grados Fahrenheit quieres convertir?");
                double fahrenheit = input.nextDouble();

                double celsius = (fahrenheit - 32) * 5/9;
                double kelvin = celsius + 273.15;

                System.out.println(fahrenheit + " grados Fahrenheit equivalen a:");
                System.out.println(celsius + " grados Celsius");
                System.out.println(kelvin + " grados Kelvin");
            } else {
                System.out.println("Opción no válida.");
                return;
            }
        } else {
            System.out.println("Opción no válida.");
            return;
        }

        input.close();
    }
}
            