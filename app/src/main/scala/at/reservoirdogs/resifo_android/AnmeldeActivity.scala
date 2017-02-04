package at.reservoirdogs.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

class AnmeldeActivity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_anmelde)
  }
  def gotoMainActivity(view: View): Unit = {
    startActivity(new Intent(this, classOf[MainActivity]));
    Toast.makeText(getApplicationContext(),"Speichern erfolgreich",5000).show();
  }
}

