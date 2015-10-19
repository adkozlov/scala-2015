import scala.util.Random

trait WaterVolumeComponent {
  val waterVolume: WaterVolume

  case class WaterVolume(maxVolume: Double) {
    def volume = WaterVolume.RANDOM.nextDouble * maxVolume
  }

  object WaterVolume {
    private val RANDOM = new Random()
  }
}

trait WaterVolumeRangeComponent {
  this: WaterVolumeComponent =>

  val waterVolumeRange: WaterVolumeRange

  case class WaterVolumeRange(minVolume: Double, maxVolume: Double) {

    def validate() {
      val volume = waterVolume.volume
      volume >= minVolume && volume < maxVolume match {
        case false => throw new RuntimeException("Overflow")
        case _ =>
      }
    }
  }
}

trait HeaterComponent {
  val heater: Heater

  case class Heater(initTemperature: Double,
                    maxTemperature: Double = 100,
                    var isOn: Boolean = false) {
    private var currentTemperature = initTemperature

    new Thread(new Runnable {
      override def run(): Unit = {
        while (!Thread.interrupted() && currentTemperature < maxTemperature) {
          if (isOn) {
            println(currentTemperature)
            currentTemperature += 1e-2
          }
        }
      }
    }).start()

    def temperature = currentTemperature
  }
}

trait HeaterButtonComponent {
  this: HeaterComponent =>

  val heaterButton: HeaterButton

  def press = heaterButton.press

  case class HeaterButton() {
    def press = {
      heater.isOn = !heater.isOn
      heater.isOn
    }
  }
}

trait HeaterFuseComponent {
  this: HeaterComponent with HeaterButtonComponent =>

  val heaterFuse: HeaterFuse

  override def press = {
    heaterFuse.validate match {
      case true => heaterButton.press
      case _ => false
    }
  }

  case class HeaterFuse(maxTemperature: Double) {
    def validate = heater.temperature < maxTemperature
  }
}

class Kettle(initTemperature: Double = 0, minVolume: Double = 0.1, maxVolume: Double = 3.0)
  extends HeaterButtonComponent with HeaterComponent with WaterVolumeRangeComponent with WaterVolumeComponent {
  override val heaterButton = HeaterButton()
  override val heater = Heater(initTemperature)
  override val waterVolumeRange = WaterVolumeRange(minVolume, maxVolume)
  override val waterVolume = WaterVolume(maxVolume)
}

class SmartKettle(initTemperature: Double = 0, minVolume: Double = 0.1, maxVolume: Double = 3.0,
                  boundTemperature: Double = 98)
  extends Kettle(initTemperature, minVolume, maxVolume) with HeaterFuseComponent {
  override val heaterFuse = new HeaterFuse(boundTemperature)
}

new Kettle(99).press
new SmartKettle(99).press