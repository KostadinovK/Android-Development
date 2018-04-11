package com.kosta.homework;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kostadin Kostadinov on 10/04/2018.
 */

public class StoriesFragment extends Fragment {
    public static List<Post> data = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stories, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        PostAdapter postAdapter = new PostAdapter(data);
        recyclerView.setAdapter(postAdapter);
        return view;
    }

}
