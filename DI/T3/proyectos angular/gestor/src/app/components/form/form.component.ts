import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { usuario } from '../../model/usuario';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-form',
  imports: [FormsModule, CommonModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css',
})
export class FormComponent {
  /* binding */
  // logico a grafico

  logo =
    'https://img.freepik.com/vector-gratis/plantilla-banner-contraccion-temporada-regreso-escuela_23-2150558393.jpg';
  nombreApp = 'Gestor CES';
  asignatura = 'Desarrollo interfaces';
  numero = 0;

  nombre: string = '';
  apellido: string = '';
  telefono: string = '';
  fecha: Date = new Date();

  usuarios: usuario[] = [];

  asociarElemento(numero: string) {
    console.log('Pulsado asociar');
    this.numero = Number(numero);
  }

  enviarDatos() {
    // enviar los datos al sistema
    if (
      this.nombre.length == 0 ||
      this.apellido.length == 0 ||
      Number(this.telefono) == 0
    ) {
      Swal.fire({
        title: 'Error',
        text: `Por favor comprueba todos los datos del formulario`,
        icon: 'warning',
        timer: 5000,
      });
    } else {
      Swal.fire({
        title: 'Correcto',
        text: `Usuario con nombre ${this.nombre} agregado correctamente`,
        icon: 'success',
        timer: 3000,
      });

      this.usuarios.push({
        nombre: this.nombre,
        apellido: this.apellido,
        telefono: Number(this.telefono),
        fecha: this.fecha,
      });
      this.limparDatos();
    }
  }

  limparDatos() {
    this.nombre = '';
    this.apellido = '';
    this.telefono = '';
    this.fecha = new Date();
  }
}
