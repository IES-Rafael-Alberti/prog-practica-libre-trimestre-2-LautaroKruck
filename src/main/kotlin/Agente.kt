package org.practicatrim2
import kotlin.random.Random

open class Agente(val nombre: String, var arma: Arma) {
    var vida: Int = 100
    var estado: EstadoAgente = EstadoAgente.VIVO
    var eliminaciones: Int = 0
    var muertes: Int = 0

    companion object {
        const val MIN_BALAS = 0
        const val MAX_BALAS = 5
    }

    fun actualizarEliminaciones() {
        eliminaciones++
    }

    fun actualizarMuertes() {
        muertes++
    }

    open fun disparar(): Int {
        if (estado == EstadoAgente.MUERTO) {
            println("$nombre está muerto y no puede disparar.")
            return 0
        }
        val balas = Random.nextInt(MIN_BALAS, MAX_BALAS + 1) // Incluye el máximo en el rango
        println("$nombre dispara $balas balas.")
        return balas
    }
    fun dispararA(agenteObjetivo: Agente) {
        if (estado == EstadoAgente.MUERTO) {
            println("$nombre está muerto y no puede disparar.")
            return
        }

        val balasDisparadas = disparar() // Utiliza la función disparar existente para obtener el número de balas
        val dañoTotal = balasDisparadas * arma.danio
        agenteObjetivo.recibirDanio(dañoTotal)
    }

    fun recibirDanio(cantidad: Int) {
        vida -= cantidad
        if (vida <= 0) {
            vida = 0
            estado = EstadoAgente.MUERTO
            println("$nombre ha muerto.")
        } else {
            println("$nombre ha recibido $cantidad puntos de daño. Vida restante: $vida.")
        }
    }

    override fun toString(): String {
        return "Nombre: $nombre, Vida: $vida, Eliminaciones: $eliminaciones, Muertes: $muertes, Arma: $arma, Estado: $estado"
    }
}
