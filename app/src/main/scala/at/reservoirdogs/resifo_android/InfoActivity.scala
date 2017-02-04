package at.reservoirdogs.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{EditText, TextView}
import at.reservoirdogs.resifo_android.dataBase.{Person, RegDB}

/**
  * Created by felix on 01/02/2017.
  */
class InfoActivity extends AppCompatActivity with Serializable
{

  var regDB: RegDB = _

  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_info)
    regDB = RegDB(getApplicationContext)

    regDB.mkPerson()
  }

  /*
  def loadFromDb(view: View): Unit =
  {
    //val i = new Intent(this, classOf[MyListActivity])
    //startActivity(i)
  }
  */

  def gotoInput1Activity(view: View): Unit =
  {
    val firstName: String = findViewById(R.id.editTextFirstname).asInstanceOf[EditText].getText.toString
    val lastName: String = findViewById(R.id.editTextLastname).asInstanceOf[EditText].getText.toString

    if (firstName != "" && lastName != "")
    {
      val person: Person = new Person(firstName, lastName)
      val InputIntent = new Intent(this, classOf[Input1Activity])
      InputIntent.putExtra("person", person)

      startActivity(InputIntent)
    }
    else
    {
      findViewById(R.id.txtInfoForUser).asInstanceOf[TextView].setText("Please enter first and last name")
    }
  }

}
