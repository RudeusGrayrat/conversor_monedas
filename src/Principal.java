import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        MonedasApi consulta = new MonedasApi();
        Scanner entrada = new Scanner(System.in);
        var moneda1 = "";
        var moneda2 = "";

        while (true) {
            System.out.println("ingrese la opción: ");
            System.out.println("1. Sol a Dólar");
            System.out.println("2. Sol a Euro");
            System.out.println("3. Peso argentino a Sol");
            System.out.println("4. Euro a Dólar");
            System.out.println("5. Peso chileno a Sol");
            System.out.println("6. Peso Mexicano a Peso chileno");
            System.out.println("7. salir");
            var opcion = entrada.nextInt();
            if (opcion == 7) {
                break;
            } else {
                System.out.println("cuanto va a cambiar?");
                var monto = entrada.nextInt();
                if (opcion == 1) {
                    moneda1 = "PEN";
                    moneda2 = "USD";
                } else if (opcion == 2) {
                    moneda1 = "ARS";
                    moneda2 = "PEN";
                } else if (opcion == 3) {
                    moneda1 = "ARS";
                    moneda2 = "PEN";
                } else if (opcion == 4) {
                    moneda1 = "EUR";
                    moneda2 = "USD";
                } else if (opcion == 5) {
                    moneda1 = "CLP";
                    moneda2 = "PEN";
                } else if (opcion == 6) {
                    moneda1 = "MXN";
                    moneda2 = "CLP";
                }
                var response = consulta.buscaMoneda(moneda1, moneda2);
                System.out.println("su conversión de "+
                        moneda1 + " a " + moneda2 + " es: ");
                System.out.println(response.conversion_rate() * monto);
            }

        }
        System.out.println("Gracias por su Tiempo!");
    }
}
