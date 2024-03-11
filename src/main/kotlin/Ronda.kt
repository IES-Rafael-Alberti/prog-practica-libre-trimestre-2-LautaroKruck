package org.practicatrim2

class Ronda(private val equipo1: Equipo, private val equipo2: Equipo) {

    fun mostrarResultadosRonda(numeroRonda: Int) {

        mostrarHistorialDeLaRonda()

        println("Ronda $numeroRonda finalizada.")

        println("Equipo 1 - Rondas Ganadas: ${equipo1.rondasGanadas}")
        println("Equipo 2 - Rondas Ganadas: ${equipo2.rondasGanadas}")


    }
    fun mostrarHistorialDeLaRonda() {
        eventosDeLaRonda.forEach { evento ->
            when (evento) {
                is HistorialRonda.Danio -> println("${evento.agresor} le ha quitado ${evento.danio} de vida a ${evento.victima}")
                is HistorialRonda.Eliminacion -> println("${evento.agresor} ha eliminado a ${evento.victima}")
                is HistorialRonda.Curacion -> println("${evento.curandero} ha curado a ${evento.objetivo}")
                is HistorialRonda.Revivir -> println("${evento.curandero} ha revivido a ${evento.objetivo}")
            }
        }
        eventosDeLaRonda.clear() // Limpiar para la siguiente ronda
    }
}

sealed class HistorialRonda {
    data class Eliminacion(val agresor: String, val victima: String): HistorialRonda()
    data class Danio(val agresor: String, val danio: Int, val victima: String): HistorialRonda()
    data class Curacion(val curandero: String, val objetivo: String): HistorialRonda()
    data class Revivir(val curandero: String, val objetivo: String): HistorialRonda()

}

val eventosDeLaRonda = mutableListOf<HistorialRonda>()
