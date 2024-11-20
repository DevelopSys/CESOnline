// variables
// metodos -> funciones
// public static void main(String[] args){}
// fun metodo_acceso nombreFuncion (nombreArgumento: Tipo): tipoRetorno {}
fun main() {
    // varibles -> primitivo (int, double, float, double, boolean, char ) y complejas (String, Date, Object)
    // String nombre = "valor";
    // int edad = 34;
    // tipoVariable -> mutables (pueden cambiar su valor) se definen con var
    //                  no mutables (no cambian su valor) se definen como val -> final
    // var nombre = "Borja"
    var nombre: String = "Borja"
    lateinit var apellido: String
    var edad = 40
    var correo: String? = null // null
    val DNI = "12345S"
    // Scanner - BufferedReader
    /*println("Por favor introduce tu nombre")
    nombre = readln();
    println("Por favor introduce tu edad")
    edad = readln().toInt()
    println("Por favor introduce el correo")
    correo = readln()
    println("Mi nombre es $nombre y mi edad es $edad, y la cantidad de letras que tiene el nombre es ${nombre.length}")
    println("Mi correo es: ${correo ?: "no existe aun"}")
    println("El numero de letras de mi correo es ${correo?.length ?: "0"}")
    apellido = "Martin"
    println("Mi apellido es $apellido")*/
    // parametros posicioneales
    // saludar(nombre,2)
    // parametros nominales
    // saludar(curso = 1, nombre = "Juan")
    // saludar()
    println("El doble del resultado de operara 4 y 6 es ${suma(4, 6) * 2}")
    println("El del resultado de operar 6 y 4 es ${division(4, 6)}")
    println(sumaFlecha(4,5))

}

var sumaFlecha = { arg1: Int, arg2: Int -> "la suma entre $arg1 y $arg2 es " + arg1.plus(arg2)
}

fun suma(operando1: Int, operando2: Int): Int {
    return operando1 + operando2
}

fun division(operando1: Int, operando2: Int): Double {
    return operando1.toDouble() / operando2
}

fun saludar(nombre: String = "Marcos", curso: Int = 1) {
    println("Bienvenido $nombre al curso de PMDM")
    println("Este es el curso $curso de DAM")
}

// clases