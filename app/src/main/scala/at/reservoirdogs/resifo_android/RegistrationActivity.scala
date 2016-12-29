package at.reservoirdogs.resifo_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RegistrationActivity extends AppCompatActivity
{
  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_registration)
  }

  def gotoMainActivity(view: View): Unit = startActivity(new Intent(this, classOf[MainActivity]))

  def gotoNationalityActivity(view: View): Unit = startActivity(new Intent(this, classOf[NationalityActivity]))

  def gotoOthermainresidenceActivity(view: View): Unit = startActivity(new Intent(this, classOf[OthermainresidenceActivity]))


}
