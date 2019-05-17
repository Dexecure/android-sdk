package net.dexecure.dexassets.lib;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static net.dexecure.dexassets.lib.DexcureUrlConstants.DISABLE_RESIZE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.HEIGHT;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_AGGRESSIVE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_DEFAULT;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_MILD;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_NONE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.RESIZE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.RESIZE_WITH_CENTER_CROP;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.WIDTH;

public class DexecureURLBuilder {

    private String domain;
    private String path;
    private boolean useHttps;
    private Map<String, String> parameters;

    public DexecureURLBuilder(String domain, String path, boolean useHttps, Map<String, String> parameters) {
        this.domain = domain;
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        this.path = path;
        this.useHttps = useHttps;
        this.parameters = parameters;
    }

    public DexecureURLBuilder(String domain, String path, boolean useHttps) {
        this(domain, path, useHttps, new LinkedHashMap<String, String>());
    }

//    public DexecureURLBuilder(String domain, String path) {
//        this(domain, path, useHttps);
//    }

    public void setParameter(String key, String value) {
        if (value != null && value.length() > 0) {
            parameters.put(key, value);
        } else {
            parameters.remove(key);
        }
    }

    public void setParameter(String key, Number value) {
        setParameter(key, String.valueOf(value));
    }

    public void deleteParameter(String key) {
        setParameter(key, "");
    }

    private String encodeBase64(String str) {
        byte[] stringBytes = str.getBytes();
        String b64EncodedString = new String(Base64.getEncoder().encode(stringBytes));

        b64EncodedString = b64EncodedString.replace("=", "");
        b64EncodedString = b64EncodedString.replace('/', '_');
        b64EncodedString = b64EncodedString.replace('+', '-');

        return b64EncodedString;
    }

    public String getURL() {
        List<String> queryPairs = new LinkedList<>();

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();

            String encodedValue;

            if (k.endsWith("64")) {
                encodedValue = encodeBase64(v);
            } else {
                encodedValue = encodeURIComponent(v);
            }

            switch (k) {
                case RESIZE:
                    queryPairs.add(k);
                    break;
                case RESIZE_WITH_CENTER_CROP:
                    queryPairs.add(k);
                    break;
                case DISABLE_RESIZE:
                    queryPairs.add(k);
                    break;
                case OPTIMIZATION_DEFAULT:
                    queryPairs.add(k);
                    break;
                case OPTIMIZATION_MILD:
                    queryPairs.add(k);
                    break;
                case OPTIMIZATION_AGGRESSIVE:
                    queryPairs.add(k);
                    break;
                case OPTIMIZATION_NONE:
                    queryPairs.add(k);
                    break;
                case WIDTH:
                    queryPairs.add(k + encodedValue);
                    break;
                case HEIGHT:
                    queryPairs.add(k + encodedValue);
                    break;
                default:
                    queryPairs.add(k + encodedValue);
            }

        }

        String query = joinList(queryPairs, ",");
        String decodedPath = DexecureURLBuilder.decodeURIComponent(path.substring(1));
        if (decodedPath.startsWith("http://") || decodedPath.startsWith("https://")) {
            path = "/" + DexecureURLBuilder.encodeURIComponent(decodedPath);
        }
        return buildURL(domain, path, query);
    }

    public void setUseHttps(boolean useHttps) {
        this.useHttps = useHttps;
    }

    @Override
    public String toString() {
        return getURL();
    }

    private String buildURL(String host, String path, String query) {
        String scheme = this.useHttps ? "https" : "http";
        String url = String.format("%s://%s%s?%s", scheme, host, path, query);
        if (url.endsWith("#")) {
            url = url.substring(0, url.length() - 1);
        }

        if (url.endsWith("?")) {
            url = url.substring(0, url.length() - 1);
        }
        return url;
    }


    //TODO it is used to check comma delimeter to append in url
    private static String joinList(List<String> arrayList, String separator) {
        StringBuilder stringBuilder = new StringBuilder();
        String sep = "";

        if (arrayList.size() > 2) {
            for (String str : arrayList) {

                if (str.charAt(0) == 'w') {
                    if (stringBuilder.toString().contains(sep))
                        stringBuilder.append(str);
                    else
                        stringBuilder.append(str).append(sep);
                } else if (str.charAt(0) == 'h') {
                    if (stringBuilder.toString().contains(sep))
                        stringBuilder.append(str);
                    else
                        stringBuilder.append(str).append(sep);
                } else {
                    stringBuilder.append(str);
                }
                sep = separator;
            }
        } else {
            for (String str : arrayList) {
                stringBuilder.append(str);
            }
        }

        return stringBuilder.toString();
    }


    public static String encodeURIComponent(String s) {
        String result = null;

        try {
            result = URLEncoder.encode(s, "UTF-8")
                    .replaceAll("\\+", "%20")
                    .replaceAll("\\%21", "!")
                    .replaceAll("\\%27", "'")
                    .replaceAll("\\%28", "(")
                    .replaceAll("\\%29", ")")
                    .replaceAll("\\%7E", "~");
        } catch (UnsupportedEncodingException e) {
            result = s;
        }

        return result;
    }

    public static String decodeURIComponent(String s) {
        if (s == null) {
            return null;
        }

        String result = null;
        try {
            result = URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            result = s;
        }

        return result;
    }

}
