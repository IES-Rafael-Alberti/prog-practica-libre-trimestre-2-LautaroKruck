package org.practicatrim2
import kotlin.random.Random

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
        // Configuración inicial y presentación de equipos como ya tienes
        var rondasJugadas = 0
        while (true) {
            empezarRonda() // Presupone que el usuario presiona Enter para continuar
            rondasJugadas++

            // Condición de victoria o empate
            if (equipo1.rondasGanadas >= 10 || equipo2.rondasGanadas >= 10) {
                if (Math.abs(equipo1.rondasGanadas - equipo2.rondasGanadas) >= 2 || rondasJugadas >= 20) {
                    break // Salir del bucle, finalizar la partida
                }
            }
        }
        mostrarResultadosFinales() // Muestra los resultados finales
    }

    fun empezarRonda() {
        println("\nPresiona Enter para comenzar la siguiente ronda...")
        readLine() // Espera que el usuario presione Enter

        // Reiniciar habilidades de curación de todos los Curanderos en ambos equipos
        equipo1.miembros.filterIsInstance<Curandero>().forEach { it.reiniciarHabilidadCurar() }
        equipo2.miembros.filterIsInstance<Curandero>().forEach { it.reiniciarHabilidadCurar() }

        simularRonda()
    }

    fun simularRonda() {
        // Simula el resultado de la ronda (esto es solo un ejemplo y debe ser ajustado según tu lógica de juego)
        val ganadorRonda = if (Random.nextBoolean()) equipo1 else equipo2
        ganadorRonda.rondasGanadas++

        println("El ganador de la ronda es ${ganadorRonda.nombre}. Rondas ganadas: ${ganadorRonda.rondasGanadas}")

        // Actualizar historial del equipo con datos ficticios por ahora
        ganadorRonda.actualizarHistorial(1, Random.nextInt(1, 5)) // Ejemplo: 1 ronda ganada, entre 1 y 4 eliminaciones
    }

    fun obtenerEquipoGanador(): String {
        return when {
            equipo1.rondasGanadas >= 10 && equipo1.rondasGanadas - equipo2.rondasGanadas >= 2 ->
                "El ganador de la partida es ${equipo1.nombre} con ${equipo1.rondasGanadas} rondas ganadas."
            equipo2.rondasGanadas >= 10 && equipo2.rondasGanadas - equipo1.rondasGanadas >= 2 ->
                "El ganador de la partida es ${equipo2.nombre} con ${equipo2.rondasGanadas} rondas ganadas."
            equipo1.rondasGanadas == equipo2.rondasGanadas ->
                "La partida terminó en empate con ambos equipos ganando ${equipo1.rondasGanadas} rondas."
            else -> "La partida aún no ha determinado un ganador."
        }
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
