import { Injectable } from '@angular/core';
import { usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root',
})
export class UsuariosService {
  private usuarios: usuario[] = [];

  constructor() {
    console.log('Servicio construido');
  }

  public addUsuario(usuario: usuario) {
    this.usuarios.push(usuario);
  }

  public getAllUsuarios(): usuario[] {
    return this.usuarios;
  }

  public getUsuariosNombre(nombre: string): usuario[] {
    console.log('LLegando: ' + nombre);
    console.log(this.usuarios);

    return this.usuarios.filter((item) => {
      return item.nombre == nombre;
    });
  }
}
