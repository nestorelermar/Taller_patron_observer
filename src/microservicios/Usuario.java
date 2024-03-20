package microservicios;

import interfaces.Compras;

public class Usuario implements Compras {
    
    private String nombre_usuario;
    
    public Usuario(String nombre_usuario){
        this.nombre_usuario = nombre_usuario;
    }

    @Override
    public void ActualizarPago(String message) {
        System.out.println("El usuario: "+this.nombre_usuario+" "+message);
    }
    
}
