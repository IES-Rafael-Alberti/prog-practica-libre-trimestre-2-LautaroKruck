package org.practicatrim2

class Pistola(
    municion: Int,
    tipoDeMunicion: String
) : Arma("Pistola", municion, 3, tipoDeMunicion) {
    override val danio = 20
}
