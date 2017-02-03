package at.reservoirdogs.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton

/**
  * Created by felix on 01/02/2017.
  */
class Wohnsitz1Activity extends AppCompatActivity
{
  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_wohnsitz1)
  }

  def continueTo(view: View): Unit =
  {
    if(findViewById(R.id.radioButtonMainResidenceYes).asInstanceOf[RadioButton].isChecked)
      startActivity(new Intent(this, classOf[Wohnsitz3Activity]))
    else
      startActivity(new Intent(this, classOf[Wohnsitz2Activity]))
  }

}
