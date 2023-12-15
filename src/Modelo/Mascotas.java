
package Modelo;

public class Mascotas {
    
    private int id;
    private String codigo;
    private String nombre;
    private String sexo;
    private int stock;
    private int tamaño;
    private int peso;

    public Mascotas() {
        
    }

    public Mascotas(int id, String codigo, String nombre, String sexo, int stock, int tamaño, int peso) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.sexo = sexo;
        this.stock = stock;
        this.tamaño = tamaño;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

 }



