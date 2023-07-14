class Cubo extends Figura3D {
    private double lado;

    public Cubo(String nombre, double lado) {
        super(nombre);
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public double calcularArea() {
        return 6 * lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 12 * lado;
    }

    @Override
    public double calcularVolumen() {
        return lado * lado * lado;
    }
}