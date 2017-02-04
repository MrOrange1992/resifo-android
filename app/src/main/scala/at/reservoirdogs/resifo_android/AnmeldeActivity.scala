package at.reservoirdogs.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class AnmeldeActivity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_anmelde)
  }
  def gotoAnmeldeActivity(view: View): Unit = startActivity(new Intent(this, classOf[AnmeldeActivity]))
}