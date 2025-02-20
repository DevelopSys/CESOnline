// no tenemos tipos
/* const COD_CENTRO = "000001A";
let boton = document.querySelector("#botonIniciar");
let nombre = "Borja"; // string
let apellido = "Martin"; // string
let edad = 18; // number
let altura = 1.74; // number
let experiencia = true; // boolean
let asignaturas = []; // Object Array
let direccion; // undefined
let ciudad = null; // null

boton.textContent = "Iniciar";
boton.addEventListener("click", () => {
  Swal.fire({
    title: `Quieres, ${nombre}, hacer una tarea secundaria`,
    showDenyButton: true,
    showCancelButton: true,
    confirmButtonText: "SI",
    denyButtonText: `NO`,
  }).then((result) => {
    if (result.isConfirmed) {
      if (edad > 18) {
        Swal.fire("Accion secundaria", "", "success");
      } else {
        Swal.fire("Accion secundaria no completada", "", "success");
      }
    } else if (result.isDenied) {
      Swal.fire("Accion denegada", "", "info");
    }
  });
}); */
// NaN -> NotANumber -> pasar un string -> number -> NaN
// console.log("Mi nombre es " + nombre + " y mi apellido es " + apellido);
// console.log(`Mi nombre es ${nombre} y mi apellido es ${apellido}`);
/* alert(
  `Pagina realizada por ${nombre} ${apellido}, el cual es mayor de edad ${
    edad > 18
  }`
); */
/* let acuerdo = confirm("por favor dime si estas deacuerdo"); */
/* let dato = prompt("Por favor introduce tu nombre"); */
// console.log(dato);

/* 
guardar elementos de HTML en variables JS
querySelector(#id o tag o .class o todo junto) -> obtengo el 1er elemento que coincida con la busqueda -> HTMLElement
querySelectorAll(#id o tag o .class o todo junto) -> obtengo todos los elementos que coincidan con la busqueda -> NodeList
*/

let inputNombre = document.querySelector("#inputNombre");
let inputApellido = document.querySelector("#inputApellido");
let inputTelefono = document.querySelector("#inputTelefono");
let inputCorreo = document.querySelector("#inputCorreo");
let selectProfesion = document.querySelector("#selectProfesion");
let botonEnviar = document.querySelector("#botonEnviar");
let botonVaciar = document.querySelector("#botonVaciar");
let lista = document.querySelector("div.row ul");

// let input = document.querySelector("div.row input.mt-3");
botonEnviar.addEventListener("click", (event) => {
  // console.log(event.target.textContent);
  /*   console.log(inputNombre.value);
  console.log(inputApellido.value);
  console.log(inputCorreo.value);
  console.log(inputTelefono.value);
  console.log(selectProfesion.value); */
  /* pulso el boton y se agregar un nodo li dentro de la lista con el nombre */
  agregarNodo(inputNombre.value);
});

botonVaciar.addEventListener("click", () => {
  let elementoBorrar = document.querySelector("div.row ul li");
  elementoBorrar.classList.remove("animate__fadeInRight");
  elementoBorrar.classList.add("animate__tada");
  setTimeout(() => {
    elementoBorrar.classList.remove("animate__tada");
    elementoBorrar.classList.add("animate__fadeOutRight");
    setTimeout(() => {
      lista.removeChild(elementoBorrar);
    }, 700);
  }, 700);
});

function agregarNodo(nombre) {
  // agregar nodo a la lista <li> nombre </li>
  console.log(`Procedo a agregar nodo ${nombre}`);
  // lista.innerHTML += `<li class="animate__animated animate__fadeInRight list-group-item">${nombre}</li>`;
  // creo un li, le pongo la clase, le pongo el texto, lo agrego a la lista
  let nodoLI = document.createElement("li");
  nodoLI.className = "animate__animated animate__fadeInRight list-group-item";
  /* nodoLI.classList.add(
    "animate__animated",
    "animate__fadeInRight",
    "list-group-item"
  ); */
  nodoLI.textContent = nombre;
  lista.append(nodoLI);
}
