import { Component } from '@angular/core';
import { DataService } from '../../service/data.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-form',
  standalone: false,
  templateUrl: './form.component.html',
  styleUrl: './form.component.css',
})
export class FormComponent {
  nombre = '';
  genero = '';
  edad = '';
  fecha: Date = new Date();

  constructor(private dataService: DataService) {}

  agregarElemento() {
    // donde tengo que guardar el usuario????

    if (this.nombre.length > 0 && this.genero.length > 0) {
      this.dataService.addUsuario({
        nombre: this.nombre,
        genero: this.genero,
        edad: Number(this.edad),
        fecha: this.fecha,
      });
      this.limpiarDatos();
      Swal.fire({
        icon: 'success',
        title: 'Usuario agregado correctamente',
        showConfirmButton: false,
        timer: 1500,
      });

      /* localStorage.setItem(
        'usuarios',
        JSON.stringify(this.dataService.getUsuarios())
      ); */
    } else {
      Swal.fire({
        icon: 'warning',
        title: 'Error en los datos',
        showConfirmButton: false,
        timer: 1500,
      });
    }
  }

  limpiarDatos() {
    this.nombre = '';
    this.edad = '';
    this.genero = '';
    this.fecha = new Date();
  }
}
