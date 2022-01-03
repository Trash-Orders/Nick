package fr.pots.nick.player;

import com.mojang.authlib.GameProfile;
import org.bukkit.entity.Player;

import java.util.Objects;

/**
 * @author MrCubee
 * @since 1.0
 * @version 1.0
 */
public class DisguiseInfo {

    /**
     * The player in disguise.
     * @since 1.0
     */
    private final Player player;

    /**
     * The profile of his player disguise.
     * @since 1.0
     */
    private final GameProfile disguiseProfile;

    protected DisguiseInfo(final Player player, final GameProfile disguiseProfile) {
        this.player = player;
        this.disguiseProfile = disguiseProfile;
    }

    /**
     * @author MrCubee
     * @since 1.0
     * @return The player in disguise.
     */
    public Player getPlayer() {
        return this.player;
    }
    
    /**
     * @author MrCubee
     * @since 1.0
     * @return The profile of his player disguise.
     */
    public GameProfile getDisguiseProfile() {
        return this.disguiseProfile;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.player);
    }

    @Override
    public boolean equals(Object object) {
        return (object instanceof DisguiseInfo) && object.hashCode() == hashCode();
    }
}
