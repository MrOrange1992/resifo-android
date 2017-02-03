package at.reservoirdogs.resifo_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import at.reservoirdogs.resifo_android.dataBase.Person;

/**
 * Created by felix on 03/02/2017.
 */

public class CustomAdapter extends android.widget.BaseAdapter
{
    List<Person> listPerson;
    Context context;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, List<Person> listUsers)
    {
        this.context = applicationContext;
        this.listPerson= listUsers;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() { return listPerson.size(); }

    @Override
    public Object getItem(int i) { return listPerson.get(i); }

    @Override
    public long getItemId(int i) { return i; }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null) {
            view = inflter.inflate(R.layout.row_item, null);//set layout for displaying items
        }
        TextView viewLastname = (TextView)view.findViewById(R.id.textViewListLastname);
        TextView viewFirstname = (TextView)view.findViewById(R.id.textViewListFirstname);

        Person person = listPerson.get(i);
        viewLastname.setText(person.getLastName());
        viewFirstname.setText(String.valueOf(person.getFirstName()));

        return view;
    }
}
