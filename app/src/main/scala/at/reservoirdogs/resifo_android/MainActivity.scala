package at.reservoirdogs.resifo_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import at.reservoirdogs.resifo_android.dataBase.Person

class MainActivity extends AppCompatActivity
{

  override protected def onCreate(savedInstanceState: Bundle)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val p1 = new Person("Flex", "Boy")

    Console.println(p1.getFirstName)
  }

  def gotoAboutActivity(view: View): Unit = startActivity(new Intent(this, classOf[AboutActivity]))

  def gotoInfoActivity(view: View): Unit = startActivity(new Intent(this, classOf[InfoActivity]))

}
