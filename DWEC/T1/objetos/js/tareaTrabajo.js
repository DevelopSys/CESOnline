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
