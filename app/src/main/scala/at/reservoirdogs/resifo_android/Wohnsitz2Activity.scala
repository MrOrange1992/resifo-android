package at.reservoirdogs.resifo_android

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{EditText, RadioButton, Spinner, Toast}
import at.reservoirdogs.resifo_android.dataBase.{Person, Residence}

/**
  * Created by felix on 05/02/2017.
  */
class Wohnsitz2Activity extends AppCompatActivity
{
  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_wohnsitz2)
  }


  def checkInputs(view: View): Boolean =
  {
    var checkInput : Boolean = true

    List( findViewById(R.id.editTextStreet).asInstanceOf[EditText].getText.toString,
      findViewById(R.id.editTextHouse).asInstanceOf[EditText].getText.toString,
      findViewById(R.id.editTextPLZ).asInstanceOf[EditText].getText.toString,
      findViewById(R.id.editTextVillage).asInstanceOf[EditText].getText.toString,
      findViewById(R.id.spinnerState).asInstanceOf[Spinner].getSelectedItem.toString).foreach (
      element => if (element.isEmpty) checkInput = false
    )

    if (findViewById(R.id.radioButtonImmigrationYes).asInstanceOf[RadioButton].isChecked && findViewById(R.id.editTextStateEmigrated).asInstanceOf[EditText].getText.toString.isEmpty)
      checkInput = false

    checkInput
  }

  def writeDataToObject(view: View, person: Person): Person =
  {
    val residence: Residence = new Residence("",0,0,0,0,"","")
    //Save textfield strings to residence object


    residence.setStreet(findViewById(R.id.editTextStreet).asInstanceOf[EditText].getText.toString)

    var stairs=""
    var door = ""
    try
    {
      val house = findViewById(R.id.editTextHouse).asInstanceOf[EditText].getText.toString
      stairs = findViewById(R.id.editTextStairs).asInstanceOf[EditText].getText.toString
      door = findViewById(R.id.editTextDoor).asInstanceOf[EditText].getText.toString
      val plz = findViewById(R.id.editTextPLZ).asInstanceOf[EditText].getText.toString
      residence.setHouseNumber(house.toInt)
      residence.setStairs(stairs.toInt)
      residence.setDoor(door.toInt)
      residence.setPlz(plz.toInt)
      residence.setMainResidence(true)
    }
    catch{ case e: Exception =>  }

    residence.setCity(findViewById(R.id.editTextVillage).asInstanceOf[EditText].getText.toString)
    residence.setState(findViewById(R.id.spinnerState).asInstanceOf[Spinner].getSelectedItem.toString)

    person.addResidence(residence)
    person
  }

  def continueTo(view: View): Unit =
  {
    if (checkInputs(view))
    {
      val person: Person = writeDataToObject(view, getIntent.getExtras.getSerializable("person").asInstanceOf[Person])

      val AnmeldeIntent = new Intent(this, classOf[AnmeldeActivity])
      AnmeldeIntent.putExtra("person", person)
      startActivity(AnmeldeIntent)
    }
    else Toast.makeText(getApplicationContext, "Bitte alle Felder ausfüllen!", 5000).show()
  }

  def getAddress(view: View): Unit = {
    val myLocation: GpsLocation = new GpsLocation(this)
    val addressfields = myLocation.getAddress()

    val housenumber = addressfields(0).split(" ")(addressfields(0).split(" ").length-1)
    val street = addressfields(0).substring(0,addressfields(0).length() - housenumber.length())
    val city = addressfields(1)
    val plz = addressfields(2)
    findViewById(R.id.editTextHouse).asInstanceOf[EditText].setText(housenumber)
    findViewById(R.id.editTextStreet).asInstanceOf[EditText].setText(street)
    findViewById(R.id.editTextVillage).asInstanceOf[EditText].setText(city)
    findViewById(R.id.editTextPLZ).asInstanceOf[EditText].setText(plz);

  }



}