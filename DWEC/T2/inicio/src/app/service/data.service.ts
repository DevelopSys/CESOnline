import { Injectable } from '@angular/core';
import { Usuario } from '../model/clases';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private usuarios: Usuario[] = [];

  constructor() {}

  public getUsuarios() {
    return this.usuarios;
  }

  public addUsuario(usuario: Usuario) {
    this.usuarios.push(usuario);
  }

  public getUsuarioByName(name: string): Usuario | undefined {
    return this.usuarios.find((usuario) => usuario.nombre === name);
  }
}
