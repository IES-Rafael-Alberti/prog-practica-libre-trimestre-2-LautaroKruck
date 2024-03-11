package org.practicatrim2
import kotlin.math.abs
import kotlin.random.Random

class Partida(private val equipo1: Equipo, private val equipo2: Equipo, var rondasAGanar: Int, var rondasJugadas: Int = 0, ) {

    fun iniciarPartida() {
        println("Bienvenido a la simulación de la partida.")
        println("La partida es entre dos equipos, donde deberán eliminarse entre sí. El primer equipo en ganar 10 rondas gana la partida. En caso de empate 9-9, se requiere una diferencia de dos rondas para ganar.")

        // Mostrar información de los equipos y sus miembros
        println("\nEquipo 1:")
        equipo1.miembros.forEach { agente ->
            println("Agente: ${agente.nombre}, Arma: ${agente.arma}")
        }

        println("\nEquipo 2:")
        equipo2.miembros.forEach { agente ->
            println("Agente: ${agente.nombre}, Arma: ${agente.arma}")
        }

        while (true) {
            empezarRonda()
            rondasJugadas++

            combrobarDesempate()
        }
        mostrarResultadosFinales()
    }

    private fun combrobarDesempate(): Boolean{
        return if (equipo1.rondasGanadas >= rondasAGanar-1 || equipo2.rondasGanadas >= rondasAGanar-1) {
            if (abs(equipo1.rondasGanadas - equipo2.rondasGanadas) >= 2 || rondasJugadas >= 20) {
                false
            } else true
        } else true
    }

    fun empezarRonda() {
        println("\nPresiona Enter para comenzar la siguiente ronda...")
        readln()

        equipo1.miembros.filterIsInstance<Curandero>().forEach { it.reiniciarHabilidadCurar() }
        equipo2.miembros.filterIsInstance<Curandero>().forEach { it.reiniciarHabilidadCurar() }

        simularRonda()
    }

    fun simularRonda() {



        println("El ganador de la ronda es ${ganadorRonda.nombre}. Rondas ganadas: ${ganadorRonda.rondasGanadas}")


    }

    fun obtenerEquipoGanador() {

    }

    fun mostrarResultadosFinales() {
        println("\nLa partida ha finalizado.")

        println(obtenerEquipoGanador())

        mostrarTablaClasificacion()
    }

    fun mostrarTablaClasificacion() {
        val todosLosAgentes = equipo1.miembros + equipo2.miembros
        val agentesOrdenados = todosLosAgentes.sortedByDescending { it.eliminaciones }

        println("\nTabla de Clasificación:")
        agentesOrdenados.forEach { agente ->
            println("${agente.nombre} - Eliminaciones: ${agente.eliminaciones}, Muertes: ${agente.muertes}, Equipo: ${obtenerNombreEquipo(agente)}")
        }
    }

    private fun obtenerNombreEquipo(agente: Agente): String {
        return if (equipo1.miembros.contains(agente)) "Equipo 1" else "Equipo 2"
    }
}
