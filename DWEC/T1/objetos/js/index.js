/* Objectos -> se definen mediante clase

public class MiObjecto extends ClasePadre implements Interfaz1, Interfaz2 {

    propiedades
    MiObjecto(param){}
    metodos(){}
    getter/setter()
}

public interface Interfaz{
    conjunto de metodos abs que no tenian cuerpo
}
*/
// let tareaBase = new tarea("Titulo 1", "Descripcion de la tarea", "Baja", true);
// tareaBase.setTitulo = "Nuevo titulo";
// console.log(`El titlo es: ${tareaBase.getTitulo}`);
// tareaBase.mostrarDatos();

let tareaTrabajoBase = new tareaTrabajo(
  "Titulo 1 Trabajo",
  "Descripcion Trabajo",
  "Alta",
  true,
  "Borja"
);

let tareaPersonalBase = new tareaPersonal(
  "Titulo 1 Personal",
  "Descripcion Pesonal",
  "Media",
  false,
  "Maria"
);

let tareaPersonalBase1 = new tareaPersonal(
  "Titulo 2 Personal",
  "Descripcion 2 Pesonal",
  "Baja",
  true,
  "Juan"
);

let tareas = [tareaPersonalBase, tareaTrabajoBase, tareaPersonalBase1];

tareas.forEach((item) => {
  // console.log("\tMostrando una tarea");
  // item.mostrarDatos();
});

// JSON -> JavaScript Object Notation

/*
{
    clave1: 1,
    clave2: "2",
    clave3: [],
    clave4: {}
    clave5: function(){}
    clave6: ()->{}
}
*/

let tareaJSON = {
  titulo: "titulo1",
  descripcion: "descripcion 1",
  responsable: "Borja",
  importancia: "Alta",
  prioritaria: false,
  mostrarDatos: () => {
    console.log("Mostrando datos del objecto");
    console.log(`Titulo: ${tareaJSON.titulo}`);
  },
};

let tareaJSON2 = {
  titulo: "titulo1",
  descripcion: "descripcion 1",
  responsable: "Borja",
  importancia: "Alta",
  prioritaria: false,
  mostrarDatos: function () {
    console.log("Mostrando datos");
    console.log(`Titulo: ${this.titulo}`);
  },
};

// tareaJSON2.mostrarDatos();

// object -> JSON (string)
let conversionString = JSON.stringify(tareaJSON2);
console.log(conversionString); // {"titulo":"titulo1","descripcion":"descripcion 1","responsable":"Borja","importancia":"Baja","prioritaria":true}

// JSON(string) -> object
let conversionObjecto = JSON.parse(conversionString);
console.log(conversionObjecto);
