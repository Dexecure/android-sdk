package net.dexecure.dexassets.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import net.dexecure.DexecureURLBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");

        //urlBuilder.setParameter(WIDTH,"200");
        //urlBuilder.setParameter(HEIGHT,"300");

        //urlBuilder.setParameter("custom","hello world");
        //urlBuilder.setParameter("hello world","custom");
        //urlBuilder.setParameter("custom","value");
        //urlBuilder.setHttps(false);
        //urlBuilder.setParameter("custom2","value2");
        //urlBuilder.setParameter(RESIZE, RESIZE_NONE);
        //urlBuilder.setParameter(CROP_MODE, CROP_CENTER);
        //urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_DEFAULT);
        //urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_MILD);
        //urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_AGGRESSIVE);
        //urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_NONE);



        //urlBuilder.setParameter(WIDTH,"200");
        //urlBuilder.setParameter(HEIGHT,"300");



        System.out.println(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"));

    }
}
