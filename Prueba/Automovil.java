package Prueba;
public class Automovil {
    
    String marca;
    int modelo;
    int velocidadMaxima;
    int velocidadActual;

    public enum tipoCom{
        GASOLINA,
        BIOETANOL,
        DIESEL,
        GAS_NATURAL,
        BIODIESEL
    }
    tipoCom tipoCombustible;
    public enum tipoAuto {
        CIUDAD,
        COMPACTO,
        SUBCOMPACTO,
        SUV,
        EJECUTIVO
    }

    tipoAuto tipoAutomovil;
    public Automovil(String marca, int modelo, int velocidadMaxima, Automovil.tipoCom tipoCombustible,
            Automovil.tipoAuto tipoAutomovil) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomovil = tipoAutomovil;
    }
    public int getVelocidadActual() {
        return velocidadActual;
    }
    public void setVelocidadActual(int velocidadActual) {

    }

    void acelerar(int incremento) {
        if ((velocidadActual+incremento)<=velocidadMaxima) {
        velocidadActual=velocidadActual+incremento;
        } else {
            System.out.println("No se puede desacelerar por encima de la velocidad máxima");
        }
        
    }
    void desacelerar(int decremento){
        if ((velocidadActual-decremento)>0) {
            velocidadActual=velocidadActual-decremento;
        } else {
            System.out.println("No se puede desacelerar por debajo de 0");
        }
    }
    public static void main(String[] args) {
        

    }
}
