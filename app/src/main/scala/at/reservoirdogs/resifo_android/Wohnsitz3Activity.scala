package at.reservoirdogs.resifo_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Wohnsitz3Activity extends AppCompatActivity
{
  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_wohnsitz3)
  }

  def gotoAnmeldeActivity(view: View): Unit = startActivity(new Intent(this, classOf[AnmeldeActivity]))


  def enableEmigratedField(view: View): Unit =
  {
    findViewById(R.id.EmigrationField).setEnabled(true)
    findViewById(R.id.EmigrationField).setVisibility(View.VISIBLE)
  }

  def disableEmigratedField(view: View): Unit =
  {
    findViewById(R.id.EmigrationField).setEnabled(false)
    findViewById(R.id.EmigrationField).setVisibility(View.GONE)
  }
}