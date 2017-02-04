package at.reservoirdogs.resifo_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Wohnsitz2Activity extends AppCompatActivity
{
  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_wohnsitz2)
  }

  def gotoAnmeldeActivity(view: View): Unit = startActivity(new Intent(this, classOf[AnmeldeActivity]))

}
