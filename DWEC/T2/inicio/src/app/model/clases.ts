export interface Usuario {
  nombre: string;
  edad: number;
  genero: string;
  fecha: Date;
}

export class Usuario2 {
  constructor(private nombre: string) {}

  mostrarDatos() {}
}
