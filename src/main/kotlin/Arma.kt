package org.practicatrim2

abstract class Arma(
    protected val nombre: String,
    protected var municion: Int,
    private val municionARestar: Int,
    private val tipoDeMunicion: String
) {
    abstract val danio: Int // Asegura que cada arma defina su propio daño

    companion object {
        var cajaMunicion = 200
    }

    init {
        require(nombre.isNotEmpty()) { "El nombre no puede estar vacío." }
        require(municion >= 0) { "La munición no puede ser negativa." }
        require(municionARestar > 0) { "La munición a restar no puede ser negativa o cero." }
        require(tipoDeMunicion.isNotEmpty()) { "El tipo de munición no puede estar vacío." }
    }

    open fun dispara() {
        if (municion < municionARestar) {
            println("${nombre.uppercase()} intenta disparar pero no tiene suficiente munición.")
            recarga()
        } else {
            municion -= municionARestar
            println("${nombre.uppercase()} dispara. Munición restante: $municion.")
        }
    }

    fun recarga() {
        val municionNecesaria = municionARestar * 2 // Aseguramos suficiente munición para recargar
        if (cajaMunicion >= municionNecesaria) {
            municion += municionNecesaria
            cajaMunicion -= municionNecesaria
            println("${nombre.uppercase()} se ha recargado. Munición actual: $municion. Munición restante en caja: $cajaMunicion.")
        } else {
            println("No hay suficiente munición en la caja para recargar completamente.")
        }
    }

    override fun toString(): String {
        return "Nombre: $nombre, Munición: $municion, Tipo de munición: $tipoDeMunicion, Daño: $danio"
    }
}
