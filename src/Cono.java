class Cono extends Figura3D {
    private double radio;
    private double altura;

    public Cono(String nombre, double radio, double altura) {
        super(nombre);
        this.radio = radio;
        this.altura = altura;
    }

    public double getRadio() {
        return radio;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double calcularArea() {
        double generatriz = Math.sqrt(radio * radio + altura * altura);
        return Math.PI * radio * (radio + generatriz);
    }

    @Override
    public double calcularPerimetro() {
        return -1; // No se aplica a un cono
    }

    @Override
    public double calcularVolumen() {
        return (Math.PI * radio * radio * altura) / 3;
    }
}