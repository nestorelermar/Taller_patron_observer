package microservicios;

import interfaces.Compras;
import java.util.ArrayList;

public class CarroCompras implements Compras {

    private ArrayList<String> compra;

    public CarroCompras() {
        compra = new ArrayList<>();
    }

    public void agregarProducto(String opcion, int cantidad) {
        compra.add("- "+opcion + " | Cantidad: " + cantidad);
    }

    public void mostrarCarrito() {
        System.out.println("\n..........................................\n");
        System.out.println("Carrito de compras:");
        for (String producto : compra) {
            System.out.println(producto);
            System.out.println("--------------------------------");
        }
    }

    public void eliminarProductos() {
        compra.clear();
    }

    @Override
    public void ActualizarPago(String message) {
        System.out.println("Carro de Compras: " + message + ", productos eliminados del carrito\n");
    }

}
