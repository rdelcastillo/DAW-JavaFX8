package org.iesgrancapitan.PROGR.ejemplos_GUI.agenda;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * El concepto de Java Iterable es un concepto clásico en el mundo Java y existe desde la versión de
 * Java 1.5 . 
 * 
 * Un Iterable  es un interface que hace referencia a una colección de elementos que se puede recorrer.
 * 
 * El interface solo necesita que implementemos un método para poder funcionar de forma correcta, 
 * este método es iterator().
 * 
 * Este clase lo implementa, es una agenda con una lista de contactos.
 * 
 * Más información en https://www.arquitecturajava.com/java-iterable-interface-y-como-implementarlo/
 * 
 */

public class Agenda implements Iterable<Contacto> {

  ArrayList<Contacto> contactos = new ArrayList<Contacto>();

  public void add(String nombre, int telefono, String email) throws ContactoException {
    Contacto contacto = new Contacto(nombre, telefono, email);
    if (contactos.contains(contacto)) {
      throw new ContactoException("El contacto " + contacto.getNombre() + " ya existe.");
    }
    contactos.add(contacto);
  }
  
  public void add(String nombre, int telefono) throws ContactoException {
    add(nombre, telefono, "");
  }

  public Contacto get(String nombre) throws ContactoException {
    try {
      return contactos.get(contactos.indexOf(new Contacto(nombre,0,"")));
    } catch (IndexOutOfBoundsException e) {
      throw new ContactoException("El contacto " + nombre + " no existe.");
    }
  }
  
  public Contacto get(int posicion) throws ContactoException {
    try {
      return contactos.get(posicion);
    } catch (IndexOutOfBoundsException e) {
      throw new ContactoException("En la posición " + posicion + " no hay un contacto.");
    }
  }

  public boolean remove(String nombre) {
    return contactos.remove(new Contacto(nombre, 0, ""));
  }

  public void set(Contacto contacto, int telefono, String email) throws ContactoException {
    try {
      contactos.get(contactos.indexOf(contacto)).set(telefono, email);
    } catch (IndexOutOfBoundsException e) {
      throw new ContactoException("El contacto " + contacto.getNombre() + " no existe.");
    }
  }
  
  public void set(Contacto contacto, int telefono) throws ContactoException {
    try {
      contactos.get(contactos.indexOf(contacto)).setTelefono(telefono);
    } catch (IndexOutOfBoundsException e) {
      throw new ContactoException("El contacto " + contacto.getNombre() + " no existe.");
    }
  }
  
  public void set(String nombre, int telefono, String email) throws ContactoException {
    set(new Contacto(nombre, 0, ""), telefono, email);
  }
  
  public void set(String nombre, int telefono) throws ContactoException {
    set(new Contacto(nombre, 0, ""), telefono);
  }

  @Override
  public String toString() {
    return "Agenda [contactos=" + contactos + "]";
  }

  @Override
  public Iterator<Contacto> iterator() {
    // No necesitamos crear un iterador propio, sacamos el del ArrayList
    return contactos.iterator();
  }

  

}
