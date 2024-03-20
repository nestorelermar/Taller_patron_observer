package microservicios;

import interfaces.Compras;

public class Inventario implements Compras{
    
    private int unidades = 100;

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    // Método para actualizar las unidades del inventario
    public void actualizarUnidades(int nuevasUnidades) {
        unidades -= nuevasUnidades;
    }
    
    // Método para actualizar el pago
    @Override
    public void ActualizarPago(String message) {
        System.out.println("Inventario: " + message + ", se actualizó el inventario descontando las unidades.");
    }
        
}
