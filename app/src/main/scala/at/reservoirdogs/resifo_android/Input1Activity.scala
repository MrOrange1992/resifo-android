package at.reservoirdogs.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
  * Created by felix on 01/02/2017.
  */
class Input1Activity extends AppCompatActivity
{
  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_input1)
  }



  def gotoInput2Activity(view: View): Unit =
  {
    startActivity(new Intent(this, classOf[Input2Activity]))
  }

}
