package net.dexecure.dexassets.lib;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static net.dexecure.dexassets.lib.DexcureUrlConstants.CROP_MODE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.HEIGHT;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_AGGRESSIVE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_DEFAULT;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_MILD;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_MODE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.OPTIMIZATION_NONE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.RESIZE;
import static net.dexecure.dexassets.lib.DexcureUrlConstants.WIDTH;

public class DexecureURLBuilder {

    private String domain;
    private String path;
    private boolean isHttps;
    private Map<String, String> parameters;
    private static String url;

    public DexecureURLBuilder(String domain) {
        this.domain = domain;
        isHttps = true;
        parameters = new LinkedHashMap<>();
    }

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
        String b64EncodedString = new String(stringBytes);

        b64EncodedString = b64EncodedString.replace("=", "");
        b64EncodedString = b64EncodedString.replace('/', '_');
        b64EncodedString = b64EncodedString.replace('+', '-');

        return b64EncodedString;
    }

    public String createURL(String path) {
        List<String> queryPairs = new ArrayList<>();

        if (!path.startsWith("/")) {
            path = "/" + path;
        }

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
                    // ?resize=none
                    queryPairs.add(RESIZE + "=" + v);
                    break;
                case OPTIMIZATION_MODE:
                    queryPairs.add(OPTIMIZATION_MODE + "=" + v);
                    break;
                case CROP_MODE:
                    queryPairs.add(v);
                    break;
                case WIDTH:
                case HEIGHT:
                    if (queryPairs.contains("resize_c")) {
                        queryPairs.remove("resize_c");
                        if (queryPairs.contains(url)) {
                            queryPairs.add(k + encodedValue);
                        } else {
                            queryPairs.add("resize_c=" + k + encodedValue);
                            url = "resize_c=" + k + encodedValue;
                        }
                    } else {
                        if (queryPairs.contains(url)) {
                            queryPairs.add(k + encodedValue);
                        } else {
                            queryPairs.add("resize=" + k + encodedValue);
                            url = "resize=" + k + encodedValue;
                        }
                    }
                    break;
                default:
                    String encodedKey = encodeURIComponent(k);
                    queryPairs.add(encodedKey + "=" + encodedValue);
                    break;
            }
        }

        String query = joinList(queryPairs);

        String decodedPath = DexecureURLBuilder.decodeURIComponent(path.substring(1));

        if (decodedPath.startsWith("http://") || decodedPath.startsWith("https://")) {
            path = "/" + DexecureURLBuilder.encodeURIComponent(decodedPath);
        }

        return buildURL(domain, path, query);
    }

    public void setHttps(boolean useHttps) {
        this.isHttps = useHttps;
    }

    private String buildURL(String host, String path, String query) {
        String scheme = this.isHttps ? "https" : "http";
        String url = String.format("%s://%s%s?%s", scheme, host, path, query);
        if (url.endsWith("#")) {
            url = url.substring(0, url.length() - 1);
        }

        if (url.endsWith("?")) {
            url = url.substring(0, url.length() - 1);
        }
        return url;
    }

    //TODO it is used to check , and &  delimiter append in url
    private static String joinList(List<String> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();

        if (arrayList.size() > 1) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).charAt(0) == 'w') {
                    if (i == arrayList.size() - 1) {
                        stringBuilder.append(arrayList.get(i));
                    } else {
                        stringBuilder.append(arrayList.get(i) + ",");
                    }
                } else if (arrayList.get(i).charAt(0) == 'h') {
                    if (i == arrayList.size() - 1) {
                        stringBuilder.append(arrayList.get(i));
                    } else {
                        stringBuilder.append(arrayList.get(i) + ",");
                    }
                } else if (url != null) {
                    if (arrayList.get(i).contains(url)) {
                        if (i == arrayList.size() - 1) {
                            stringBuilder.append(arrayList.get(i));
                        } else {
                            stringBuilder.append(arrayList.get(i) + ",");
                        }
                    } else {
                        if (i == arrayList.size() - 1) {
                            stringBuilder.append(arrayList.get(i));
                        } else {
                            stringBuilder.append(arrayList.get(i) + "&");
                        }
                    }
                } else {
                    if (i == arrayList.size() - 1) {
                        stringBuilder.append(arrayList.get(i));
                    } else {
                        stringBuilder.append(arrayList.get(i) + "&");
                    }
                }
            }
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                if (i == arrayList.size() - 1) {
                    stringBuilder.append(arrayList.get(i));
                } else {
                    stringBuilder.append(arrayList.get(i) + "&");
                }
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
