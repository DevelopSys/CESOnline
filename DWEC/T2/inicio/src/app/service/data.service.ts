import { Injectable } from '@angular/core';
import { Usuario } from '../model/clases';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private usuarios: Usuario[] = [];

  constructor(private moduloHTTP: HttpClient) {}

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
