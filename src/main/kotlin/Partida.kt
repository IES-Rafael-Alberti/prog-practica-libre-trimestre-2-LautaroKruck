package org.practicatrim2

class Partida(private val equipo1: Equipo, private val equipo2: Equipo) {

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
    }

    fun empezarRonda() {
        println("\nPresiona Enter para comenzar la siguiente ronda...")
        readLine() // Espera que el usuario presione Enter
        // Lógica para simular la ronda
    }

    fun mostrarResultadosFinales() {
        println("\nLa partida ha finalizado.")
        // Aquí deberías añadir la lógica para mostrar los resultados de cada equipo
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
