package world.cepi.luae.wrapper

import net.minestom.server.entity.Player
import org.graalvm.polyglot.HostAccess
import world.cepi.kstom.adventure.asMini

/**
 * Wrapper class for a player in a script object
 */
class ScriptPlayer(val player: Player) {

    @HostAccess.Export
    fun sendMessage(message: String) {
        player.sendMessage(message.asMini())
    }

    @HostAccess.Export
    fun teleport(position: ScriptPosition) {
        player.teleport(position.toPosition())
    }

    @get:HostAccess.Export
    val position = player.position

    @get:HostAccess.Export
    val latency = player.latency

    @get:HostAccess.Export
    @set:HostAccess.Export
    var flying: Boolean
        get() = player.isFlying
        set(value) {
            player.isFlying = value
        }


    @get:HostAccess.Export
    val username: String = player.username

}