import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraFiguras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Figura> figuras = new ArrayList<>();

        System.out.println("Calculadora de Figuras\n");

        boolean continuar = true;
        while (continuar) {
            int opcion = mostrarMenu(scanner);
            switch (opcion) {
                case 1:
                    Figura cuadrado = crearCuadrado(scanner);
                    if (cuadrado != null) {
                        figuras.add(cuadrado);
                        System.out.println("Cuadrado agregado correctamente.\n");
                    }
                    break;
                case 2:
                    Figura rectangulo = crearRectangulo(scanner);
                    if (rectangulo != null) {
                        figuras.add(rectangulo);
                        System.out.println("Rectángulo agregado correctamente.\n");
                    }
                    break;
                case 3:
                    Figura cubo = crearCubo(scanner);
                    if (cubo != null) {
                        figuras.add(cubo);
                        System.out.println("Cubo agregado correctamente.\n");
                    }
                    break;
                case 4:
                    Figura triangulo = crearTriangulo(scanner);
                    if (triangulo != null) {
                        figuras.add(triangulo);
                        System.out.println("Triángulo agregado correctamente.\n");
                    }
                    break;
                case 5:
                    Figura piramide = crearPiramide(scanner);
                    if (piramide != null) {
                        figuras.add(piramide);
                        System.out.println("Pirámide agregada correctamente.\n");
                    }
                    break;
                case 6:
                    Figura circulo = crearCirculo(scanner);
                    if (circulo != null) {
                        figuras.add(circulo);
                        System.out.println("Círculo agregado correctamente.\n");
                    }
                    break;
                case 7:
                    Figura esfera = crearEsfera(scanner);
                    if (esfera != null) {
                        figuras.add(esfera);
                        System.out.println("Esfera agregada correctamente.\n");
                    }
                    break;
                case 8:
                    Figura cono = crearCono(scanner);
                    if (cono != null) {
                        figuras.add(cono);
                        System.out.println("Cono agregado correctamente.\n");
                    }
                    break;
                case 9:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.\n");
                    break;
            }
        }

        System.out.println("\nTabla de Figuras\n");
        imprimirTablaFiguras(figuras);
    }

    private static int mostrarMenu(Scanner scanner) {
        System.out.println("Seleccione una figura para ingresar:");
        System.out.println("1. Cuadrado");
        System.out.println("2. Rectángulo");
        System.out.println("3. Cubo");
        System.out.println("4. Triángulo");
        System.out.println("5. Pirámide");
        System.out.println("6. Círculo");
        System.out.println("7. Esfera");
        System.out.println("8. Cono");
        System.out.println("9. Salir");

        System.out.print("Ingrese la opción: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Opción inválida. Intente nuevamente:");
            scanner.next();
        }

        return scanner.nextInt();
    }

    private static Figura crearCuadrado(Scanner scanner) {
        System.out.println("\nIngrese los lados del cuadrado:");
        double lado = pedirDouble(scanner, "Lado: ");
        return new Cuadrado("Cuadrado", lado);
    }

    private static Figura crearRectangulo(Scanner scanner) {
        System.out.println("\nIngrese los lados del rectángulo:");
        double ancho = pedirDouble(scanner, "Ancho: ");
        double largo = pedirDouble(scanner, "Largo: ");
        return new Rectangulo("Rectángulo", ancho, largo);
    }

    private static Figura crearCubo(Scanner scanner) {
        System.out.println("\nIngrese el lado del cubo:");
        double lado = pedirDouble(scanner, "Lado: ");
        return new Cubo("Cubo", lado);
    }

    private static Figura crearTriangulo(Scanner scanner) {
        System.out.println("\nIngrese los lados del triángulo:");
        double ladoA = pedirDouble(scanner, "Lado A: ");
        double ladoB = pedirDouble(scanner, "Lado B: ");
        double ladoC = pedirDouble(scanner, "Lado C: ");
        return new Triangulo("Triángulo", ladoA, ladoB, ladoC);
    }

    private static Figura crearPiramide(Scanner scanner) {
        System.out.println("\nIngrese la base y la altura de la pirámide:");
        double base = pedirDouble(scanner, "Base: ");
        double altura = pedirDouble(scanner, "Altura: ");
        return new Piramide("Pirámide", base, altura);
    }

    private static Figura crearCirculo(Scanner scanner) {
        System.out.println("\nIngrese el radio del círculo:");
        double radio = pedirDouble(scanner, "Radio: ");
        return new Circulo("Círculo", radio);
    }

    private static Figura crearEsfera(Scanner scanner) {
        System.out.println("\nIngrese el radio de la esfera:");
        double radio = pedirDouble(scanner, "Radio: ");
        return new Esfera("Esfera", radio);
    }

    private static Figura crearCono(Scanner scanner) {
        System.out.println("\nIngrese el radio y la altura del cono:");
        double radio = pedirDouble(scanner, "Radio: ");
        double altura = pedirDouble(scanner, "Altura: ");
        return new Cono("Cono", radio, altura);
    }

    private static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("Valor inválido. Intente nuevamente:");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static void imprimirTablaFiguras(List<Figura> figuras) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("| Nombre        | Área                   | Perímetro              | Volumen                |");
        System.out.println("-------------------------------------------------------------------------");

        for (Figura figura : figuras) {
            double area = figura.calcularArea();
            double perimetro = figura.calcularPerimetro();
            String volumen = figura instanceof Figura3D ? String.valueOf(((Figura3D) figura).calcularVolumen()) : "-";

            String areaString = String.format("%.2f", area);
            String perimetroString = String.format("%.2f", perimetro);

            int nombreSpaces = 15 - figura.getNombre().length();
            int areaSpaces = 23 - areaString.length();
            int perimetroSpaces = 23 - perimetroString.length();
            int volumenSpaces = 23 - volumen.length();

            String row = "| " + figura.getNombre() + " ".repeat(nombreSpaces) +
                    "| " + areaString + " ".repeat(areaSpaces) +
                    "| " + perimetroString + " ".repeat(perimetroSpaces) +
                    "| " + volumen + " ".repeat(volumenSpaces) + "|";

            System.out.println(row);
        }

        System.out.println("-------------------------------------------------------------------------");
    }
}
