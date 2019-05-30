package net.dexecure.dexassets.dexecurelib;

import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.DISABLE_RESIZE;
import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.HEIGHT;
import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.OPTIMIZATION_AGGRESSIVE;
import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.OPTIMIZATION_DEFAULT;
import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.OPTIMIZATION_MILD;
import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.OPTIMIZATION_NONE;
import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.RESIZE;
import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.RESIZE_WITH_CENTER_CROP;
import static net.dexecure.dexassets.dexecurelib.DexcureUrlConstants.WIDTH;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("deprecation")
@RunWith(AndroidJUnit4.class)
public class UnitTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void urlBuildOriginalPath() {
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg");
        assertEquals(urlMaker.getURL(), "http://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg");
    }

    @Test
    public void urlBuildOriginalPathUsingSchema() {
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https");
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg");
    }

    @Test
    public void urlBuildPathUsingParamsWidth() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(RESIZE, "");
        params.put(WIDTH, "300");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=w300");
    }

    @Test
    public void urlBuildPathUsingParamsHeight() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(RESIZE, "");
        params.put(HEIGHT, "300");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=h300");
    }

    @Test
    public void urlBuildPathUsingParamsHeightWidth() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(RESIZE, "");
        params.put(HEIGHT, "200");
        params.put(WIDTH, "300");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=h200,w300");
    }

    @Test
    public void urlBuildPathUsingParamsWidthHeight() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(RESIZE, "");
        params.put(WIDTH, "300");
        params.put(HEIGHT, "200");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=w300,h200");
    }

    @Test
    public void urlBuildResizeCenterCropHeight() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(RESIZE_WITH_CENTER_CROP, "");
        params.put(HEIGHT, "200");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize_c=h200");
    }

    @Test
    public void urlBuildResizeCenterCropWidth() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(RESIZE_WITH_CENTER_CROP, "");
        params.put(WIDTH, "300");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize_c=w300");
    }

    @Test
    public void urlBuildResizeCenterCropWidthHeight() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(RESIZE_WITH_CENTER_CROP, "");
        params.put(WIDTH, "300");
        params.put(HEIGHT, "200");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize_c=w300,h200");
    }

    @Test
    public void urlBuildResizeCenterCropHeightWidth() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(RESIZE_WITH_CENTER_CROP, "");
        params.put(HEIGHT, "200");
        params.put(WIDTH, "300");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize_c=h200,w300");
    }

    @Test
    public void urlBuildDisableResize() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(DISABLE_RESIZE, "");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=none");
    }

    @Test
    public void urlBuildOptimizationDefault() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(OPTIMIZATION_DEFAULT, "");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?opt=default");
    }

    @Test
    public void urlBuildOptimizationMild() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(OPTIMIZATION_MILD, "");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?opt=mild");
    }

    @Test
    public void urlBuildOptimizationAggressive() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(OPTIMIZATION_AGGRESSIVE, "");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?opt=aggressive");
    }

    @Test
    public void urlBuildOptimizationNone() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(OPTIMIZATION_NONE, "");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?opt=none");
    }

    @Test
    public void urlBuildAnyStringInParam() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("sdfsdfcd", "plkgdj");
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https", params);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?sdfsdfcdplkgdj");
    }

    @Test
    public void urlBuildWithNumberInParam() {
        DexecureUrlMaker urlMaker = new DexecureUrlMaker("beek.dexecure.net", "/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg", "https");
        urlMaker.setParameter(HEIGHT, 200);
        urlMaker.setParameter(WIDTH, 300);
        assertEquals(urlMaker.getURL(), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?h200w300");
    }

}
