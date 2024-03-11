package org.practicatrim2

class Ronda(private val equipo1: Equipo, private val equipo2: Equipo) {

    fun mostrarResultadosRonda(numeroRonda: Int) {
        println("Ronda $numeroRonda finalizada.")
        // Aquí iría la lógica para mostrar las eliminaciones de la ronda.
        println("Equipo 1 - Rondas Ganadas: ${equipo1.rondasGanadas}")
        println("Equipo 2 - Rondas Ganadas: ${equipo2.rondasGanadas}")
        // Suponiendo que cada equipo tiene una propiedad rondasGanadas que se actualiza en otro lugar.

        mostrarHistorialDeLaRonda()
    }
    fun mostrarHistorialDeLaRonda() {
        eventosDeLaRonda.forEach { evento ->
            when (evento) {
                is EventoDelJuego.Eliminacion -> println("${evento.agresor} ha eliminado a ${evento.victima}")
                is EventoDelJuego.Curacion -> println("${evento.curandero} ha curado a ${evento.objetivo}")
                is EventoDelJuego.Revivir -> println("${evento.curandero} ha revivido a ${evento.objetivo}")
            }
        }
        eventosDeLaRonda.clear() // Limpiar para la siguiente ronda
    }


}

sealed class EventoDelJuego {
    data class Eliminacion(val agresor: String, val victima: String): EventoDelJuego()
    data class Curacion(val curandero: String, val objetivo: String): EventoDelJuego()
    data class Revivir(val curandero: String, val objetivo: String): EventoDelJuego()
    // Añade más tipos de eventos según necesites
}

// Ejemplo de cómo podrías almacenar y acceder a los eventos
val eventosDeLaRonda = mutableListOf<EventoDelJuego>()
