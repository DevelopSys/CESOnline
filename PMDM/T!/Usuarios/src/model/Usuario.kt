package model

open class Usuario(private var nombre: String,private var apellido: String,private var correo: String) {

    // constructores por defecto 1 (vacio)
    /*
    constructores primarios -> todo objeto tiene que cumplir
    constructores secundarios -> si quiero info adicional, SIEMPRE basandose en el primario
     */
    /*
    public Usuario(){}
    public Usuario(int edad){}
    public Usuario(String nombre){
        this.nombre = nombre
    }
    public Usuario(String nombre, int edad){}
     */
    // atributos
    // metodos - metodos getter / setter
    // edad, direccion
    private var edad: Int? = null
    var direccion: String? = null

    constructor(nombre: String, apellido: String, correo: String, edad: Int): this(nombre, apellido, correo){
        this.edad = edad
    }
    constructor(nombre: String, apellido: String, correo: String, direccion: String): this(nombre,apellido,correo){
        this.direccion = direccion
    }

    open fun mostrarDatos(){
        println("Nombre $nombre")
        println("Apellido $apellido")
        println("Correo $correo")
    }

    fun getNombre(): String{
        return this.nombre
    }

    fun setNombre(nombre: String){
        this.nombre = nombre
    }
    fun getEdad(): Int?{
        return this.edad
    }

}