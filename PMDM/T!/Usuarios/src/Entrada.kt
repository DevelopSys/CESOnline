import model.Informe
import model.Usuario
import model.UsuarioInvitado

val listado: ArrayList<Usuario> = ArrayList()

fun main() {
    println("Bienvenido al programa de gestion de usuarios")
    insertarUsuario()
}

fun insertarUsuario() {
    val invitado: UsuarioInvitado = UsuarioInvitado("Borja", "Martin", "correo@invitado.es", "bmartin")
    invitado.mostrarDatos()
    val usuario = Usuario(nombre = "Borja", apellido = "Martin", "correo@gmail.com")
    // borja, martin, correo@gmail.com, null, null
    usuario.mostrarDatos()
    val usuario1 = Usuario(nombre = "Borja", apellido = "Martin", "correo@gmail.com", 4)
    // borja, martin, correo@gmail.com, 4, null
    val usuario2 = Usuario(nombre = "Borja", apellido = "Martin", "correo@gmail.com", "Madrid")
    // borja, martin, correo@gmail.com, null, Madrid
    val informe: Informe =
        Informe(
            "Titulo", "Descripcion", "departamento",
            ubicacion = "planta1", responsable = "responsable"
        )
    listado.add(usuario)
    listado.add(usuario1)
    listado.add(usuario2)
    listado.add(usuario2)
    listado.add(invitado)

    // listado[1] = Usuario("","","")
    /*for ( i in 0..listado.size-1  ){
        listado[i]
    }*/
    listado.forEach {
        it.mostrarDatos()
    }

    val listaFiltrada: List<Usuario> = listado.filter {
        it.getEdad() == 24
    }

    val usuarioFiltado: Usuario? = listado.find {
        it.getEdad() == 35
    }

    // val lista = arrayOf("asd","asd","asd")
    val lista = arrayListOf("asd","asd","asd")


}