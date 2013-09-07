package blighkit.wechat.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.*;

public final class Tools {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String sha1(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            byte[] bytes = messageDigest.digest();
            int len = bytes.length;
            StringBuilder buf = new StringBuilder(len * 2);
            for (int j = 0; j < len; j++) {
                buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
                buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
            }
            return buf.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkSignature(String token, String signature,
                                         String timestamp, String nonce) {
        List<String> params = new ArrayList<String>();
        params.add(token);
        params.add(timestamp);
        params.add(nonce);
        Collections.sort(params, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        String temp = params.get(0) + params.get(1) + params.get(2);
        return sha1(temp).equals(signature);
    }

    public static String inputStream2String(InputStream in)
            throws IOException {
        if (in == null)
            return "";

        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1; ) {
            out.append(new String(b, 0, n, "UTF-8"));
        }
        return out.toString();
    }

    public static Map<String, String> xml2Map(String xml) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            Document document = DocumentHelper.parseText(xml);
            Element list = document.getRootElement();
            List<Element> elements = list.elements();
            for (Element element : elements) {
                map.put(element.getName().trim(), element.getStringValue());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return map;
    }

}