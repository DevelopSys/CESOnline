/* // promesa -> acciones que van en paralelo al hilo principal


// res como rej son funciones

let parrafoResultado = document.querySelector("p");
let promesa = new Promise((res, rej) => {
  // logica de la funcion
  setTimeout(() => {
    let aleatorio = Math.random() * 11;
    if (aleatorio >= 5) {
      res(`Numero correcto ${aleatorio}`);
    } else {
      rej("Numero incorrecto");
    }
  }, 3000);
});

// tratar la promesa
// resultado ok -> then
// resultado fail -> catch
promesa
  .then((ok) => {
    parrafoResultado.innerText = ok;
  })
  .catch((fail) => {
    parrafoResultado.innerText = fail + " promesa incorrecta";
  })
  .finally(() => {
    setTimeout(() => {
      parrafoResultado.innerText += ". Promesa terminada";
    }, 2000);
  });
 */

let lista = document.querySelector("ul");
let resultado = document.querySelector("#resultadoProductos");
let productosComprados = [];

fetch("https://dummyjson.com/products")
  .then((ok) => ok.json())
  .then((ok1) => {
    // console.log(ok1.products[7].reviews[0].comment);
    ok1.products.forEach((item) => {
      // lista.innerHTML += `<li class='list-group-item'>${item.title}</li>`;
      resultado.innerHTML += `<div class="col">
          <div class="card">
            <img src="${item.thumbnail}" style="width:50%; text.align:center" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">${item.title}</h5>
              <p class="card-text">${item.description}</p>
            </div>
            <button class="btn btn-primary" onClick()="comprar(item)" >Comprar</button>
          </div>
        </div>`;
    });
  })
  .catch((err) => {
    console.log("Error en conexi");
    console.log(err);
  });

function comprar(item) {
  console.log(`Producto comprado correctamente ${item.price}`);
  productosComprados.push(item);
}

function validarCompra() {
  console.log("Estas seguro que quieres comprar todos los productos");
}
