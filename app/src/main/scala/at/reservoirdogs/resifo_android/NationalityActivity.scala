package at.reservoirdogs.resifo_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.{ArrayAdapter, Spinner}

class NationalityActivity extends AppCompatActivity
{
  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_nationality)

    //Spinner context
    val nationalitySpinner = findViewById(R.id.nationalitySpinner).asInstanceOf[Spinner]
    // Create an ArrayAdapter using the string array and a default spinner layout
    val arrayAdapter = ArrayAdapter.createFromResource(this,R.array.nationalitiesArray, android.R.layout.simple_spinner_item)
    // Specify the layout to use when the list of choices appears
    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    // Apply the adapter to the spinner
    nationalitySpinner.setAdapter(arrayAdapter)
  }

  def gotoMainActivity(view: View): Unit = startActivity(new Intent(this, classOf[MainActivity]))

  def gotoMartialstatusActivity(view: View): Unit = startActivity(new Intent(this, classOf[MaritalstatusActivity]))

  def gotoRegistrationActivity(view: View): Unit = startActivity(new Intent(this, classOf[RegistrationActivity]))


}
