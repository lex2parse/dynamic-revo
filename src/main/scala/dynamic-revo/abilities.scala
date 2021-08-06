package revo

class AutoAttack(using cfg: Config) extends Ability {
  val cooldown = cfg.attackSpeed
  val adrenReq = 0
  def events =
    Seq(
      (0, GainAdrenaline(2)),
      (0, Damage(100, 100))
    )
}
