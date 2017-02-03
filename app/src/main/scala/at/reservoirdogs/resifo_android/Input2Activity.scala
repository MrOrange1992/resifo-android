package at.reservoirdogs.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

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

  def gotoWohnsitz1Activity(view: View): Unit = startActivity(new Intent(this, classOf[Wohnsitz1Activity]))

  def enableResidenceField(view: View): Unit = {
    findViewById(R.id.editTextOtherLand).setEnabled(true)
  }
  def disableResidenceField(view: View): Unit = {
    findViewById(R.id.editTextOtherLand).setEnabled(false)
  }

}
