import java.util.Scanner;

public class TiendaRopa {
    
    // Constantes de precios
    private static final double PRECIO_CAMISETA = 25000;
    private static final double PRECIO_PANTALON = 45000;
    private static final double PRECIO_CHAQUETA = 65000;
    private static final double IVA = 0.19;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        double costototal = 0;
        
        do {
            System.out.println("\n--- Menú de Compras ---");
            System.out.println("1. Camisetas – Valor: $25.000");
            System.out.println("2. Pantalones – Valor: $45.000");
            System.out.println("3. Chaquetas – Valor: $65.000");
            System.out.println("4. Salir");
            System.out.print("Digite su opción: ");
            opcion = scanner.nextInt();

            String producto = "";
            double precioUnitario = 0;

            switch (opcion) {
                case 1:
                    producto = "Camiseta";
                    precioUnitario = PRECIO_CAMISETA;
                    break;
                case 2:
                    producto = "Pantalón";
                    precioUnitario = PRECIO_PANTALON;
                    break;
                case 3:
                    producto = "Chaqueta";
                    precioUnitario = PRECIO_CHAQUETA;
                    break;
                case 4:
                    System.out.println("Gracias por su visita.");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    continue;
            }

            System.out.print("Ingrese la cantidad que desea comprar: ");
            int cantidad = scanner.nextInt();

            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor a 0.");
                continue;
            }

            // Cálculo de valores
            double subtotal = precioUnitario * cantidad;
            double descuento = 0;
            
            

            if (cantidad >= 3 && cantidad <= 4) {
                descuento = subtotal * 0.10;
            } else if (cantidad > 4) {
                descuento = subtotal * 0.15;
            }

            double subtotalConDescuento = subtotal - descuento;
            double iva = subtotalConDescuento * IVA;
            double total = subtotalConDescuento + iva;
            costototal += total;

            // Resultado
            System.out.println("\n--- Resumen de la compra ---");
            System.out.println("Producto: " + producto);
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Subtotal: $" + subtotal);
            System.out.println("Descuento: $" + descuento);
            System.out.println("IVA (19%): $" + iva);
            System.out.println("Total a pagar: $" + total);
            System.out.println("Costo total: $"+ costototal);

        } while (true);
    }


    @Override
    public String toString() {
        return "TiendaRopa []";
    }
}
