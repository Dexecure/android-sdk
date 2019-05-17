package net.dexecure.dexassets.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import net.dexecure.dexassets.dexecurelib.DexecureUrlMaker;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.HEIGHT;
import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.RESIZE;
import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.WIDTH;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> params = new LinkedHashMap<>();
        params.put(RESIZE, "");
        //params.put(RESIZE_WITH_CENTER_CROP, "");
        //params.put(DISABLE_RESIZE,"");
        //params.put(OPTIMIZATION_DEFAULT, "");
        //params.put(OPTIMIZATION_MILD, "");
        //params.put(OPTIMIZATION_AGGRESSIVE, "");
        //params.put(OPTIMIZATION_NONE,"");

        params.put(WIDTH, "300");
        
        params.put(HEIGHT, "200");

        DexecureUrlMaker helper = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        System.out.println(helper.getURL());

    }
}
