import { Component, inject } from '@angular/core';
import { usuario } from '../../model/usuario';
import { CommonModule } from '@angular/common';
import { UsuariosService } from '../../services/usuarios.service';

@Component({
  selector: 'app-list',
  imports: [CommonModule],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css',
})
export class ListComponent {
  usuarios: usuario[] = [];

  private servicio = inject(UsuariosService);

  constructor() {
    this.usuarios = this.servicio.getAllUsuarios();
    console.log(this.servicio.getAllUsuarios());
  }
}
