// if switch while do while
// for inicio , final , incremento
// let numeros = [123, 4536, 1231, 4568, 9869, 675456456456, 1];
/* for (const key in numeros) {
  console.log(key);
} */
/* for (const element of numeros) {
  console.log(element);
} */
// element -> el elemento que estamos iterando
/* numeros.forEach((element, index) => {
  console.log(`El elemento en la posicion ${index} es ${element}`);
}); */

// sumar();
// console.log(`El retorno de la operacion es ${sumarRetorno(30, 79)}`);
// argumentosInvisibles(2, 5, 12, 123, 432, 345, 576, 69);

function sumar(operadorUno = 15, operadorDos = 10) {
  let sumatorio = operadorDos + operadorUno;
  console.log(
    `La suma del operando ${operadorUno}+${operadorDos} es ${sumatorio}`
  );
}

function sumarRetorno(operadorUno = 15, operadorDos = 10) {
  let sumatorio = operadorDos + operadorUno;
  return sumatorio;
}

function argumentosInvisibles(p1) {
  console.log("Funcion en ejecucion");
  // console.log(p1);
  for (let index = 0; index < arguments.length; index++) {
    const element = arguments[index];
    console.log(element);
  }
}

let funcionFlecha = (p1, p2) => {
  console.log("Realizando multiplicacion");
  if (p1 % 2 == 0 && p2 % 2 == 0) {
    return p1 * p2;
  }
  return -1;
};

// definiendo la funcion
function realizarOperacion(p1, p2, f) {
  f(p1, p2);
}

/* realizarOperacion(4, 5, (o1, o2) => {
  console.log(o1 * o2);
});

realizarOperacion(4, 5, (o1, o2) => {
  console.log(o1 + o2);
}); */
// console.log(funcionFlecha(3, 8));

const participantes = ["borja", "mari carmen", "pablo", "roman", "jose"]; // object -> array
// Object.freeze(participantes) unica forma de que en el array si se puedan quitar ni poner cosas
/* participantes[0] = "";
participantes[participantes.length] = "nuevo";
participantes[10] = "nuevo"; */
/* participantes.push("Juan", "Celia", "Marcos");
console.log(participantes.unshift("Claudia", "Rebeca", "Julia")); */

// filtrar y buscar
let busqueda = participantes.find((item) => {
  return item.length == 5;
});
let filtrado = participantes.filter((item) => {
  return item.length < 5;
});

console.log("Los que cumplen condicion de busqueda son: ");

filtrado.forEach((item) => {
  console.log(item);
});
// console.log(`El resultado de la busqueda es ${busqueda}`);

/* 
console.log(`El participante eliminado es ${participantes.shift()}`);
console.log(`El participante eliminado es ${participantes.shift()}`);
console.log(participantes);
console.log(participantes.length);
 */
