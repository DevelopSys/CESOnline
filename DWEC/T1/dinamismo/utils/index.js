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
let botonBorrar = document.querySelector("#boton-borrar");
// let listaElementos = document.querySelector("#lista-elementos");
let contenedorCartas = document.querySelector("div.contenedor-cartas div.row");
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
botonBorrar.addEventListener("click", (e) => {
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
  let botonGererado = event.target;
  if (botonGererado == botonAgregar) {
    // inner HTML ->
    // append -> agrega al final un nodo
    contenedorCartas.innerHTML += `<div class="col">
    <div class="card">
      <img src="..." class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">${input.value}</h5>
        <button class= "btn btn-success">Completada</button>
      </div>
    </div>
  </div>`;

    // && listaElementos.innerHTML += `<li class="list-group-item animate__animated animate__fadeInDown">${input.value} - ${select.value}</li>`;
  } else if (botonGererado == botonBorrar) {
    // listaElementos.innerHTML = "";
    /* listaElementos.childNodes.forEach((element) => {
      element.remove();
    }); */
    // listaElementos.removeChild(listaElementos.childNodes[0]);
  } else if (botonGererado == botonListar) {
    let hijos = listaElementos.childNodes;
    hijos.forEach((element) => {
      console.log(element.textContent);
    });
  }
}
