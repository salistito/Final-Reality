package com.github.salistito.finalreality.model.weapon;

import com.github.salistito.finalreality.model.character.player.Knight;
import com.github.salistito.finalreality.model.character.player.Thief;

import java.util.Objects;
/**
 * A class that holds all the information of a Sword.
 *
 * @author Sebastián Salinas Rodriguez.
 */
public class Sword extends AbstractWeapon {
    /**
     * Creates a new Sword
     *
     * @param name
     *     the sword's name
     * @param damage
     *     the sword's damage
     * @param  weight
     *     the sword's weight
     */
    public Sword(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    // Sword specialization:

    /**
     * The sword will be equipped on a knight.
     */
    @Override
    public void equipToKnight(Knight knight) {
        knight.setEquippedWeapon(this);
    }

    /**
     * The sword will be equipped on a thief.
     */
    @Override
    public void equipToThief(Thief thief) {
        thief.setEquippedWeapon(this);
    }

    /**
     * toString method, returns String representing the class of this weapon
     */
    @Override
    public String toString() {return "Sword";}

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sword)) {
            return false;
        }
        final Sword weapon = (Sword) o;
        return getName().equals(weapon.getName()) && getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(Sword.class, getName(), getDamage(), getWeight());
    }
}
