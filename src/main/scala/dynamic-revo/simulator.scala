package revo

import scala.collection.mutable.ArrayBuffer

trait Event:
  val priority = 0
  def modify(state: State): Unit

class State(
    var selfHP: Int,
    var enemyHP: Int,
    var adrenaline: Int
):
  def damage(amount: Int): Unit =
    enemyHP -= amount
  def gainAdrenaline(amount: Int): Unit =
    adrenaline += amount

class Damage(min: Int, max: Int)(using cfg: Config) extends Event:
  def modify(state: State) =
    if math.random() < cfg.hitChance then
      val range = max - min
      val amount = (min + (range * math.random())) * cfg.abilityDamage
      state.damage(amount.toInt)

class GainAdrenaline(amount: Int) extends Event:
  def modify(state: State) =
    state.gainAdrenaline(amount)

abstract class Bind extends Event
abstract class Stun extends Event
abstract class Poison extends Event

class EventQueue(using cfg: Config):
  import scala.collection.mutable.*

  var currentTick = 0
  val state = State(cfg.selfHP, cfg.monsterHP, 0)
  val activeEvents = Map[Int, ArrayBuffer[Event]]()

  def registerEvent(delay: Int, event: Event): Unit =
    val futureEvents = activeEvents.getOrElseUpdate(delay + currentTick, new ArrayBuffer[Event]())
    futureEvents.append(event)

  def tick =
    activeEvents.get(currentTick) match
      case Some(events) =>
        for event <- events do event.modify(state)
      case None => ()
    currentTick += 1

trait Ability:
  val cooldown: Int
  val adrenReq: Int
  def events: Seq[(Int, Event)]

class Modifier()

class Config:
  val attackSpeed = 3
  val hitChance = 0.5
  val autoDamange = 1500
  val abilityDamage = 1500
  val dualWield = true
  val selfHP = 9900
  val monsterHP = 45000

def simulate =
  // Choose ability

  // Add events to queue

  // Tick queue to execute events
  ()
