package at.reservoirdogs.resifo_android

import android.content.Intent
import android.location.{Location, LocationListener, LocationManager}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{Button, RadioButton, TextView}

/**
  * Created by felix on 01/02/2017.
  */
class Wohnsitz1Activity extends AppCompatActivity
{

  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_wohnsitz1)
  }

  def continueTo(view: View): Unit =
  {
    if(findViewById(R.id.radioButtonMainResidenceYes).asInstanceOf[RadioButton].isChecked)
      startActivity(new Intent(this, classOf[Wohnsitz3Activity]))
    else
      startActivity(new Intent(this, classOf[Wohnsitz2Activity]))
  }

  /*def getAddress: Unit = {

    val b = findViewById(R.id.btnCurrentLocation).asInstanceOf[Button];
    val locationManager = getSystemService(LOCATION_SERVICE).asInstanceOf[LocationManager];

    val listener = new LocationListener {

      override def onProviderEnabled(provider: String): Unit = ???

      override def onStatusChanged(provider: String, status: Int, extras: Bundle): Unit = ???

      override def onLocationChanged(location: Location): Unit = ???

      override def onProviderDisabled(provider: String): Unit = ???
    }

  }*/
}
