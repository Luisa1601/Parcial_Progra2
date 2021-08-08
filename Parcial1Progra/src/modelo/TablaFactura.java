
package modelo;


public class TablaFactura {
    
    /* 
    SE CREA UN MODELO CON LAS PROPIEDADES QUE SE VAN A UTILIZAR EN LA TABLA DE FACTURA,
    EN REALIDAD NO SE UTILIZAN TODOS LOS METODOS GETTER Y SETTER PERO ES BUENA PRÁTICA ASÍ COMO TAMBIÉN
    USAR TANTO CONSTRUCTOR VACÍO, CONSTRUCTOR CON PROPIEDADES
    */
    
    private String producto;
    private int unidades;
    private double precio;
    private double peso;
    private double gastoValor;
    private double gastoPeso;
    private double costoUnidad;
    private double costoTotal;

    
    public TablaFactura() {
    }

    public TablaFactura(int unidades, String producto, double precio, double gastoValor, double gastoPeso, double costoUnidad, double costoTotal, double peso) {
        this.unidades = unidades;
        this.producto = producto;
        this.precio = precio;
        this.gastoValor = gastoValor;
        this.gastoPeso = gastoPeso;
        this.costoUnidad = costoUnidad;
        this.costoTotal = costoTotal;
        this.peso = peso;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getGastoValor() {
        return gastoValor;
    }

    public void setGastoValor(double gastoValor) {
        this.gastoValor = gastoValor;
    }

    public double getGastoPeso() {
        return gastoPeso;
    }

    public void setGastoPeso(double gastoPeso) {
        this.gastoPeso = gastoPeso;
    }

    public double getCostoUnidad() {
        return costoUnidad;
    }

    public void setCostoUnidad(double costoUnidad) {
        this.costoUnidad = costoUnidad;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    
    
}
