package at.reservoirdogs.resifo_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MaritalstatusActivity extends AppCompatActivity
{
  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_maritalstatus)
  }

  def gotoMainActivity(view: View): Unit = startActivity(new Intent(this, classOf[MainActivity]))

  def gotoBirthplaceActivity(view: View): Unit = startActivity(new Intent(this, classOf[BirthplaceActivity]))

  def gotoNationalityActivity(view: View): Unit = startActivity(new Intent(this, classOf[NationalityActivity]))

}
