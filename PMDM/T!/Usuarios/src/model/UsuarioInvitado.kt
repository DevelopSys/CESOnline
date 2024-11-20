package model

class UsuarioInvitado(nombre: String, apellido: String, correo: String, private var apodo: String) :
    Usuario(nombre, apellido, correo), Registrable {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Apodo: $apodo")
        println("Edad: ${getEdad() ?:"Este usuario no tiene edad"}")
    }

    override fun registrar(numero: Int) {

    }
}