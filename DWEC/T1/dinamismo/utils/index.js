// let boton = document.querySelector("#boton-agregar");
// let boton = document.querySelector("button");
// let boton = document.querySelector(".btn");
// let botones = document.querySelectorAll(".btn"); // me retorna una Lista de nodos
// console.log(botones[2]);
// let botonConsultar = document.querySelector("div.contenedor-lista button");
// console.log(botonConsultar);
// let seleccionSelect = document.querySelector("select");
// console.log(seleccionSelect.value);
let select = document.querySelector("select");
let input = document.querySelector("input");
let botonAgregar = document.querySelector("#boton-agregar");
let botonListar = document.querySelector("#boton-listar");
let contadorSpan = document.querySelector("span");

// pulsacion -> click
// cambio -> change
// teclado -> key

botonAgregar.addEventListener("click", (e) => {
  eventoClick(e);
});
botonListar.addEventListener("click", (e) => {
  eventoClick(e);
});

select.addEventListener("change", (e) => {
  console.log("cambio detectado");
  console.log(e);
});

input.addEventListener("keyup", (e) => {
  // console.log("tecla detectada");
  contadorSpan.textContent = e.target.value.length;
});

function eventoClick(event) {
  // como diferencio quien ha generado el evento???????
  console.log("Pulsado boton");
  let botonGererado = event.target;
  if (botonGererado == botonAgregar) {
    console.log("Has pulsado agregar");
  } else if (botonGererado == botonListar) {
    console.log("Has pulsado listar");
  }
}
