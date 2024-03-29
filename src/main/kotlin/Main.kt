package org.practicatrim2

fun main() {
    println("Iniciando la simulación de la partida...")

    // Crea de armas
    val pistola1 = Pistola(15, "9mm")
    val fusil1 = Fusil(30, "5.56mm")
    val subfusil1 = Subfusil(25, "9mm")
    val pistola2 = Pistola(15, "9mm")
    val fusil2 = Fusil(30, "5.56mm")
    val subfusil2 = Subfusil(25, "9mm")
    val pistola3 = Pistola(15, "9mm")
    val fusil3 = Fusil(30, "5.56mm")

    // Crea agentes
    val agente1 = AgenteAsalto("Agente Alfa 1", pistola1)
    val agente2 = AgenteAsalto("Agente Alfa 2", fusil1)
    val agente3 = AgenteAsalto("Agente Alfa 3", subfusil1)
    val agente4 = AgenteAsalto("Agente Alfa 4", pistola2)
    val agente5 = AgenteAsalto("Agente Omega 1", fusil2)
    val agente6 = AgenteAsalto("Agente Omega 2", subfusil2)
    val agente7 = AgenteAsalto("Agente Omega 3", pistola3)
    val agente8 = AgenteAsalto("Agente Omega 4", fusil3)

    // Crea equipos
    val equipo1 = Equipo("Equipo Alfa")
    val equipo2 = Equipo("Equipo Omega")

    // Asigna agentes a equipos
    equipo1.agregarMiembro(agente1)
    equipo1.agregarMiembro(agente2)
    equipo1.agregarMiembro(agente3)
    equipo1.agregarMiembro(agente4)
    equipo2.agregarMiembro(agente5)
    equipo2.agregarMiembro(agente6)
    equipo2.agregarMiembro(agente7)
    equipo2.agregarMiembro(agente8)

    // Crean e inicia la partida
    println("Rondas para ganar")
    val rondasGan = readln().toInt()
    val partida = Partida(equipo1, equipo2, rondasGan)
    partida.iniciarPartida()

}

