package at.reservoirdogs.resifo_android

import android.content.Intent
import android.location.{Location, LocationListener, LocationManager}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{Button, RadioButton, TextView, Toast}

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
    else startActivity(new Intent(this, classOf[Wohnsitz2Activity]))
  }

  def getAddress(view: View): Unit = {
    val myLocation: GpsLocation = new GpsLocation(this)
    val addressfields = myLocation.getAddress()
    var output ="Address: "
    output = output + addressfields(0)+"\n City: "
    output = output + addressfields(1)+"\n PLZ: "
    output = output + addressfields(1)

    Toast.makeText(getApplicationContext(),output,5000).show()

    /*val b = findViewById(R.id.btnCurrentLocation).asInstanceOf[Button];
    //val locationManager = getSystemService(LOCATION_SERVICE).asInstanceOf[LocationManager];

    val listener = new LocationListener {

      override def onProviderEnabled(s : String): Unit = {
      }

      override def onStatusChanged(provider: String, status: Int, extras: Bundle): Unit = {

      }

      override def onLocationChanged(location: Location): Unit = {
      location.getLatitude();
      location.getLongitude();

      val myLocation  = "Latitude = " + location.getLatitude() + " Longitude = " + location.getLongitude();

        Toast.makeText(getApplicationContext(),myLocation,5000).show();
    }

      override def onProviderDisabled(provider: String): Unit = {

      }
    }*/

  }
}
