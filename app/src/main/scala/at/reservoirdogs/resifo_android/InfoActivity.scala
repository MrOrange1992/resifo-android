package at.reservoirdogs.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{EditText, TextView, Toast}
import at.reservoirdogs.resifo_android.dataBase.{Person, RegDB, RegistrationDB}

/**
  * Created by felix on 01/02/2017.
  */
class InfoActivity extends AppCompatActivity with Serializable
{

  //var regDB: RegistrationDB = _

  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_info)
  }


  def gotoInput1Activity(view: View): Unit =
  {
    val firstName: String = findViewById(R.id.editTextFirstname).asInstanceOf[EditText].getText.toString
    val lastName: String = findViewById(R.id.editTextLastname).asInstanceOf[EditText].getText.toString

    if (firstName != "" && lastName != "")
    {
      val person: Person = new Person(firstName, lastName)
      val InputIntent = new Intent(this, classOf[Input1Activity])

      //Only for TEST, save to DB at the last activity!!
      //regDB = new RegistrationDB(getApplicationContext)
      //regDB.savePersonToDB(person)

      //Pass on Object to next Activity
      InputIntent.putExtra("person", person)

      startActivity(InputIntent)
    }
    else Toast.makeText(getApplicationContext, "Bitte geben Sie Vor- und Nachname an!", 5000).show()
  }

}
