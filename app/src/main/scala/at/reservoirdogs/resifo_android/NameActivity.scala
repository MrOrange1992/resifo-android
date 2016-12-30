package at.reservoirdogs.resifo_android

import android.content.{ContentValues, Intent}
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.{EditText, TextView}

class NameActivity extends AppCompatActivity
{
  var regDB : RegDB = _

  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_name)
    regDB = RegDB(getApplicationContext)
  }

  def gotoMainActivity(view: View): Unit = startActivity(new Intent(this, classOf[MainActivity]))

  def gotoBirthdateActivity(view: View): Unit =
  {
    val firstName: String = findViewById(R.id.editTextFirstname).asInstanceOf[EditText].getText.toString
    val lastName: String = findViewById(R.id.editTextLastname).asInstanceOf[EditText].getText.toString

    regDB.getWritableDatabase.execSQL("DROP TABLE IF EXISTS " + "tempRegistration")

    regDB.getWritableDatabase.execSQL("create table tempRegistration (" +
      "id INTEGER PRIMARY KEY ASC, " +
      "firstname TEXT, " +
      "lastname TEXT," +
      "lastnamebefore TEXT," +
      "birthdate TEXT," +
      "gender TEXT," +
      "religion TEXT," +
      "birthplace TEXT," +
      "maritalstatus TEXT," +
      "nationality TEXT," +
      "registrationordeparture TEXT," +
      "street TEXT," +
      "block TEXT," +
      "stairs TEXT," +
      "door TEXT," +
      "postalcode TEXT," +
      "state TEXT," +
      "mainresidence BOOL," +
      "immigration TEXT," +
      "emigration TEXT);")

    println(firstName)
    val cv = new ContentValues()
    Map("firstname" -> firstName, "lastname" -> lastName) foreach { case (k, v) => cv.put(k, v) }
    regDB.getWritableDatabase.insert("tempRegistration", null, cv)

    /*
    var someCursor: Option[Cursor] = None
    try
    {
      someCursor = Option(regDB.getReadableDatabase.query("tempRegistration", Array("id", "firstname", "lastname"), null, null, null, null, null))

      someCursor match
      {
        case None => System.err.println("Could not execute query due to some reason")
        case Some(c) => while (c.moveToNext())
        {
          val id = c.getInt(c.getColumnIndex("id"))
          val firstName = c.getString(c.getColumnIndex("firstname"))
          println(s"ID($id) : $firstName : $lastName")
        }
      }
    } finally { someCursor foreach (_.close()) }*/



    startActivity(new Intent(this, classOf[BirthdateActivity]))
  }

}
