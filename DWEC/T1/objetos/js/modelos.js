class tarea {
  // propiedades
  titulo;
  descipcion;
  importancia;
  prioritaria;
  // constructores
  constructor(titulo, descripcion, importancia, prioridad) {
    console.log("Iniciando el proceso de creacion de la tarea");
    this.titulo = titulo;
    this.descipcion = descripcion;
    this.importancia = importancia;
    this.prioritaria = prioridad;
  }
  // metodos - getter - setter
  mostrarDatos() {
    console.log(`EL titulo es ${this.titulo}`);
    console.log(`La descripcion es ${this.descipcion}`);
    console.log(`La importancia es ${this.importancia}`);
    if (this.prioritaria) {
      console.log("La tarea es prioritaria");
    }
  }

  get getTitulo() {
    return this.titulo;
  }
  // public String getTitulo(){ return this.titulo }
  set setTitulo(titulo) {
    this.titulo = titulo;
  }
  // public void setTitulo(String titulo){ this.titulo = titulo }
}

class tareaPersonal extends tarea {
  // titulo, descripcion, importancia, prioritaria
  // metodos
  fecha;
  constructor(titulo, descripcion, importancia, prioridad, fecha) {
    super(titulo, descripcion, importancia, prioridad);
    this.fecha = fecha;
  }

  mostrarDatos() {
    super.mostrarDatos();
    console.log(`Fecha: ${this.fecha}`);
  }
}

class tareaTrabajo extends tarea {
  // titulo, descripcion, importancia, prioritaria
  responsable;
  constructor(titulo, descripcion, importancia, prioridad, responsable) {
    super(titulo, descripcion, importancia, prioridad);
    this.responsable = responsable;
  }

  mostrarDatos() {
    super.mostrarDatos();
    console.log(`Responsble ${this.responsable}`);
  }
}
