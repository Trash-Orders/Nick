package fr.pots.nick.player;

import com.mojang.authlib.GameProfile;
import fr.mrcubee.mojangapi.MojangAPI;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

/**
 * @author MrCubee
 * @since 1.0
 * @version 1.0
 */
public class Disguise {

    private static final Map<Player, DisguiseInfo> PLAYER_DISGUISE_INFOS = new WeakHashMap<Player, DisguiseInfo>();

    /** This function disguises the player as a desired profile.
     * @author MrCubee
     * @since 1.0
     * @param player The player to disguise.
     * @param profile The desired disguise profile.
     * @return A structure allowing to make the link between the player and his current disguise.
     */
    public static DisguiseInfo disguisePlayer(final Player player, final GameProfile profile) {
        final DisguiseInfo disguiseInfo;

        if (player == null || profile == null)
            return null;
        disguiseInfo = new DisguiseInfo(player, profile);
        /*
            TODO: Use NMS and Packet to disguise the player as another player.
         */
        PLAYER_DISGUISE_INFOS.put(player, disguiseInfo);
        return disguiseInfo;
    }

    /**
     * This function disguises the player as the desired player based on his UUID.
     * @author MrCubee
     * @since 1.0
     * @param player The player to disguise.
     * @param disguiseUUID The desired player costume based on his UUID.
     * @return A structure allowing to make the link between the player and his current disguise.
     */
    public static DisguiseInfo disguisePlayer(final Player player, final UUID disguiseUUID) {
        return disguisePlayer(player, MojangAPI.getFromUUID(disguiseUUID));
    }

    /**
     * This function disguises the player as the desired player based on his name.
     * @author MrCubee
     * @since 1.0
     * @param player The player to disguise.
     * @param disguiseName The desired player costume based on his name.
     * @return A structure allowing to make the link between the player and his current disguise.
     */
    public static DisguiseInfo disguisePlayer(final Player player, final String disguiseName) {
        return disguisePlayer(player, MojangAPI.getFromInput(disguiseName));
    }
}
