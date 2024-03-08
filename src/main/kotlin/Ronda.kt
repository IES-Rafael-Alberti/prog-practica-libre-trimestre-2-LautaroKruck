package org.practicatrim2

class Ronda(private val equipo1: Equipo, private val equipo2: Equipo) {

    fun mostrarResultadosRonda(numeroRonda: Int) {
        println("Ronda $numeroRonda finalizada.")
        // Aquí iría la lógica para mostrar las eliminaciones de la ronda.
        println("Equipo 1 - Rondas Ganadas: ${equipo1.rondasGanadas}")
        println("Equipo 2 - Rondas Ganadas: ${equipo2.rondasGanadas}")
        // Suponiendo que cada equipo tiene una propiedad rondasGanadas que se actualiza en otro lugar.
    }

}