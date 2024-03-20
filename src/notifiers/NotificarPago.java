package notifiers;

import interfaces.Compras;
import java.util.ArrayList;
import java.util.List;

public class NotificarPago {
    
    private final List<Compras> compras = new ArrayList<>();
    
    public void attach(Compras compra){
        compras.add(compra);
    }
    
    public void detach(Compras compra){
        compras.remove(compra);
    }
    
    public void notificarCompra(String message){
        for(Compras compra: compras){
            compra.ActualizarPago(message);
        }
    }
    
}
