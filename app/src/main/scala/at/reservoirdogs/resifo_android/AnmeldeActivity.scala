package at.reservoirdogs.resifo_android

import android.content.Intent
import android.location.{Location, LocationListener, LocationManager}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{Button, RadioButton, TextView, Toast}
import android.widget._
import at.reservoirdogs.resifo_android.dataBase.{Person, RegistrationDB, Residence}
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{EditText, RadioButton, Toast}

class AnmeldeActivity extends AppCompatActivity
{
  var regDB: RegistrationDB = _

  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_anmelde)
  }

  def checkInputs(view: View, person: Person): Boolean =
  {
    var checkInput : Boolean = true

    if (person.getResidenceAt(0).getActive)
    {
      List( findViewById(R.id.editTxtAccomFirstname).asInstanceOf[EditText].getText.toString,
        findViewById(R.id.editTxtAccomLastname).asInstanceOf[EditText].getText.toString).foreach (
        element => if (element.isEmpty) checkInput = false
      )
      checkInput
    }
    else checkInput
  }



  def gotoMainActivity(view: View): Unit =
  {
    val person: Person = getIntent.getExtras.getSerializable("person").asInstanceOf[Person]

    if (person.getResidenceAt(0).getActive)
    {
      if (checkInputs(view, person))
      {
        writePersonToDB(view, person)
        startActivity(new Intent(this, classOf[MainActivity]))
        Toast.makeText(getApplicationContext,"Speichern erfolgreich",5000).show()
      }
      else Toast.makeText(getApplicationContext,"Bitte füllen Sie alle erforderlichen Felder aus!!",5000).show()
    }
    else
    {
      writePersonToDB(view, person)
      startActivity(new Intent(this, classOf[MainActivity]))
      Toast.makeText(getApplicationContext,"Speichern erfolgreich",5000).show()
    }
  }

  def writePersonToDB(view: View, person: Person): Unit =
  {
    regDB = new RegistrationDB(getApplicationContext)
    regDB.saveResidenceToDB(person.getResidenceAt(0))
    regDB.savePersonToDB(person)
    regDB.assignResidenceToPerson(person, person.getResidenceAt(0))
  }
}

