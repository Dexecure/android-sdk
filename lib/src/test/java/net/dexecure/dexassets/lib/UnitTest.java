package net.dexecure.dexassets.lib;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static net.dexecure.dexassets.lib.DexcureUrlConstants.CROP_CENTER;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.CROP_MODE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.HEIGHT;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_AGGRESSIVE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_DEFAULT;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_MILD;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_MODE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_NONE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.RESIZE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.RESIZE_NONE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.WIDTH;
import static org.junit.Assert.assertEquals;

public class UnitTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void urlBuildOriginalPath() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg");
    }

    @Test
    public void urlBuildOriginalPathUsingSchema() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg");
    }

    @Test
    public void urlBuildPathUsingParamsWidth() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter(WIDTH, "300");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=w300");
    }

    @Test
    public void urlBuildPathUsingParamsHeight() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter(HEIGHT, "300");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=h300");
    }

    @Test
    public void urlBuildPathUsingParamsHeightWidth() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter(HEIGHT, "200");
        urlBuilder.setParameter(WIDTH, "300");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=h200,w300");
    }

    @Test
    public void urlBuildPathUsingParamsWidthHeight() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter(WIDTH, "300");
        urlBuilder.setParameter(HEIGHT, "200");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=w300,h200");
    }

    @Test
    public void urlBuildResizeCenterCropHeight() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter(CROP_MODE, CROP_CENTER);
        urlBuilder.setParameter(HEIGHT, "200");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize_c=h200");
    }

    @Test
    public void urlBuildResizeCenterCropWidth() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter(CROP_MODE, CROP_CENTER);
        urlBuilder.setParameter(WIDTH, "300");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize_c=w300");
    }

    @Test
    public void urlBuildResizeCenterCropWidthHeight() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter(CROP_MODE, CROP_CENTER);
        urlBuilder.setParameter(WIDTH, "300");
        urlBuilder.setParameter(HEIGHT, "200");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize_c=w300,h200");
    }

    @Test
    public void urlBuildResizeCenterCropWidthHeightWithoutConstants() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter("resize_c", "w300,h200");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize_c=w300%2Ch200");
    }

    @Test
    public void urlBuildDisableResize() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter(RESIZE, RESIZE_NONE);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?resize=none");
    }

    @Test
    public void urlBuildOptimizationDefault() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_DEFAULT);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?opt=default");
    }

    @Test
    public void urlBuildOptimizationDefaultWithoutConstants() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter("opt", "default");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?opt=default");
    }

    @Test
    public void urlBuildOptimizationMild() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_MILD);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?opt=mild");
    }

    @Test
    public void urlBuildOptimizationAggressive() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_AGGRESSIVE);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?opt=aggressive");
    }

    @Test
    public void urlBuildOptimizationNone() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_NONE);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?opt=none");
    }

    @Test
    public void urlBuildCustomQueryInParam() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter("custom", "value");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?custom=value");
    }

    @Test
    public void urlBuildCustomQueriesInParam() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter("custom", "value");
        urlBuilder.setParameter("custom2", "value2");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?custom=value&custom2=value2");
    }

    @Test
    public void urlBuildCustomQueryAndResize() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter("custom", "value");
        urlBuilder.setParameter(WIDTH, "200");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?custom=value&resize=w200");
    }

    @Test
    public void urlBuildCustomQueryAndOptMode() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter("custom", "value");
        urlBuilder.setParameter(OPTIMIZATION_MODE, OPTIMIZATION_MILD);
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?custom=value&opt=mild");
    }

    @Test
    public void urlBuildCustomQueryAndCenterCrop() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter("custom", "value");
        urlBuilder.setParameter(CROP_MODE, CROP_CENTER);
        urlBuilder.setParameter(HEIGHT, "250");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?custom=value&resize_c=h250");
    }

    @Test
    public void urlBuildHTTPURL() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setHttps(false);
        urlBuilder.setParameter("custom", "value");
        urlBuilder.setParameter(CROP_MODE, CROP_CENTER);
        urlBuilder.setParameter(HEIGHT, "250");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "http://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?custom=value&resize_c=h250");
    }

    @Test
    public void urlBuildRelativeURL() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setHttps(false);
        urlBuilder.setParameter("custom", "value");
        urlBuilder.setParameter(CROP_MODE, CROP_CENTER);
        urlBuilder.setParameter(HEIGHT, "250");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "http://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?custom=value&resize_c=h250");
    }

    @Test
    public void urlBuildParamIsEscaped() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter("custom", "hello world");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?custom=hello%20world");
    }


    @Test
    public void urlBuildParamValueIsEscaped() {
        DexecureURLBuilder urlBuilder = new DexecureURLBuilder("beek.dexecure.net");
        urlBuilder.setParameter("hello world", "yes");
        System.out.println(urlBuilder);
        assertEquals(urlBuilder.createURL("/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg"), "https://beek.dexecure.net/proxy/https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?hello%20world=yes");
    }
}

