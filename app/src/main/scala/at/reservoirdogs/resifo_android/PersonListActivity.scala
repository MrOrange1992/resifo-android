package at.reservoirdogs.resifo_android

import java.util

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.provider.Contacts.People
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{AdapterView, ArrayAdapter, ListView, SimpleCursorAdapter}

import scala.collection.JavaConversions._
import at.reservoirdogs.resifo_android.dataBase.{Person, RegDB, RegistrationDB}

/**
  * Created by felix on 03/02/2017.
  */
class PersonListActivity extends ListActivity
{
  var regDB: RegistrationDB = _


  override def onCreate(savedInstanceState: Bundle): Unit =
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_person_list)
    regDB = new RegistrationDB(getApplicationContext)

    val personList: util.ArrayList[Person] = regDB.sqlGetAllPersons()

    //Custom adapter implemented in JAVA
    val customAdapter = new CustomAdapter(this, personList)
    setListAdapter(customAdapter)
  }


  override def onListItemClick(l: ListView, view: View, pos: Int, i: Long)
  {

    val person = l.getAdapter.getItem(pos)

    //val person: Person  = l.getAdapter.getItem(pos).asInstanceOf[Person]


    regDB = new RegistrationDB(getApplicationContext)

    //val person: Person = regDB.sqlGetPersonByLastName(person.getLastName)

    val ViewIntent = new Intent(this, classOf[ViewActivity])
    ViewIntent.putExtra("person", person.asInstanceOf[Person])
    startActivity(ViewIntent)



  }
}
