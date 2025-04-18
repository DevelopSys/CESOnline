import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css',
})
export class AppComponent {
  genero = 'Selecciona genero';
  nombre = 'Borja';
  apellido = 'Martin';
  edad = 40;
  asignatura = 'Desarrollo cliente';
  title = 'inicio';
  logo =
    'https://angular.dev/assets/images/press-kit/angular_wordmark_gradient.png';

  constructor(private navegador: Router) {}

  mostrarNombre(nombre: string) {
    this.nombre = nombre;
  }

  detectarPulsacion($event: Event) {
    console.log((event?.target as HTMLInputElement).value);
  }

  limpiarDatos() {
    this.nombre = '';
    this.apellido = '';
    this.genero = '';
  }

  navegar() {
    this.navegador.navigate(['detail', 23]);
  }
}
