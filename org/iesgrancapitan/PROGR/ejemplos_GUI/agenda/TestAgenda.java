package org.iesgrancapitan.PROGR.ejemplos_GUI.agenda;

import java.util.Iterator;

/**
 * Prueba clase Agenda.
 * 
 * @author rafa
 *
 */

public class TestAgenda {

  public static void main(String[] args) throws ContactoException {
    Agenda agenda = new Agenda();

    // añadimos contactos

    System.out.println("Añadimos datos a la agenda...");

    agenda.add("Pepe",   111111111, "pepe@email.es");
    agenda.add("Pepa",   222222222, "pepa@email.es");
    agenda.add("Juana",  333333333, "juana@email.es");
    agenda.add("Juan",   444444444, "juan@email.es");
    agenda.add("Ángel",  555555555, "angel@email.es");
    agenda.add("Ángela", 666666666, "angela@email.es");
    //agenda.add("Ángela", 777777777" "angela2@email.es"); // lanza excepción

    for (Contacto contacto : agenda) {  // uso iterator de agenda
      System.out.println(contacto);
    }

    // borramos contactos

    System.out.println("\nBorro a Pepe y a Gumersindo...");

    agenda.remove("Pepe");
    agenda.remove("Gumersindo"); // no está, no hace nada

    agenda.forEach(contacto -> System.out.println(contacto));  // otro iterador

    // accedemos a contactos

    System.out.println("\nAccedemos a Ángel y al primer elemento...");

    System.out.println(agenda.get("Ángel"));  
    //System.out.println(agenda.get("Pepe"));  // lanza excepción
    System.out.println(agenda.get(0));
    //System.out.println(agenda.get(1000));    // lanza excepción

    // modificamos un contacto

    System.out.println("\nCambiamos datos a Pepa y Ángel...");
    agenda.set("Pepa",  123456789);
    agenda.set("Ángel", 987654321, "angelito@otrocorreo.es");
    //agenda.set("Ángelito", 987654321, "angelito@otrocorreo.es");  // lanza excepción

    Iterator<Contacto> iterador = agenda.iterator();    // otro iterador
    while (iterador.hasNext()) {
      System.out.println(iterador.next()); 

    }
  }

}
