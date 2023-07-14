class Piramide extends Figura3D {
    private double base;
    private double altura;

    public Piramide(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double calcularArea() {
        double areaBase = base * base;
        double areaLateral = base * altura;
        return areaBase + areaLateral;
    }

    @Override
    public double calcularPerimetro() {
        return -1; // No se aplica a una pirámide
    }

    @Override
    public double calcularVolumen() {
        return (base * base * altura) / 3;
    }
}