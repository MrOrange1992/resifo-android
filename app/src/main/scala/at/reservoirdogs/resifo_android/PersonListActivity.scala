package at.reservoirdogs.resifo_android

import android.app.ListActivity
import android.os.Bundle
import android.provider.Contacts.People
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{ArrayAdapter, ListView, SimpleCursorAdapter}

import scala.collection.JavaConversions._
import at.reservoirdogs.resifo_android.dataBase.{Person, RegDB}

/**
  * Created by felix on 03/02/2017.
  */
class PersonListActivity extends ListActivity
{
  var regDB: RegDB = _

  override def onCreate(savedInstanceState: Bundle): Unit =
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_person_list)
    regDB = RegDB(getApplicationContext)


    //TODO Get List of all persons currently in regDB
    //val persons: List[Person] = regDB.mkPersonDao().findByFirstName("ggg")

    //Test Case
    val personList: List[Person] = List(new Person("Flex", "Boy"))

    //val ps : List[Person] = List(Person("aaa","b"))

    //Custom adapter implemented in JAVA
    val customAdapter = new CustomAdapter(this, personList)
    setListAdapter(customAdapter)
  }

  override def onListItemClick(l: ListView, v: View, pos: Int, i: Long)
  {
    println("Pos: " + pos + " clicked")
    val p  = l.getAdapter.getItem(pos).asInstanceOf[Person]
    println(p)
  }
}
