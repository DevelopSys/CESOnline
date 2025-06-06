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

export interface Post {
  id: number;
  title: string;
  body: string;
  tags: string[];
  reactions: Reactions;
  views: number;
  userId: number;
}

export interface Reactions {
  likes: number;
  dislikes: number;
}
