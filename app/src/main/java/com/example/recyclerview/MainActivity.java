package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;

    String [] name = {
            "Java",//1
            "Premier Pro",//2
            "Apple Software Developement",//3
            "JavaScript",//4
            "HTML",//5
            "CGI",//6
            "Photoshop",//7
            "PHP",//8
            "MS Word",//9
            "MS Excel",//10
            "MS Powerpoint",//11
            "SQL",//12
            "ASP.net",//13
            "Java Server Pages",//14
            "CAD",//15

    };
    String [] desc = {
            "Java Programming Language",
            "Video Editing",
            "Apple Developement",
            "JavaScript Programming Language",
            "HTML Programming Language",
            "CGI",
            "Photoshop ",
            "PHP",
            "MS Word",
            "MS Excel",
            "MS Powerpoint",
            "SQL",
            "ASP.net Programming Language",
            "Java Server Pages",
            "CAD",
    };
    int [] image = {
            R.drawable.java,
            R.drawable.mp4,
            R.drawable.dmg,
            R.drawable.js,
            R.drawable.html,
            R.drawable.cgi,
            R.drawable.psd,
            R.drawable.php,
            R.drawable.doc,
            R.drawable.xlsx,
            R.drawable.ppt,
            R.drawable.sql,
            R.drawable.asp,
            R.drawable.jsp,
            R.drawable.cad,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview_id);
        List<User> sampleuser = new ArrayList<>();

        for(int i=0;i<name.length;i++)
        {
            User user = new User();
            user.subjectname = name[i];
            user.userdesc=desc[i];
            user.subimage=image[i];

            sampleuser.add(user);

        }

        //The LayoutManager is used for
        //1. To positioning the items of RecyclerView.
        //2. Type of RecyclerView like list or grid.
        //3. The orientations,the item display in Horizontal or Vertical.
        //4. To calculate size and position of each item in RecyclerView.
       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
       recyclerView.setLayoutManager(linearLayoutManager);

        //using grid layout
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RecyclerAdapter(getBaseContext(),sampleuser));
    }
}
