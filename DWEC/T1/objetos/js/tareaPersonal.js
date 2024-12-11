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
