package com.example.bogdanherput.viewpagerexample;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.Arrays;
import java.util.List;

public class FragmentItem extends ListFragment {
    protected List<String> listItems;

    public static FragmentItem getInstance(List<String> listItems) {
        final FragmentItem f = new FragmentItem();

        final Bundle args = new Bundle(1);
        args.putStringArray("list_items", listItems.toArray(new String[listItems.size()]));
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listItems = Arrays.asList(getArguments().getStringArray("list_items"));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1,
                listItems));
    }
}
