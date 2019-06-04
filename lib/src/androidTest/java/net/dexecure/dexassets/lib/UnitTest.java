package net.dexecure.dexassets.lib;

import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.dexecure.dexassets.lib.DexcureUrlConstants.RESIZE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.RESIZE_NONE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.HEIGHT;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_MODE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_AGGRESSIVE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_DEFAULT;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_MILD;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_NONE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.CROP_MODE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.CROP_CENTER;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.WIDTH;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("deprecation")
@RunWith(AndroidJUnit4.class)
public class UnitTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void urlBuildOriginalPath() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", true);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg");
    }

    @Test
    public void urlBuildOriginalPathUsingSchema() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", false);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "http://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg");
    }

    @Test
    public void urlBuildPathUsingParamsWidth() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(WIDTH, "300");
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", false, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "http://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=w300");
    }

    @Test
    public void urlBuildPathUsingParamsHeight() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(HEIGHT, "300");
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", true, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=h300");
    }

    @Test
    public void urlBuildPathUsingParamsHeightWidth() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(HEIGHT, "200");
        params.put(WIDTH, "300");
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", true, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=h200,w300");
    }

    @Test
    public void urlBuildPathUsingParamsWidthHeight() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(WIDTH, "300");
        params.put(HEIGHT, "200");
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", false, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "http://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=w300,h200");
    }

    @Test
    public void urlBuildResizeCenterCropHeight() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(CROP_MODE, CROP_CENTER);
        params.put(HEIGHT, "200");
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", true, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize_c=h200");
    }

    @Test
    public void urlBuildResizeCenterCropWidth() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(CROP_MODE, CROP_CENTER);
        params.put(WIDTH, "300");
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", false, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "http://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize_c=w300");
    }

    @Test
    public void urlBuildResizeCenterCropWidthHeight() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(CROP_MODE, CROP_CENTER);
        params.put(WIDTH, "300");
        params.put(HEIGHT, "200");
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", true, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize_c=w300,h200");
    }

    @Test
    public void urlBuildResizeCenterCropHeightWidth() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(CROP_MODE, CROP_CENTER);
        params.put(HEIGHT, "200");
        params.put(WIDTH, "300");
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", true, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize_c=h200,w300");
    }

    @Test
    public void urlBuildDisableResize() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(RESIZE, RESIZE_NONE);
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", false, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "http://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=none");
    }

    @Test
    public void urlBuildOptimizationDefault() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(OPTIMIZATION_MODE, OPTIMIZATION_DEFAULT);
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", true, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?opt=default");
    }

    @Test
    public void urlBuildOptimizationMild() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(OPTIMIZATION_MODE, OPTIMIZATION_MILD);
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", true, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?opt=mild");
    }

    @Test
    public void urlBuildOptimizationAggressive() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(OPTIMIZATION_MODE, OPTIMIZATION_AGGRESSIVE);
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", false, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "http://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?opt=aggressive");
    }

    @Test
    public void urlBuildOptimizationNone() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(OPTIMIZATION_MODE, OPTIMIZATION_NONE);
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", false, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "http://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?opt=none");
    }

    @Test
    public void urlBuildAnyStringInParam() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("custom", "value");
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", true, params);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?custom=value");
    }

    @Test
    public void urlBuildWithNumberInParam() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", true);
        urlBuilder.setParameter(HEIGHT, 200);
        urlBuilder.setParameter(WIDTH, 300);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=h200,w300");
    }

}