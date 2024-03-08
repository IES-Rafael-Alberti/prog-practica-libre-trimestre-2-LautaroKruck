package org.practicatrim2

class Equipo(val nombre: String) {
    val miembros = mutableListOf<Agente>()
    var rondasGanadas = 0
    var agentesEliminadosTotal = 0
    var mejorJugador: Agente? = null

    fun agregarMiembro(agente: Agente) {
        miembros.add(agente)
    }

    // Actualiza el historial del equipo después de cada ronda o partida.
    fun actualizarHistorial(rondasGanadas: Int, agentesEliminados: Int) {
        this.rondasGanadas += rondasGanadas
        this.agentesEliminadosTotal += agentesEliminados
        actualizarMejorJugador()
    }

    // Determina el mejor jugador del equipo basado en eliminaciones.
    private fun actualizarMejorJugador() {
        mejorJugador = miembros.maxByOrNull { it.eliminaciones }
    }

    // Puedes añadir más lógica para gestionar las estadísticas del equipo y rendimiento de los miembros.
}
