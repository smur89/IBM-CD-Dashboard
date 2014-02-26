import processing.core.*;
import processing.data.XML;

public class FacebookGraph extends PApplet {
    // application api key and secret
    String fbAccessToken = "CAACEdEose0cBAIcnEmLxQssdnhtZBwfvD7JDUEjZAv5aNvgVDdEgrlFwRcuvFxkT0GCSKtqX7UA4KLbDyzZCkC5DZBm8gWtaS98f3pvqeqxfZBlCn2nunkZBeeyqgg0xb2Gx7Qx0eCxERLRPO18ZAIAIu6xOJy4arXEEaZAgvScoFFGSW5LGDgor2ZA7ZCZAMnkqj2pmW6rhqkHWQZDZD";

    // a comma separated (no spaces!) list of user ids
    String fbUserID = "632815226";


    // Facebook RESTful API
    String fbServer = "https://graph.facebook.com";


    XML[] usersXml;

    int currentUser = 0;


    public void setup ()
    {
        size( 300, 200 );

        String response = fbCallMethod( new String[] {
                fbUserID,
                "friends"
        });

        if ( response == null )  // an error occured
        {
            exit();
            return;
        }


        fill( 0 );
        textFont( createFont( "sans-serif", 24 ) );
        textAlign( CENTER );
        frameRate( 1 );
    }


    public void draw ()
    {
        ellipse(10,10,10,10);

    }

    /**
     *  Place a Facebook call (GET request) using Processing API ( loadStrings(), join() )
     */
    public String fbCallMethod ( String[] args )
    {
        String[] params = new String[args.length];
        System.arraycopy( args, 0, params, 0, args.length );

        //String sig = fbGenerateSIG ( params );
        String paramString = join( params, "/" );
        String[] lines = loadStrings( fbServer + "/" + paramString + "?access_token=" + fbAccessToken);

        if ( lines == null )
        {
            println( "No response from:\n" + fbServer + "/" + paramString );
            return null;
        }
        println(join( lines, "\n" ));

        return join( lines, "\n" );
    }
}