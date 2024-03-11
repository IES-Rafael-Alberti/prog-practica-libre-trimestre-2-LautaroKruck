package org.practicatrim2
import kotlin.random.Random

class AgenteAsalto(nombre: String, arma: Arma) : Agente(nombre, arma) {

    companion object {
        const val MIN_BALAS = 2
        const val MAX_BALAS = 5
        const val INCREMENTO_DANO = 1.2 // 20% más daño
    }

    override fun disparar(): Int {
        if (estado == EstadoAgente.MUERTO) {
            println("$nombre está muerto y no puede disparar.")
            return 0
        }
        val balas = Random.nextInt(MIN_BALAS, MAX_BALAS + 1) // +1 porque el límite superior es exclusivo
        val dañoTotal = (balas * arma.danio * INCREMENTO_DANO).toInt()
        println("$nombre (Agente de Asalto) dispara $balas balas con un daño total de $dañoTotal.")
        return dañoTotal
    }
}
