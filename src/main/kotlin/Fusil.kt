package org.practicatrim2

class Fusil(
    municion: Int,
    tipoDeMunicion: String
) : Arma("Fusil", municion, 1, tipoDeMunicion) {
    override val danio = 30
}

