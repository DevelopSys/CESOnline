// variables constantes
const serialUID = 123123123;
/* // variables globales
if (true) {
  // var titulo = "variables en JS";
  // variables de bloque
  let nombre = "Borja";
} */

// NO TIPADO -> TS : TIPADO

let nombre = "Borja"; // string
let edad = 40; // number
let altura = 1.7; // number
let experiencia = true; // boolean
const trabajo = []; // array Object
let sinDefinir = null; // null Object
let cosa; // undefined
// NaN -> not a number
// nombre typeof
// console.log("Nombre: " + nombre + " edad: " + edad);
console.log(`Nombre: ${nombre} edad: ${edad}`);
// muestra datos sin poder interactuar
// alert(`Nombre: ${nombre}\n edad: ${edad}`);
// mustra un mensaje para poder introducir datos
setTimeout(() => {
  Swal.fire({
    title: "Perfecto!",
    text: "Has realizado tu primero dialogo personalizado",
    icon: "success",
    confirmButtonText: "Cerrar",
  });
  /* let nombre = prompt("Por favor introduce tu nombre");
  console.log(nombre);
  if (nombre.length == 0) {
    alert(`El nombre introducido es ${nombre}`);
  } else {
    alert("Algo ha ido mal, por favor introduce de nuevo");
  } */
  /* let respuesta = confirm("Estas seguro que quieres continuar");
  if (respuesta) {
    alert("Has contestado que si, procedemos a realizar la operacion");
  } else {
    alert("Has contestado que no,cancelamos la operacion");
  } */
  // introduca dos operados en sendos prompt y luego se muestre en un alert el resultado
  /* let numero1 = Number(prompt("Introduce numero 1"));
  let numero2 = Number(prompt("Introduce numero 2"));
  if (!isNaN(numero1 + numero2)) {
    alert(`El resultado de la suma es ${numero1 + numero2}`);
  } else {
    alert(`Alguno de los numeros es incorrecto`);
  } */
}, 1000);

// calculadora
// analisis de una frase -> sweet alerts -> alerts

// if switch for while do while foreach filter find
// [] -> Arraylist
