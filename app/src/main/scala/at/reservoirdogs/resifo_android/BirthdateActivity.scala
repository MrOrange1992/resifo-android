package at.reservoirdogs.resifo_android

import android.content.{ContentValues, Intent}
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.{DatePicker, EditText}

class BirthdateActivity extends AppCompatActivity
{
  var regDB : RegDB = _

  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_birthdate)
    regDB = RegDB(getApplicationContext)
  }

  def gotoNameActivity(view: View): Unit = startActivity(new Intent(this, classOf[NameActivity]))

  def gotoMainActivity(view: View): Unit = startActivity(new Intent(this, classOf[MainActivity]))

  def gotoGenderActivity(view: View): Unit =
  {
    val datePicker : DatePicker = findViewById(R.id.datePicker).asInstanceOf[DatePicker]

    val date : String = datePicker.getDayOfMonth.toString + datePicker.getMonth.toString + datePicker.getYear.toString

    val cv = new ContentValues()
    Map("birthdate" -> date) foreach { case (k, v) => cv.put(k, v) }
    regDB.getWritableDatabase.insert("tempRegistration", null, cv)

    /*
    var someCursor: Option[Cursor] = None
    try
    {
      someCursor = Option(regDB.getReadableDatabase.query("tempRegistration", Array("id", "birthdate"), null, null, null, null, null))

      someCursor match
      {
        case None => System.err.println("Could not execute query due to some reason")
        case Some(c) => while (c.moveToNext())
        {
          val birthdate = c.getString(c.getColumnIndex("birthdate"))
          println("birthdate : " + birthdate)
        }
      }
    } finally { someCursor foreach (_.close()) }*/

    startActivity(new Intent(this, classOf[GenderActivity]))
  }



}
