package org.practicatrim2

class Agente(val nombre: String, var arma: TipoArma) {
    var vida: Int = 100
        set(value) {
            field = value
            if (value <= 0) {
                estado = EstadoAgente.MUERTO
                muertes++  // Incrementa el contador de muertes cada vez que la vida llega a 0 o menos.
            }
        }

    var estado: EstadoAgente = EstadoAgente.VIVO
        private set

    var muertes: Int = 0        // Añadido para contar las veces que el agente ha muerto.
    var eliminaciones: Int = 0  // Añadido para contar las eliminaciones realizadas por el agente.

    fun disparar(agenteObjetivo: Agente): Int {
        if (estado == EstadoAgente.VIVO) {
            println("$nombre dispara a ${agenteObjetivo.nombre} con $arma causando ${arma.daño} de daño.")
            // Aquí deberías incluir la lógica para determinar si el disparo resulta en una eliminación.
            // Por simplicidad, asumiremos que cada disparo resulta en una eliminación.
            eliminaciones++
            return arma.daño
        } else {
            println("$nombre está muerto y no puede disparar.")
            return 0
        }
    }
}