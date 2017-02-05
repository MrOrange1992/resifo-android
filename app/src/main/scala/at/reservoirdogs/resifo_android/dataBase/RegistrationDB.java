package at.reservoirdogs.resifo_android.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import scala.NotImplementedError;


/**
 * Created by felix on 05/02/2017.
 */

public class RegistrationDB extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "regDB";
    private Context context;

    public RegistrationDB(Context ctx)
    {
        super(ctx, DATABASE_NAME, null, 1);
        this.context = ctx;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        try{}
        catch (Exception e)
        {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try
        {
            String CREATE_PERSON_TABLE = "CREATE TABLE person ( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "firstname TEXT NOT NULL, " +
                    "lastname TEXT NOT NULL, " +
                    "akaGrade TEXT, " +
                    "birthdate TEXT NOT NULL, " +
                    "gender TEXT NOT NULL, " +
                    "religion TEXT, " +
                    "birthplace TEXT NOT NULL, " +
                    "maritalstatus TEXT NOT NULL, " +
                    "nationality TEXT NOT NULL, " +
                    "residence INT CONSTRAINT fk_residence REFERENCES residence (id) NOT NULL, " +
                    "zmr TEXT, " +
                    "docType TEXT, " +
                    "docDate TEXT, " +
                    "docNumber INT, " +
                    "docState TEXT, " +
                    "immigrant TEXT, " +
                    "immigrantCountry TEXT" +
                    ")";
            String CREATE_RESIDENCE_TABLE = "CREATE TABLE residence ( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "street TEXT NOT NULL, " +
                    "house INT NOT NULL, " +
                    "stair INT NOT NULL, " +
                    "door INT NOT NULL, " +
                    "plz INT NOT NULL, " +
                    "city TEXT NOT NULL," +
                    "state TEXT NOT NULL " +
                    ");";

            db.execSQL("DROP TABLE IF EXISTS PERSON;");
            db.execSQL("DROP TABLE IF EXISTS RESIDENCE;");
            // create tables
            db.execSQL(CREATE_PERSON_TABLE);
            db.execSQL(CREATE_RESIDENCE_TABLE);
        }
        catch (Exception e)
        {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }



    /***
     * Insert Data from Person Object to DB
     * @param person Person object to instert
     * @return True if successfully insterted to DB
     */
    public Boolean savePersonToDB(Person person)
    {
        SQLiteDatabase db = getWritableDatabase();
        try
        {
            db.insert("person", null, makeContentValues(person));
            return true;

            //TEST
            //sqlGetPersonByLastName(person.getLastName());
            //Console.println("test test test");
        }
        catch (Exception e) { Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show(); return false; }
    }



    /***
     * TODO                         !!!!!!
     * @param person
     * @return
     */
    public Boolean saveResidenceToDB(Person person)
    {
        throw new NotImplementedError("TODO");
    }



    /***
     * Create content values to insert to table person
     * TODO Residence NOT implemented
     * @param person
     * @return  Contentvalues
     */
    private ContentValues makeContentValues(Person person)
    {
        ContentValues cv = new ContentValues();
        cv.put("firstname", person.getFirstName());
        cv.put("lastname", person.getLastName());
        cv.put("akaGrade", person.getDegree());
        cv.put("birthdate", person.getBirthDate().toString());
        cv.put("gender", person.getGender());
        cv.put("religion", person.getReligion());
        cv.put("birthplace", person.getBirthPlace());
        cv.put("maritalstatus", person.getMaritalStatus());
        cv.put("nationality", person.getNationality());
        //cv.put("residence", person.getResidenceAt(0));
        cv.put("zmr", person.getZMR());
        cv.put("docType", person.getDocType());
        cv.put("docDate", person.getDocDate());
        cv.put("docNumber", person.getDocNumber());
        cv.put("docState", person.getDocNation());
        cv.put("akaGrade", person.getDegree());

        return cv;
    }

    /***
     * Get person object from DB, For VIEW ACTIVITIES
     * @param lastName parameter to search in DB
     *                 gets inserted into SELECT Statement
     * @return  Person object
     */
    private Person sqlGetPersonByLastName(String lastName)
    {
        String selectStatement = String.format("SELECT * FROM person WHERE lastname = '%s';", lastName);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectStatement, null);

        String id="",firstname="",lastname="",akaGrade="", birthdate="",gender="",religion="",
                birthplace="",maritalStatus="",nationality="",residenceID,zmr="",docType="",
                docDate="",docNumber="",docState="",immigrantCountry="";
        Boolean immigrant= false;

        if (c.moveToFirst()) { do {
            id = c.getString(0);
            firstname = c.getString(1);
            lastname = c.getString(2);
            akaGrade = c.getString(3);
            birthdate = c.getString(4);
            gender = c.getString(5);
            religion = c.getString(6);
            birthplace = c.getString(7);
            maritalStatus = c.getString(8);
            nationality = c.getString(9);
            residenceID = c.getString(10);
            zmr = c.getString(11);
            docType = c.getString(12);
            docDate = c.getString(13);
            docNumber = c.getString(14);
            docState = c.getString(15);
            immigrant = false;
            if (c.getString(15) == "true") immigrant = true;
            immigrantCountry = c.getString(17);

            } while (c.moveToNext());
        }

        Person person = new Person(firstname, lastname);

        //Parse string from DB to Date
        Date bDate = new Date();
        try
        {
            //TODO CHECK IF FORMATTING is right (yyyy-dd-mm)??
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            bDate = sdf.parse(birthdate);
        } catch (ParseException e) { e.printStackTrace(); }

        person.fillData(akaGrade,bDate,gender,religion,birthplace,maritalStatus,nationality,
                new ArrayList<Residence>(),zmr,docType,docDate,docNumber,docState,immigrant,immigrantCountry);

        c.close(); db.close(); return person;
    }

}
