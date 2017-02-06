package at.reservoirdogs.resifo_android

import java.sql.Date

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{DatePicker, EditText, RadioButton, Toast}
import at.reservoirdogs.resifo_android.dataBase.Person

/**
  * Created by felix on 01/02/2017.
  */
class Input1Activity extends AppCompatActivity
{
  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_input1)
  }


  def checkInputs(view: View): Boolean =
  {
    var checkInput : Boolean = true
    List( findViewById(R.id.editTextAkaGrade).asInstanceOf[EditText].getText.toString,
          findViewById(R.id.editTextReligion).asInstanceOf[EditText].getText.toString,
          findViewById(R.id.editTextBirthplace).asInstanceOf[EditText].getText.toString,
          findViewById(R.id.editTextMaritalStatus).asInstanceOf[EditText].getText.toString).foreach(
            element => if (element.isEmpty) checkInput = false
    )
    checkInput
  }

  def writeDataToObject(view: View, person: Person): Person =
  {
    val birthDate: DatePicker = findViewById(R.id.datePicker).asInstanceOf[DatePicker]

    //Save textfield strings to person object
    person.setDegree(findViewById(R.id.editTextAkaGrade).asInstanceOf[EditText].getText.toString)
    person.setBirthDate(new Date(birthDate.getYear, birthDate.getMonth, birthDate.getDayOfMonth))
    if (findViewById(R.id.radioButtonGenderMale).asInstanceOf[RadioButton].isChecked) person.setGender("Male") else person.setGender("Female")
    person.setReligion(findViewById(R.id.editTextReligion).asInstanceOf[EditText].getText.toString)
    person.setBirthPlace(findViewById(R.id.editTextBirthplace).asInstanceOf[EditText].getText.toString)
    person.setMaritalStatus(findViewById(R.id.editTextMaritalStatus).asInstanceOf[EditText].getText.toString)

    person
  }

  def gotoInput2Activity(view: View): Unit =
  {
    if (checkInputs(view))
    {
      val person: Person = writeDataToObject(view, getIntent.getExtras.getSerializable("person").asInstanceOf[Person])

      val Input2Intent = new Intent(this, classOf[Input2Activity])
      Input2Intent.putExtra("person", person)

      startActivity(Input2Intent)
    }
    else Toast.makeText(getApplicationContext, "Bitte alle Felder ausfüllen!", 5000).show()

  }

}
