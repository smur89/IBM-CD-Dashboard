import java.security.MessageDigest;
import java.lang.System.*;

public class Digest {

    public static String digest() {
        String digest = null;
        try {
            String username = "test";
            String password = "secret";
            String realm = "osXstream.local";
            String nonce = "392616736";
            String cnonce = "05E0A6E7-0B7B-4430-9549-0FE1C244ABAB";
            String nc = "00000001";
            String qop = "auth";
            String digestUri = "xmpp/osXstream.local";
            String response = "37991b870e0f6cc757ec74c47877472b";
//step 1
/*
Combine username:realm:password and md5 hash them.
So we hash "test:osXstream.local:secret" (without the quotes) and store the result in a variable called HA1data.

Here's the trick - normally when you hash stuff you get a result in hex values. But we don't want this result as a string of hex values! We need to keep the result as raw data! If you were to do a hex dump of this data you'd find it to be "3a4f5725a748ca945e506e30acd906f0". But remeber, we need to operate on it's raw data, so don't convert it to a string.
*/
//String X = vars.get("username")+":"+vars.get("realm")+":"+"";
//byte[] bytesOfMessage = X.getBytes("UTF-8");
//MessageDigest md = MessageDigest.getInstance("MD5");
//byte[] Y = md.digest(bytesOfMessage);
            String X = username + ":" + realm + ":" + password;
            byte[] bytesOfMessage = X.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] Y = md.digest(bytesOfMessage);

//step 2
/*
We need to combine the result from step 1 with the nonce and cnonce.
So we hash [HA1data]:nonce:cnonce

But wait, the result from step 1 is in raw data format, and the new stuff is a string. So we convert our string ":392616736:05E0A6E7-0B7B-4430-9549-0FE1C244ABAB" into raw utf-8 data, and append this to the end of HA1data.
*/
//String A = ":"+vars.get("nonce")+":"+vars.get("cnonce");
//byte[] ARaw = A.getBytes("UTF-8");
//
//byte[] c = new byte[Y.length + ARaw.length];
//System.arraycopy(Y, 0, c, 0, Y.length);
//System.arraycopy(ARaw, 0, c, Y.length, ARaw.length);
//
//byte[] HA = md.digest(c);

            String A = ":" + nonce + ":" + cnonce;
            byte[] ARaw = A.getBytes("UTF-8");
            byte[] c = new byte[Y.length + ARaw.length];
            System.arraycopy(Y, 0, c, 0, Y.length);
            System.arraycopy(ARaw, 0, c, Y.length, ARaw.length);

            byte[] HA = md.digest(c);

//step 3
/*
Hash the data from step 2, and store it's hex value in a string HA1.
The value of the string will be "b9709c3cdb60c5fab0a33ebebdd267c4".
 */
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < HA.length; i++) {
                sb.append(Integer.toString((HA[i] & 0xff) + 0x100, 16).substring(1));
            }

            String HA1 = sb.toString();

//Step 4
/*
Hash the string AUTHENTICATE:[digest-uri]. So we'll be hashing "AUTHENTICATE:xmpp/osXstream.local", and we store it's hex value in a string HA2.
The value of the string will be "2b09ce6dd013d861f2cb21cc8797a64d".
// */
//String auth = "AUTHENTICATE:xmpp/"+vars.get("realm");
//byte[] authRaw = auth.getBytes("UTF-8");
//byte[] authHash = md.digest(authRaw);
//
//StringBuffer sb1 = new StringBuffer();
//for (int i = 0; i < authHash.length; i++) {
//    sb1.append(Integer.toString((authHash[i] & 0xff) + 0x100, 16).substring(1));
//}
//
//String HA2 = sb1.toString();


            String auth = "AUTHENTICATE:" + digestUri;
            byte[] authRaw = auth.getBytes("UTF-8");
            byte[] authHash = md.digest(authRaw);

            StringBuilder sb1 = new StringBuilder();
            for (int i = 0; i < authHash.length; i++) {
                sb1.append(Integer.toString((authHash[i] & 0xff) + 0x100, 16).substring(1));
            }

            String HA2 = sb1.toString();

//step 5
/*
Hash: HA1:nonce:nc:cnonce:qop:HA2
So we'll be hashing:
b9709c3cdb60c5fab0a33ebebdd267c4:392616736:00000001:05E0A6E7-0B7B-4430-9549-0FE1C244ABAB:auth:2b09ce6dd013d861f2cb21cc8797a64d

Store it's hex value as the result. It should be:
37991b870e0f6cc757ec74c47877472b
 */
//String predigest = HA1+":"+vars.get("nonce")+":00000001:"+vars.get("cnonce")+":auth:"+HA2;
//byte[] digestBytes = predigest.getBytes("UTF-8");
//byte[] digest1 = md.digest(digestBytes);
//
//StringBuffer sb2 = new StringBuffer();
//for (int i = 0; i < digest1.length; i++) {
//    sb2.append(Integer.toString((digest1[i] & 0xff) + 0x100, 16).substring(1));
//}
//
//String digest = sb2.toString();

            String predigest = HA1 + ":" + nonce + ":" + nc + ":" + cnonce + ":" + qop + ":" + HA2;
            byte[] digestBytes = predigest.getBytes("UTF-8");
            byte[] digest1 = md.digest(digestBytes);

            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < digest1.length; i++) {
                sb2.append(Integer.toString((digest1[i] & 0xff) + 0x100, 16).substring(1));
            }

            digest = sb2.toString();
            System.out.println(digest);

            //vars.putObject("test", predigest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return digest;
    }

    public static void main(String [] args)
    {
        String digest = Digest.digest();
        System.out.println(digest);
    }
}