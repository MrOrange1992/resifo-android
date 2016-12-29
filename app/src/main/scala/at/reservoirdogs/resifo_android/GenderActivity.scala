package at.reservoirdogs.resifo_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class GenderActivity extends AppCompatActivity
{
  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_gender)
  }

  def gotoMainActivity(view: View): Unit = startActivity(new Intent(this, classOf[MainActivity]))

  def gotoBirthdateActivity(view: View): Unit = startActivity(new Intent(this, classOf[BirthdateActivity]))

  def gotoReligionActivity(view: View): Unit = startActivity(new Intent(this, classOf[ReligionActivity]))


}
