package Prueba;
import java.util.Scanner;


class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

class Compra {
    private Producto producto;
    private int cantidad;
    private static final double IVA = 0.19;

    public Compra(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    public double calcularDescuento() {
        double subtotal = calcularSubtotal();
        if (cantidad >= 3 && cantidad <= 4) {
            return subtotal * 0.10;
        } else if (cantidad > 4) {
            return subtotal * 0.15;
        } else {
            return 0;
        }
    }

    public double calcularIVA() {
        return (calcularSubtotal() - calcularDescuento()) * IVA;
    }

    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento() + calcularIVA();
    }

    public void mostrarResumen() {
        System.out.println("\nResumen de la compra:");
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Subtotal: $" + calcularSubtotal());
        System.out.println("Descuento: $" + calcularDescuento());
        System.out.println("IVA (19%): $" + calcularIVA());
        System.out.println("Total a pagar: $" + calcularTotal());
    }
}

public class TiendaRopa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Compras ---");
            System.out.println("1. Camisetas – Valor: $25.000");
            System.out.println("2. Pantalones – Valor: $45.000");
            System.out.println("3. Chaquetas – Valor: $65.000");
            System.out.println("4. Salir");
            System.out.print("Digite su opción: ");
            opcion = input.nextInt();

            Producto productoSeleccionado = null;

            switch (opcion) {
                case 1:
                    productoSeleccionado = new Producto("Camiseta", 25000);
                    break;
                case 2:
                    productoSeleccionado = new Producto("Pantalón", 45000);
                    break;
                case 3:
                    productoSeleccionado = new Producto("Chaqueta", 65000);
                    break;
                case 4:
                    System.out.println("Gracias por su visita.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            if (productoSeleccionado != null) {
                System.out.print("Ingrese la cantidad que desea comprar: ");
                int cantidad = input.nextInt();

                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser mayor a 0.");
                    continue;
                }

                Compra compra = new Compra(productoSeleccionado, cantidad);
                compra.mostrarResumen();
            }

        } while (opcion != 4);

        input.close();
    }
}
