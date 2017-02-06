package at.reservoirdogs.resifo_android

import java.sql.Date

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{DatePicker, EditText, RadioButton, Toast}
import at.reservoirdogs.resifo_android.dataBase.Person

/**
  * Created by Phil on 03.02.2017.
  */
class Input2Activity extends AppCompatActivity
{
  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_input2)
  }

  def checkInputs(view: View): Boolean =
  {
    var checkInput : Boolean = true

    if (!findViewById(R.id.radioButtonCitizenshipAustria).asInstanceOf[RadioButton].isChecked && findViewById(R.id.editTextOtherLand).asInstanceOf[EditText].getText.toString.isEmpty)
      checkInput = false

    checkInput
  }

  def writeDataToObject(view: View, person: Person): Person =
  {
    val birthDate: DatePicker = findViewById(R.id.datePickerIssueDate).asInstanceOf[DatePicker]

    //Save textfield strings to person object
    if (findViewById(R.id.radioButtonCitizenshipAustria).asInstanceOf[RadioButton].isChecked) person.setNationality("Austria")
    else person.setNationality(findViewById(R.id.editTextOtherLand).asInstanceOf[EditText].getText.toString)
    person.setZMR(findViewById(R.id.editTextZMR).asInstanceOf[EditText].getText.toString)
    person.setDocType(findViewById(R.id.editTextArt).asInstanceOf[EditText].getText.toString)
    person.setDocNumber(findViewById(R.id.editTextNumber).asInstanceOf[EditText].getText.toString)

    person.setDocDate(new Date(birthDate.getYear, birthDate.getMonth, birthDate.getDayOfMonth))

    person.setDocNation(findViewById(R.id.editTextAusstellende).asInstanceOf[EditText].getText.toString)

    person
  }

  def gotoWohnsitz1Activity(view: View): Unit =
  {
    if (checkInputs(view))
    {
      val person: Person = writeDataToObject(view, getIntent.getExtras.getSerializable("person").asInstanceOf[Person])

      val Wohnsitz1Intent = new Intent(this, classOf[Wohnsitz1Activity])
      Wohnsitz1Intent.putExtra("person", person)

      startActivity(Wohnsitz1Intent)
    }
    else Toast.makeText(getApplicationContext, "Please enter other country", 5000).show()
  }

  def enableResidenceField(view: View): Unit =
  {
    findViewById(R.id.editTextOtherLand).setEnabled(true)
    findViewById(R.id.editTextOtherLand).setVisibility(View.VISIBLE)
  }

  def disableResidenceField(view: View): Unit =
  {
    findViewById(R.id.editTextOtherLand).setEnabled(false)
    findViewById(R.id.editTextOtherLand).setVisibility(View.GONE)
  }

}
