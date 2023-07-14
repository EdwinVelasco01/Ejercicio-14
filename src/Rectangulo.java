class Rectangulo extends Figura {
    private double ancho;
    private double largo;

    public Rectangulo(String nombre, double ancho, double largo) {
        super(nombre);
        this.ancho = ancho;
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public double getLargo() {
        return largo;
    }

    @Override
    public double calcularArea() {
        return ancho * largo;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (ancho + largo);
    }
}