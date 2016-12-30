package at.reservoirdogs.resifo_android

import android.content.Context
import android.database.sqlite.{SQLiteDatabase, SQLiteOpenHelper}

case class RegDB(context: Context) extends SQLiteOpenHelper(context, "registrationDB", null, 1)
{

  override def onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int): Unit = ()

  override def onCreate(db: SQLiteDatabase): Unit =
  {
    //db.execSQL("create table registration (id INTEGER PRIMARY KEY ASC, firstname TEXT not null, lastname TEXT not null);")
  }

}
