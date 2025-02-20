/* 
CLIENTE(navegador)   <---https--->    SRV (API REST)  <---accion--->         BD(SQL - NOSQL)
                                      php
                                      nodejs
                                      python
                                      java
                                      .net


-------x--------x---
       x--------x

par clave valor 
{
    clave: valor,
    clave2: valor,
    clave3: valor
}
*/

/* fetch("https://dummyjson.com/products")
  .then((res) => res.json())
  .then((res1) => {
    console.log(
      res1.products.forEach((element) => {
        console.log(element.title);
        console.log(element.price);
        console.log(element.stock);
      })
    );
  })
  .catch((err) => {
    console.log(err);
  });
 */
// await - async
let boton = document.querySelector("#botonAgregar");
let botonBorrar = document.querySelector("#botonBorrar");
let lista = document.querySelector("#listaNodos");
let divProductos = document.querySelector("#contenidoProductos");

boton.addEventListener("click", () => {
  /* lista.innerHTML +=
    "<li class='animate__animated animate__bounceIn list-group-item'>Nodo agregado</li>"; */
  let nodo = document.createElement("li");
  nodo.textContent = "Nodo agregado";
  nodo.classList.add(
    "animate__animated",
    "animate__bounceIn",
    "list-group-item"
  );
  //  nodo.className = "animate__animated animate__bounceIn list-group-item"
  // nodo.classList.remove("animate__animated");
  lista.appendChild(nodo);
});

botonBorrar.addEventListener("click", () => {
  // lista.innerHTML = "";
  // lista.remove();

  lista.childNodes[0].classList.add("animate__bounceOut");
  setTimeout(() => {
    lista.removeChild(lista.childNodes[0]);
  }, 700);
});

async function obtenerProductos() {
  let resultado = await fetch("https://dummyjson.com/products");
  let resultadoJSON = await resultado.json();
  resultadoJSON.products.forEach((element) => {
    divProductos.innerHTML += `<div class="col">
          <div class="card h-100 animate__animated animate__fadeIn">
            <img src="${element.images[0]}" class="card-img-top" alt="..." />
            <div class="card-body">
              <h5 class="card-title">${element.title}</h5>
              <p class="card-text">
                ${element.price}
              </p>
              <button class="btn btn-primary">Comprar</button>
            </div>
          </div>
        </div>`;
  }, 2000);
}

obtenerProductos();
