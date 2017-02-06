package at.reservoirdogs.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.{EditText, TextView}
import at.reservoirdogs.resifo_android.dataBase.Person

class ViewActivity extends AppCompatActivity
{
  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_view)

    val person: Person = getIntent.getExtras.getSerializable("person").asInstanceOf[Person]

    findViewById(R.id.editTextFamilyName).asInstanceOf[TextView].setText(person.getLastName)
    findViewById(R.id.editFirstname).asInstanceOf[TextView].setText(person.getFirstName)
    findViewById(R.id.editTextAkadGrade).asInstanceOf[TextView].setText(person.getDegree)
    findViewById(R.id.editTextBirthday).asInstanceOf[TextView].setText(person.getBirthDate.toString)
    findViewById(R.id.editTextGender).asInstanceOf[TextView].setText(person.getGender)
    findViewById(R.id.editTextReligion).asInstanceOf[TextView].setText(person.getReligion)
    findViewById(R.id.editTextBirthPlace).asInstanceOf[TextView].setText(person.getBirthPlace)
    findViewById(R.id.editTextMaritalStatus).asInstanceOf[TextView].setText(person.getMaritalStatus)
    findViewById(R.id.editTextNationality).asInstanceOf[TextView].setText(person.getNationality)

  }




}