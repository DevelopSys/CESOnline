package model

class Informe(
    private var titulo: String,
    private var descripcion: String,
    private var departamento: String,
    private var responsable: String? = null,
    private var ubicacion: String? = null,
    ) {
}