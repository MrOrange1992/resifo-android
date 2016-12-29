package at.reservoirdogs.resifo_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ReligionActivity extends AppCompatActivity
{
  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_religion)
  }

  def gotoMainActivity(view: View): Unit = startActivity(new Intent(this, classOf[MainActivity]))

  def gotoGenderActivity(view: View): Unit = startActivity(new Intent(this, classOf[GenderActivity]))

  def gotoBirthplaceActivity(view: View): Unit = startActivity(new Intent(this, classOf[BirthplaceActivity]))

}
