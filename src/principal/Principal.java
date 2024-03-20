package principal;

import java.util.Scanner;
import microservicios.CarroCompras;
import microservicios.Inventario;
import microservicios.Usuario;
import notifiers.NotificarPago;

public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        NotificarPago notificar = new NotificarPago();
        CarroCompras carritoDeCompras = new CarroCompras();
        Inventario inventario = new Inventario();

        System.out.print("Ingrese el nombre del comprador: ");
        String usuario_quien_compra = entrada.next();
        Usuario usuario = new Usuario(usuario_quien_compra);
        System.out.println("..........................................\n");

        notificar.attach(usuario);
        notificar.attach(inventario);
        notificar.attach(carritoDeCompras);

        while (true) {
            System.out.print("Seleccione el producto a comprar\n1. Zapatos deportivos \n2. Camisa corta\n3. Chaqueta \n4. Salir\nOpcion número: ");
            int opcion = entrada.nextInt();
            System.out.println("..........................................");
            
            String articulo = null;
            
            switch (opcion) {
                case 1:
                    articulo = "Zapatos deportivos";
                    break;
                case 2:
                    articulo = "Camisa corta";
                    break;
                case 3:
                    articulo = "Chaqueta";
                    break;
                default:
                    break;
            }

            if (opcion == 4) break;

            System.out.print("Ingrese la cantidad del producto a comprar: ");
            int cantidad = entrada.nextInt();

            System.out.println("..........................................");
            System.out.print("\nSeleccione:\n1. Si desea añadir el producto al carrito de compras\n2. Si desea volver a escojer un producto\nOpcion número: ");
            int opcion_compra_producto = entrada.nextInt();

            // carrito de compras
            if (opcion_compra_producto == 1) {
                carritoDeCompras.agregarProducto(articulo, cantidad);

                // Mostrar los productos seleccionados
                carritoDeCompras.mostrarCarrito();
                System.out.println("..........................................");
                
                System.out.print("\nSeleccione:\n1. Pagar\n2. Si desea agregar mas productos al carrito\nOpcion número: ");
                int opcion_compra = entrada.nextInt();
                System.out.println("..........................................\n");

                if (opcion_compra == 1) {
                    notificar.notificarCompra("Se ha realizado la compra con éxito");
                    inventario.actualizarUnidades(cantidad);
                    //System.out.println("Las nuevas unidades del inventario son: "+inventario.getUnidades()+"\n");
                    carritoDeCompras.eliminarProductos();// Limpiar el carrito después de la compra
                }
            }
        }
    }
}
