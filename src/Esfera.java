class Esfera extends Figura3D {
    private double radio;

    public Esfera(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public double calcularArea() {
        return 4 * Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return -1; // No se aplica a una esfera
    }

    @Override
    public double calcularVolumen() {
        return (4 * Math.PI * radio * radio * radio) / 3;
    }
}
