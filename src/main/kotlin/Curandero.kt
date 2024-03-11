package org.practicatrim2

class Curandero(nombre: String, arma: Arma) : Agente(nombre, arma) {
    private var puedeCurarEstaRonda = true
    private var eliminacionesParaRevivir = 0

    companion object {
        const val ELIMINACIONES_PARA_REVIVIR = 5
    }

    override fun actualizarEliminaciones() {
        super.actualizarEliminaciones()
        eliminacionesParaRevivir++
        if (eliminacionesParaRevivir >= ELIMINACIONES_PARA_REVIVIR) {
            eliminacionesParaRevivir = 0 // Reiniciar contador para la próxima habilidad de revivir
            println("$nombre ha desbloqueado la habilidad de revivir.")
        }
    }

    fun curar(agenteObjetivo: Agente) {
        if (estado != EstadoAgente.VIVO) {
            println("$nombre está muerto y no puede curar.")
            return
        }
        if (!puedeCurarEstaRonda) {
            println("$nombre ya ha usado su habilidad de curar en esta ronda.")
            return
        }
        if (agenteObjetivo.estado == EstadoAgente.VIVO) {
            agenteObjetivo.vida = 100 // Restaurar al máximo de vida
            puedeCurarEstaRonda = false // Se usa la habilidad para esta ronda
            println("${agenteObjetivo.nombre} ha sido curado al máximo de vida por $nombre.")
        } else {
            println("No se puede curar a ${agenteObjetivo.nombre} porque está muerto.")
        }

        eventosDeLaRonda.add(EventoDelJuego.Curacion(this.nombre, agenteObjetivo.nombre))
    }

    fun revivir(agenteObjetivo: Agente) {
        if (estado != EstadoAgente.VIVO) {
            println("$nombre está muerto y no puede revivir a otros.")
            return
        }
        if (eliminacionesParaRevivir < ELIMINACIONES_PARA_REVIVIR) {
            println("$nombre aún no ha desbloqueado la habilidad de revivir.")
            return
        }
        if (agenteObjetivo.estado == EstadoAgente.MUERTO) {
            agenteObjetivo.estado = EstadoAgente.VIVO
            agenteObjetivo.vida = 100 // Restaurar al máximo de vida
            eliminacionesParaRevivir = 0 // Reiniciar contador después de usar la habilidad de revivir
            println("${agenteObjetivo.nombre} ha sido revivido por $nombre.")
        } else {
            println("No se puede revivir a ${agenteObjetivo.nombre} porque ya está vivo.")
        }

        eventosDeLaRonda.add(EventoDelJuego.Curacion(this.nombre, agenteObjetivo.nombre))
    }

    fun reiniciarHabilidadCurar() {
        puedeCurarEstaRonda = true
    }
}
