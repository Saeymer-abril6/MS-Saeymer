package pe.edu.upeu.sysventas.enums;


import lombok.Getter;

@Getter
public enum TipoProducto {
    PRODUCTO("Producto"),
    PREPAPARADO("Preparado"),
    SERVICIO("Servicio");

    String descripcion;
    TipoProducto(String descripcion){
        this.descripcion=descripcion;
    }
}
