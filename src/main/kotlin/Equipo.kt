package org.practicatrim2

class Equipo(val nombre: String) {
    val miembros = mutableListOf<Agente>()
    var rondasGanadas = 0
    var mejorJugador: Agente? = null

    fun agregarMiembro(agente: Agente) {
        miembros.add(agente)
    }

    // Determina el mejor jugador del equipo basado en eliminaciones.
    private fun actualizarMejorJugador() {
        mejorJugador = miembros.maxByOrNull { it.eliminaciones }
    }

}
