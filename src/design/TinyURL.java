package design;

import bits.Bits;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TinyURL {
    private char [] charMap = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                                          'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                                          '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) throws Exception {
        System.out.println("Long URL=" + args[0]);

        TinyURL tinyURL = new TinyURL();
        String shortURL = tinyURL.getTinyURL(args[0]);

        System.out.println("Short URL=" + shortURL);
    }

    public String getTinyURL(String longURL) throws Exception {
        getRandom43Bits(longURL);
        return longURL;
    }

    public void getRandom43Bits(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bytesOfMessage = input.getBytes("UTF-8");

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        byte clearFirst5Bits = 7;
        thedigest[6] = (byte)(thedigest[6] & clearFirst5Bits);

        long value = 0;
        for (int i = 0; i<6; i++) {
            value += ((long) thedigest[i] & 0xffL) << (8 * i);
        }

        System.out.println(convertDecToBase(value, 65));
    }

    public String convertDecToBase(long number, int base) {
        String result = "";

        long quotient = number;

        while (quotient > 0) {
            result = quotient % base + "," + result;
            quotient = quotient / base;
        }

        return result;
    }


}