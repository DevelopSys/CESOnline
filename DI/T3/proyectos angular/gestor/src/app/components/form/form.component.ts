import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { usuario } from '../../model/usuario';
import { CommonModule } from '@angular/common';
import { UsuariosService } from '../../services/usuarios.service';

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
  busqueda = '';
  usuariosBusqueda?: usuario[];
  selectOpcion = '1';
  selectOptionNumber = 1;

  nombre: string = '';
  apellido: string = '';
  telefono: string = '';
  fecha: Date = new Date();

  constructor(private usuariosService: UsuariosService) {}

  asociarElemento(numero: string) {
    console.log('Pulsado asociar');
    this.numero = Number(numero);
  }

  realizarBusqueda() {
    /* this.usuariosBusqueda = this.usuarios.filter((usuario) => {
      // return el usuario que cumpla la condicion
      return usuario.nombre == this.busqueda;
    });

    setTimeout(() => {
      this.usuariosBusqueda = undefined;
    }, 5000); */
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

      this.usuariosService.addUsuario({
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

  cambioSelect($event: Event) {
    console.log(typeof ($event.target as HTMLInputElement).value);
    this.selectOptionNumber = Number(($event.target as HTMLInputElement).value);
  }
}
