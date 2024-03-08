package org.practicatrim2

fun main() {
    println("Iniciando la simulación de la partida de Valorant...")

    // Suponiendo que ya has creado los equipos y agentes como se mostró anteriormente.
    val equipo1 = Equipo("Equipo Alfa")
    val equipo2 = Equipo("Equipo Omega")
    // Agregar miembros a los equipos...
    equipo1.agregarMiembro(Agente("Agente 1", TipoArma.PISTOLA))
    equipo1.agregarMiembro(Agente("Agente 2", TipoArma.RIFLE))
    equipo2.agregarMiembro(Agente("Agente 3", TipoArma.FRANCOTIRADOR))
    equipo2.agregarMiembro(Agente("Agente 4", TipoArma.PISTOLA))

    // Instanciar la partida y pasarle los equipos
    val partida = Partida(equipo1, equipo2)

    // Iniciar partida (muestra descripción y equipos)
    partida.iniciarPartida()

    // Variables para controlar las rondas jugadas y si continuar la partida
    var rondasJugadas = 0
    var continuar = true

    while (continuar) {
        println("\nPresiona Enter para comenzar la siguiente ronda...")
        readLine() // Espera que el usuario presione Enter

        // Simular ronda
        rondasJugadas++
        println("Ronda $rondasJugadas en curso...")
        // Aquí podrías llamar a un método en la clase Partida o Ronda para simular la lógica de la ronda

        // Verificar condiciones de victoria
        if (equipo1.rondasGanadas >= 10 || equipo2.rondasGanadas >= 10) {
            if (Math.abs(equipo1.rondasGanadas - equipo2.rondasGanadas) >= 2 || rondasJugadas == 20) {
                continuar = false
            }
        }

        // Aquí deberías actualizar el estado de la partida basado en los resultados de la ronda
    }

    // Mostrar resultados finales
    partida.mostrarResultadosFinales()
}
