package org.iesgrancapitan.PROGR.ejemplos_GUI.agenda;

public class Contacto {

  public Contacto(String nombre, int telefono, String email) {
    this.nombre = nombre;
    this.telefono = telefono;
    this.email = email;
  }
  
  // atributos
  private String nombre;
  private int telefono;
  private String email;

  //getters y setters
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public int getTelefono() {
    return telefono;
  }
  public void setTelefono(int telefono) {
    this.telefono = telefono;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  
  public void set(int telefono, String email) {
    setTelefono(telefono);
    setEmail(email);
  }
  
  @Override
  public String toString() {
    return "Contacto [nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + "]";
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Contacto other = (Contacto) obj;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    return true;
  }

}
