let span = document.querySelector("span");
let div = document.querySelector("#resolucion");
let input = document.querySelector("input");
let boton = document.querySelector("button");
let promesa;

/* Promise -> creadas manualmente o creadas de forma automatica 
    new Promise( ( funcion_resultado_ok, funcion_resultado_fail )=>
        {
            lo que se quiere hacer de forma asincrona logica- tarea pesada
            0-4 -> el resultado es incorrecto -> fail reject -> catch
            5-10 -> el resultado es incorrecto -> ok resolve -> then
        }
    )
*/

let palabras = ["ejemplo 1", "programacion", "desarrollo", "web", "framework"];

/* let promesa = new Promise((res, rej) => {
  setTimeout(() => {
    let aleatorio = Math.random() * 10;
    // console.log(aleatorio);
    if (aleatorio < 5) {
      rej("El numero es demansiado pequeño");
    } else {
      res(aleatorio);
    }
  }, 5000);
}); 

async await

*/

boton.addEventListener("click", () => {
  let promesa = new Promise((res, rej) => {
    setTimeout(() => {
      let valor = input.value;
      let busqueda = palabras.find((element) => {
        return element == valor;
      });
      if (busqueda != undefined) {
        res(busqueda);
      } else {
        rej("Palabra no encontrada");
      }
    }, 2000);
  });

  promesa
    .then((param) => {
      span.innerText = param + " encontrada";
      return 10000;
    })
    .then((param2) => {
      setTimeout(() => {
        span.innerText = "";
      }, param2);
    })
    .catch((err) => {
      div.innerHTML = `<div class="alert alert-warning" role="alert">
  ${err}
</div>`;
    })
    .finally(() => {
      setTimeout(() => {
        div.innerHTML = "";
      }, 6000);
    });
});

// una vez creada la promesa -> analizo el resultado
