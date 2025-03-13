import { Component } from '@angular/core';
import { Usuario } from '../../model/clases';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list',
  standalone: false,
  templateUrl: './list.component.html',
  styleUrl: './list.component.css',
})
export class ListComponent {
  seleccion = 1;
  nombre = '';
  genero = '';
  edad = '';
  fecha: Date = new Date();
  usuarios: Usuario[] = [];

  procesarCambio($event: Event) {
    this.seleccion = parseInt(($event.target as HTMLInputElement).value);
  }
  agregarElemento() {
    // capturar todos los datos del form

    if (
      this.nombre.length > 0 &&
      parseInt(this.edad) > 18 &&
      this.genero.length > 0
    ) {
      let usuario: Usuario = {
        nombre: this.nombre,
        genero: this.genero,
        edad: Number(this.edad),
        fecha: new Date(this.fecha),
      };
      this.usuarios.push(usuario);

      Swal.fire({
        title: 'Exito',
        text: `Usuario con nombre ${this.nombre}, agregado con exito`,
        icon: 'success',
      });
      this.limpiarDatos();
    } else {
      Swal.fire({
        title: 'Error',
        text: `Faltan datos por rellenar`,
        icon: 'warning',
      });
    }
  }

  borrarElemento() {
    this.usuarios.pop();
  }

  limpiarDatos() {
    this.nombre = '';
    this.edad = '';
    this.genero = 'Masculino';
    this.fecha = new Date();
  }

  eliminarUsuario(usuario: Usuario) {
    console.log(
      `Se procede a eliminar al usuario con nombre: ${usuario.nombre}`
    );
  }
}
