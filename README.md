Android SDK for Dexecure

[ ![Download](https://api.bintray.com/packages/dexecure/maven/dexecure-android/images/download.svg?version=0.0.3) ](https://bintray.com/dexecure/maven/dexecure-android/0.0.1/link)


A Java client library for generating URLs with [Dexecure](https://dexecure.com).

# Dependencies

The library itself has no external dependencies. Although if you want to build from source (or run tests) then you need ant and the JDK 1.6+.

# Install Options

# Gradle & JCenter
To add Dexecure-Java to your project, include the following in your project's build.gradle:

```
dependencies {

   compile 'net.dexecure:dexecure-android:0.0.3'
  
}
```

And if this is your first external JCenter dependency you'll need to add, again to your project level build.gradle, the following:

```
buildscript {

    repositories {
    
        google()
        
        jcenter()
        
    }
}
```

# Running Tests

To run tests clone this project and run:

```gradle test```

# Basic Usage

To begin creating dexecure URLs programmatically, simply add the jar to your project's classpath and import the dexecure library. The URL builder can be reused to create URLs for any images on the domains it is provided.

```
import net.dexecure.DexecureURLBuilder;
import static net.dexecure.DexcureURLConstants.OPTIMIZATION_MILD;
import static net.dexecure.DexcureURLConstants.OPTIMIZATION_MODE;


public class DexecureExample  {

    public static void main(String[] args) {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        
        // prints out https://beek.dexecure.net/photos/248797/pexels-photo-248797.jpeg
        System.out.println(urlBuilder.createURL("/photos/248797/pexels-photo-248797.jpeg"));
        
        // prints out https://beek.dexecure.net/photos/248797/another-photo.jpeg
        System.out.println(urlBuilder.createURL("/photos/248797/another-photo.jpeg"));
    }
}
```

# Advanced Usage

```
import net.dexecure.DexecureURLBuilder;
import static net.dexecure.DexcureURLConstants.OPTIMIZATION_MILD;
import static net.dexecure.DexcureURLConstants.OPTIMIZATION_MODE;


public class DexecureExample  {

    public static void main(String[] args) {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        // You can set other global options here
        // urlBuilder.setHttps(false);
        // urlBuilder.setParameter(WIDTH,"200");
        // urlBuilder.setParameter(HEIGHT,"300");
        // urlBuilder.setParameter("custom","value");
        // urlBuilder.setParameter(RESIZE, RESIZE_NONE);
        // urlBuilder.setParameter(CROP_MODE, CROP_CENTER);
        // urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_DEFAULT);
        // urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_AGGRESSIVE);
        // urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_NONE);
        urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_MILD);


        // prints out https://beek.dexecure.net/photos/248797/pexels-photo-248797.jpeg?opt=mild
        System.out.println(urlBuilder.createURL("/photos/248797/pexels-photo-248797.jpeg"));
    }
}
```

For an sample app, check [here](https://github.com/Dexecure/android-sdk/tree/master/app) and see [our test suite](https://github.com/Dexecure/android-sdk/blob/master/lib/src/test/java/net/dexecure/UnitTest.java) for other examples of using our SDK
