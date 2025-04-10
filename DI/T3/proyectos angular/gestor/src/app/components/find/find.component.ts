import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { usuario } from '../../model/usuario';
import { CommonModule } from '@angular/common';
import { UsuariosService } from '../../services/usuarios.service';

@Component({
  selector: 'app-find',
  imports: [FormsModule, CommonModule],
  templateUrl: './find.component.html',
  styleUrl: './find.component.css',
})
export class FindComponent {
  nombreBusqueda: string = '';
  usuarios: usuario[] = [];

  constructor(private servicio: UsuariosService) {}

  realizarBusqueda() {
    this.usuarios = this.servicio.getUsuariosNombre(this.nombreBusqueda);
  }
}
