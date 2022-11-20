
package logicaNegocio;

/**
 *
 * @author carlo
 */
public class Cliente {

    private String apellidos;
    private String nombre;
    private String direccion;
    private String dni;
    private String telefono;
    

    public Cliente(String apellidos, String nombre, String direccion, String dni, String telefono) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return nombre+", "+apellidos+" | DNI: "+dni+ " | Telefono: "+telefono+" | Dirección: "+direccion; 
    }
    
}
