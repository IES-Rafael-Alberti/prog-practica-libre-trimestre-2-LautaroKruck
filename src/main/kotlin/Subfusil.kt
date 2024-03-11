package org.practicatrim2

class Subfusil(
    municion: Int,
    tipoDeMunicion: String
) : Arma("Subfusil", municion, 2, tipoDeMunicion) {
    override val danio = 25
}
