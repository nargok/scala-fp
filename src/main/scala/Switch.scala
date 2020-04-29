class Switch(var isOn: Boolean) {

  def toggle(switch: Switch): Unit =
    if (switch.isOn) switch.isOn = false else switch.isOn = true
}
