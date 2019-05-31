Android SDK for Dexecure

[ ![Download](https://api.bintray.com/packages/dexecure/maven/android-sdk/images/download.svg?version=0.0.1) ](https://bintray.com/dexecure/maven/android-sdk/0.0.1/link)


A Java client library for generating URLs with dexecure. dexecure is a high-performance distributed image processing service. More information can be found at https://dexassets.dexecure.net/

# Dependencies

The library itself has no external dependencies. Although if you want to build from source (or run tests) then you need ant and the JDK 1.6+.

# Install Options

# Gradle & JCenter
To add Dexecure-Java to your project, include the following in your project's build.gradle:


dependencies {

   compile 'net.dexecure.dexassets:lib:0.0.1'
  
}


And if this is your first external JCenter dependency you'll need to add, again to your project level build.gradle, the following:


buildscript {

    repositories {
    
        google()
        
        jcenter()
        
    }
}

# Running Tests

To run tests clone this project and run:

gradle test

Dependencies for running tests (junit, etc) are provided (in android-sdk/lib/src/androidTest/java/net/dexecure/dexassets/lib/ and referenced in the build config).

# Basic Usage

To begin creating dexecure URLs programmatically, simply add the jar to your project's classpath and import the dexecure library. The URL builder can be reused to create URLs for any images on the domains it is provided.


package net.dexecure.dexassets.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import net.dexecure.dexassets.dexecurelib.DexecureURLBuilder;

import java.util.LinkedHashMap;

import java.util.Map;

import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.HEIGHT;

import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.WIDTH;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> params = new LinkedHashMap<>();
        params.put(RESIZE, "");
        params.put(HEIGHT, "200");
        params.put(WIDTH, "300");

        DexecureURLBuilder urlMaker = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg",false,params);
        System.out.println(urlMaker.getURL());
    }
}

// Prints out:
// https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=h200,w300


For HTTPS support, simply pass true in DexecureURLBuilder() constructor on the builder like : -

 DexecureURLBuilder urlMaker = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg",true,params);
 
 # For use all types of URL you can simply use like :- uncomment one by one, but only two URLs RESIZE &   RESIZE_WITH_CENTER_CROP we pass height and width and for remaining you can use only 
 
 Map<String, String> params = new LinkedHashMap<>();
 
 params.put(DISABLE_RESIZE,"");
         
         OR
         
 Map<String, String> params = new LinkedHashMap<>();
 
 params.put(OPTIMIZATION_DEFAULT, "");
 
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


        params.put(HEIGHT, "200");
        params.put(WIDTH, "300");

        //params.put("sdfsdfcd", "plkgdj");

        DexecureURLBuilder urlMaker = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg",true,params);
        System.out.println(urlMaker.getURL());

    }
