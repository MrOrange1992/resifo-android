package at.reservoirdogs.resifo_android

import android.content.Intent
import android.location.{Location, LocationListener, LocationManager}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{Button, RadioButton, TextView, Toast}
import android.widget._
import at.reservoirdogs.resifo_android.dataBase.{Person, Residence}

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

  def checkInputs(view: View): Boolean =
  {
    var checkInput : Boolean = true

    List( findViewById(R.id.editTextStreet).asInstanceOf[EditText].getText.toString,
          findViewById(R.id.editTextHouse).asInstanceOf[EditText].getText.toString,
        findViewById(R.id.editTextStairs).asInstanceOf[EditText].getText.toString,
      findViewById(R.id.editTextDoor).asInstanceOf[EditText].getText.toString,
      findViewById(R.id.editTextPLZ).asInstanceOf[EditText].getText.toString,
      findViewById(R.id.editTextVillage).asInstanceOf[EditText].getText.toString,
      findViewById(R.id.editTextState).asInstanceOf[EditText].getText.toString).foreach (
      element => if (element.isEmpty) checkInput = false
    )

    checkInput
  }

  def writeDataToObject(view: View, person: Person): Person =
  {
    val residence: Residence = new Residence("",0,0,0,0,"","")
    //Save textfield strings to residence object

    if (findViewById(R.id.radioBtnAnmeldung).asInstanceOf[RadioButton].isChecked) residence.setActive(true)
    else residence.setActive(false)

    residence.setStreet(findViewById(R.id.editTextStreet).asInstanceOf[EditText].getText.toString)

    try
    {
      val house = findViewById(R.id.editTextHouse).asInstanceOf[EditText].getText.toString
      val stairs = findViewById(R.id.editTextStairs).asInstanceOf[EditText].getText.toString
      val door = findViewById(R.id.editTextDoor).asInstanceOf[EditText].getText.toString
      val plz = findViewById(R.id.editTextPLZ).asInstanceOf[EditText].getText.toString
      residence.setHouseNumber(house.toInt)
      residence.setStairs(stairs.toInt)
      residence.setDoor(door.toInt)
      residence.setPlz(plz.toInt)
    }
    catch{ case e: Exception => Toast.makeText(getApplicationContext, "Ungültige Eingabe!", 5000).show() }

    residence.setCity(findViewById(R.id.editTextVillage).asInstanceOf[EditText].getText.toString)
    residence.setState(findViewById(R.id.editTextState).asInstanceOf[EditText].getText.toString)

    person.addResidence(residence)
    person
  }

  def continueTo(view: View): Unit =
  {
    if (checkInputs(view))
    {
      val person: Person = writeDataToObject(view, getIntent.getExtras.getSerializable("person").asInstanceOf[Person])

      if(!findViewById(R.id.radioBtnMainResidence).asInstanceOf[RadioButton].isChecked)
      {
        val Wohnsitz2Intent = new Intent(this, classOf[Wohnsitz2Activity])
        Wohnsitz2Intent.putExtra("person", person)
        startActivity(Wohnsitz2Intent)
      }
      else
      {
        val AnmeldeIntent = new Intent(this, classOf[AnmeldeActivity])
        AnmeldeIntent.putExtra("person", person)
        startActivity(AnmeldeIntent)
      }
    }
    else Toast.makeText(getApplicationContext, "Bitte alle Felder ausfüllen!", 5000).show()
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
