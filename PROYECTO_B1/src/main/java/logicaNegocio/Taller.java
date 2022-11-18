/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaNegocio;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author carlo
 */
public class Taller {
    //DeclaraciOn de las listas como ArrayList.

    private ArrayList<ParteReparacion> listaParte;
    private ArrayList<Cliente> listaCliente;
    private ArrayList<Vehiculo> listaVehiculo;

    /**
     * Hacemos la reserva de espacio para los ArrayList.
     */
    public Taller() {
        listaParte = new ArrayList<ParteReparacion>();
        listaCliente = new ArrayList<Cliente>();
        listaVehiculo = new ArrayList<Vehiculo>();
    }

    public boolean addCliente(String nombre, String apellidos, String direccion, String dni, String telefono) {

        if (getCliente(dni) == null) {
            listaCliente.add(new Cliente(apellidos, nombre, direccion, dni, telefono));
            return true;
        }

        return false;

    }

    public boolean removeCliente(String dni) {
       return listaCliente.remove(getCliente(dni));
    }

    public Cliente getCliente(String dni) {
        for (Cliente c : listaCliente) {
            if (dni.equals(c.getDni())) {
                return c;
            }
        }
        return null;

    }

   
    public ArrayList<Cliente> getListaCliente() {
        return this.listaCliente;
    }

  
    public boolean addVehiculo(String matricula, String modelo, String tipo, boolean enReparacion) {
        if (getVehiculo(matricula) == null) {
            return listaVehiculo.add(new Vehiculo(matricula, modelo, tipo,enReparacion));
           
        }

        return false;

    }

    
    public boolean removeVehiculo(String matricula) {
         return listaVehiculo.remove(getVehiculo(matricula));
        }

    public Vehiculo getVehiculo(String matricula) {
        for(Vehiculo v:listaVehiculo){
            if (matricula.equals(v.getMatricula())) {
                return v;
            }
        }
        return null;
    }

    
    public ArrayList<Vehiculo> getListaVehiculo() {
        
        return this.listaVehiculo;
    }

    /**
     * Metodo que recibe como parametro la matricula de un vehiculo para obtener
     * su historial de reparaciones.
     *
     * @param matricula La matricula del vehiculo del que se quiere buscar el
     * historial.
     * @return Lista con los datos de todas las reparaciones llevadas a cabo al
     * vehiculo buscado.
     */
    public ArrayList<ParteReparacion> getHistorialVehiculo(String matricula) {
        //Declaramos una nueva lista en la que iran guardando los partes de reparacion de un mismo vehiculo.
        ArrayList<ParteReparacion> listaParteVehiculo = new ArrayList<ParteReparacion>();
         for (ParteReparacion p:listaParte) {
            if (matricula.equals(p.getMatriculaVehiculo())) {
                listaParteVehiculo.add(p);
            }
        }

        
        return listaParteVehiculo;
    }

    
    public int getCodigoParteReparacion() {
        //Declaramos una variable que almacenara un valor mayor en un numero al numero de partes de reparacion existentes, esto es para que no exista ningun parte con el codigo "0".
        int codigo = listaParte.size() + 1;
        //Devolvemos la variable declarara con el codigo almacenado.
        return codigo;
    }

    public void addParte(int codigo, String dniCliente, String matriculaVehiculo, Date fechaEntrada, boolean estadoReparacion, int horasEstimadas, int horasReales,
            Date fechaSalida, double cuantiaReparacion, String tipoAveria) {
        //Creamos un nuevo parte de reparacion con los valores pasados como parametros.
        listaParte.add(new ParteReparacion(codigo, dniCliente, matriculaVehiculo, fechaEntrada, estadoReparacion, horasEstimadas, horasReales, fechaSalida, cuantiaReparacion, tipoAveria));
    }

    /**
     * Metodo que recibe como parametro la matricula de un vehiculo y busca si
     * hay partes de reparacion pendientes de ese mismo vehiculo.
     *
     * @param matricula Matricula del vehiculo del que buscar todos los partes
     * de reparacion pendiente.
     * @return Verdadero si no hay ningun parte de reparacion pendiente con esa
     * misma matricula y falso en caso contrario.
     */
    public boolean getListadoPartePendientesMatriculas(String matricula) {
        //Declaramos una nueva lista en la que iran guardando los partes de reparacion pendientes de un mismo vehiculo.
        ArrayList<ParteReparacion> listaPartePendientesMatriculas = new ArrayList<ParteReparacion>();

        //Iniciamos un bucle que recorra toda la lista de partes de reparacion, si encuentra un parte con un vehiculo con la misma matricula que se buscaba y cuyo estado de reparacion sea pendiente,
        //añadimos dicho parte a la lista creada antes.
        for (int i = 0; i < listaParte.size(); i++) {
            if (matricula.equals(listaParte.get(i).getMatriculaVehiculo()) && listaParte.get(i).getEstadoReparacion() == false) {
                listaPartePendientesMatriculas.add(listaParte.get(i));
            }
        }

        //Devolvemos un valor booleano verdadero si la lista tiene elementos y uno falso en caso contrario.
        if (listaPartePendientesMatriculas.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que recibe el codigo de un parte de reparacion como argumento y
     * devuelve los datos del mismo.
     *
     * @param codigo Codigo del parte del que obtener los datos.
     * @return Parte de reparacion correspondiente al codigo pasado como
     * argumento.
     */
    public ParteReparacion getParte(int codigo) {
        //Devolvemos el parte de reparacion de la posicion del codigo pasado como parametro.
        return this.listaParte.get(codigo - 1);
    }

    /**
     * Metodo que devuelve una lista con los datos de todos los partes de
     * reparacion pendientes.
     *
     * @return Lista con todos los partes de reparacion pendientes.
     */
    public ArrayList<ParteReparacion> getListadoPartePendientes() {
        //Declaramos una nueva lista en la que iran guardando los partes de reparacion pendientes.
        ArrayList<ParteReparacion> listaPartePendientes = new ArrayList<ParteReparacion>();

        //Iniciamos un bucle que recorra toda la lista de partes de reparacion, si encuentra un parte con un vehiculo con el estado de reparacion pendiente, añadimos dicho parte a la lista creada antes.
        for (int i = 0; i < listaParte.size(); i++) {
            if (listaParte.get(i).getEstadoReparacion() == false) {
                listaPartePendientes.add(listaParte.get(i));
            }
        }

        //Devolvemos la lista creada antes con los partes de reparacion pendientes.
        return listaPartePendientes;
    }

    /**
     * Metodo que devuelve una lista con los datos de todos los partes de
     * reparacion de un mismo cliente.
     *
     * @param dni D.N.I. del cliente del que buscar los partes de reparacion.
     * @return Lista con todos los partes de reparacion del cliente.
     */
    public ArrayList<ParteReparacion> getListadoParteCliente(String dni) {
        //Declaramos una nueva lista en la que iran guardando los partes de reparacion de un cliente.
        ArrayList<ParteReparacion> listaParteCliente = new ArrayList<ParteReparacion>();

        //Iniciamos un bucle que recorra toda la lista de partes de reparacion, si encuentra un parte con un cliente con el mismo D.N.I. que se buscaba, añadimos dicho parte a la lista creada antes.
        for (int i = 0; i < listaParte.size(); i++) {
            if (dni.equals(listaParte.get(i).getDniCliente())) {
                listaParteCliente.add(listaParte.get(i));
            }
        }

        //Devolvemos la lista creada antes con los partes de reparacion de un mismo cliente.
        return listaParteCliente;
    }

    /**
     * Metodo que devuelve el tamaño de la lista de todos partes de reparacion.
     *
     * return Cantidad de partes de reparacion existentes en la lista de partes
     * de reparacion.
     */
    public int getDimensionListaParteReparacion() {
        int dimension = listaParte.size();
        //Devolvemos el tamaño de la lista de partes de reparacion.
        return dimension;
    }

    /**
     * Metodo que devuelve la suma de las horas reales empleadas en la
     * reparacion de todos los vehiculos reparados en el taller.
     *
     * return Suma de las horas reales de reparacion de todos los partes de
     * reparacion finalizados.
     */
    public int getHorasRealesParteFinalizados() {
        //Declaramos una variable que ira almacenando la suma de las horas reales.
        int suma = 0;

        //Iniciamos un bucle que recorra toda la lista de partes de reparacion, cada vez que se encuentre un parte de reparacion cuyo estado de reparacion sea finalizado, se sumara a la variable 
        //declarada el numero de horas reales del parte de reparacion.
        for (int i = 0; i < listaParte.size(); i++) {
            if (listaParte.get(i).getEstadoReparacion() == true) {
                suma = suma + listaParte.get(i).getHorasReales();
            }
        }

        //Devolvemos el entero con la suma de las horas reales de los partes finalizados.
        return suma;
    }

    /**
     * Metodo que devuelve una lista con los datos de todos los partes de
     * reparacion pendientes de un mismo cliente.
     *
     * @param dni D.N.I. del cliente del que buscar los partes de reparacion
     * pendientes.
     * @return Lista con todos los partes de reparacion pendientes del cliente.
     */
    public ArrayList<ParteReparacion> getListadoPartePendientesCliente(String dni) {
        //Declaramos una nueva lista en la que iran guardando los partes de reparacion pendiente de un cliente.
        ArrayList<ParteReparacion> listaPartePendientesCliente = new ArrayList<ParteReparacion>();

        //Iniciamos un bucle que recorra toda la lista de partes de reparacion, si encuentra un parte con un cliente con el mismo D.N.I. que se buscaba y con el estado de la reparacion pendiente,
        //añadimos dicho parte a la lista creada antes.
        for (int i = 0; i < listaParte.size(); i++) {
            if (dni.equals(listaParte.get(i).getDniCliente()) && listaParte.get(i).getEstadoReparacion() == false) {
                listaPartePendientesCliente.add(listaParte.get(i));
            }
        }

        //Devolvemos la lista creada antes con los partes de reparacion pendientes de un mismo cliente.
        return listaPartePendientesCliente;
    }

    /**
     * Metodo que devuelve una lista con los datos de todos los partes de
     * reparacion pendientes para un mismo cliente con un mismo vehiculo.
     *
     * @param listaPartePendientesCliente Lista con todos los partes de
     * reparacion de un mismo cliente.
     * @param matricula Matricula del vehiculo del que se buscan los partes de
     * reparacion pendientes.
     * @return Lista con todos los partes de reparacion pendientes para un mismo
     * cliente con un mismo vehiculo.
     */
    public ArrayList<ParteReparacion> getListadoPartePendientesVehiculo(ArrayList<ParteReparacion> listaPartePendientesCliente, String matricula) {
        //Declaramos una nueva lista en la que iran guardando los partes de reparacion pendientes de un mismo cliente con un mismo vehiculo.
        ArrayList<ParteReparacion> listaPartePendientesVehiculo = new ArrayList<ParteReparacion>();

        //Iniciamos un bucle que recorra toda la lista de partes de reparacion pendientes de un cliente, si encuentra un parte con un vehiculo con la misma matricula que se buscaba, 
        //añadimos dicho parte a la lista creada antes.
        for (int i = 0; i < listaPartePendientesCliente.size(); i++) {
            if (matricula.equals(listaPartePendientesCliente.get(i).getMatriculaVehiculo())) {
                listaPartePendientesVehiculo.add(listaPartePendientesCliente.get(i));
            }
        }

        //Devolvemos la lista creada antes con los partes de reparacion pendientes de un mismo cliente con un mismo vehiculo.
        return listaPartePendientesVehiculo;
    }

    /**
     * Metodo que devuelve la lista completa con los datos de todos los partes
     * de reparacion.
     *
     * @return Lista completa de los partes de reparacion.
     */
    public ArrayList<ParteReparacion> getTodosParte() {
        //Devolvemos la lista completa de los partes de reparacion.
        return this.listaParte;
    }
}
