package net.dexecure.dexassets.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import net.dexecure.DexecureURLBuilder;

import static net.dexecure.DexcureURLConstants.CROP_CENTER;
import static net.dexecure.DexcureURLConstants.CROP_MODE;
import static net.dexecure.DexcureURLConstants.HEIGHT;
import static net.dexecure.DexcureURLConstants.OPTIMIZATION_AGGRESSIVE;
import static net.dexecure.DexcureURLConstants.OPTIMIZATION_DEFAULT;
import static net.dexecure.DexcureURLConstants.OPTIMIZATION_MILD;
import static net.dexecure.DexcureURLConstants.OPTIMIZATION_MODE;
import static net.dexecure.DexcureURLConstants.OPTIMIZATION_NONE;
import static net.dexecure.DexcureURLConstants.RESIZE;
import static net.dexecure.DexcureURLConstants.RESIZE_NONE;
import static net.dexecure.DexcureURLConstants.WIDTH;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");

        //urlBuilder.setParameter(WIDTH,"200");
        //urlBuilder.setParameter(HEIGHT,"300");

        //urlBuilder.setParameter("custom","hello world");
        //urlBuilder.setParameter("hello world","yes");
        //urlBuilder.setParameter("custom","value");
        //urlBuilder.setHttps(false);
        //urlBuilder.setParameter("custom2","value2");
        //urlBuilder.setParameter(RESIZE, RESIZE_NONE);
        //urlBuilder.setParameter(CROP_MODE, CROP_CENTER);
        //urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_DEFAULT);
        //urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_MILD);
        //urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_AGGRESSIVE);
        //urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_NONE);

        //urlBuilder.setParameter("opt", "default");


        //urlBuilder.setParameter(WIDTH,"200");
        //urlBuilder.setParameter(HEIGHT,"250");

        //Merged code commited



        System.out.println(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"));

    }
}
