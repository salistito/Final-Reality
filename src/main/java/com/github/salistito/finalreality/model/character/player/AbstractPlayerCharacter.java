package com.github.salistito.finalreality.model.character.player;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.salistito.finalreality.model.weapon.IWeapon;
import com.github.salistito.finalreality.model.character.AbstractCharacter;
import com.github.salistito.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the player characters in the game.
 *
 * @author Sebastián Salinas Rodriguez.
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter {

  private IWeapon equippedWeapon;

  /**
   * Constructor in common with all the player characters of the game.
   *
   * @param name
   *     the player character's name
   * @param healthPoints
   *     the player character's health points
   * @param defense
   *     the player character's defense
   * @param turnsQueue
   *     the queue with all the characters waiting for their turn
   */
  protected AbstractPlayerCharacter(@NotNull String name, int healthPoints, int defense,
                                    @NotNull BlockingQueue<ICharacter> turnsQueue) {
    super(name, healthPoints, defense, turnsQueue);
    this.equippedWeapon = null;
  }

  /**
   * Return this character's equipped weapon.
   */
  @Override
  public IWeapon getEquippedWeapon() { return this.equippedWeapon; }

  /**
   * Set this player character's weapon to the passed parameter.
   */
  @Override
  public void setEquippedWeapon(IWeapon weapon) {
    if (this.isAlive()) {
      this.equippedWeapon = weapon;
    }
  }

  /**
   * Returns this player character's attack damage.
   */
  @Override
  public int getAttackDamage() {
    if (this.equippedWeapon == null) {
      return 0;
    }
    else {
      return this.equippedWeapon.getDamage();
    }
  }

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor
            .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * @return int value that represents this character class, so with this int we can know what kind of turn it is
   * if the value is 1, it is a playerCharacter and the turn will be playerCharacter's one
   * if the value is 0, it is an enemy and the turn will be enemy's one
   */
  @Override
  public int turnType() {
    return 1; // int that represents this character class
  }
}
