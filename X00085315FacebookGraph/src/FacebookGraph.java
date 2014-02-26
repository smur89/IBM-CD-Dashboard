//Shane Murphy - X00085315

import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class FacebookGraph extends PApplet {

    String FILTER = "Kevin";

    String fbAccessToken = "Get Access Toke from graph explorer or other";
    String fbUserID = "632815226";
    String fbServer = "https://graph.facebook.com";
    Node[] nodes;
    int height = 900;
    int width = 900;
    int xCentre = width/2;
    int yCentre = height/2;
    int radius = 250;
    int l;
    float deviation = 100;

    public void setup ()
    {
        frameRate(2);
        smooth();
        size(height,width);
        textAlign( CENTER );

        String response = fbCallMethod( new String[] {
                fbUserID,
                "friends"
        });
        if ( response == null )  // an error occured
        {
            exit();
            return;
        }
        //Split String into JSON Array and take JSON Objects for each friend out of this array.
        JSONObject jsonFriends = JSONObject.parse(response);
        JSONArray jsonArr = jsonFriends.getJSONArray("data");

        // insert json into array
        nodes = getNodeArray(jsonArr);
    }

    public void draw ()
    {
        background(255);
        nodes[0].drawNode();
        for(int i = 1; i < l; i++){
            if(nodes[i].name.contains(FILTER)){
                nodes[i].xcoord += random(-1, 1);
                nodes[i].ycoord += random(-1, 1);
                nodes[i].drawNode();
                stroke(0, 15);
                line(nodes[0].xcoord, nodes[0].ycoord, nodes[i].xcoord, nodes[i].ycoord);
            }
        }
    }

    public void mouseClicked() {
        for (int i = 0; i < nodes.length; i++) {
            if (dist(mouseX, mouseY, nodes[i].xcoord, nodes[i].ycoord) < nodes[i].radius / 2) {
                if (!nodes[i].selected) {
                    nodes[i].selected = true;
                } else {
                    nodes[i].selected = false;
                }
            }
        }
    }

    public void mouseDragged() {
        for (int i = 0; i < nodes.length; i++) {
            if (dist(mouseX, mouseY, nodes[i].xcoord, nodes[i].ycoord) < nodes[i].radius / 2) {
                nodes[i].xcoord = mouseX;
                nodes[i].ycoord = mouseY;
            }
        }
    }

    // create new nodes with json results
    private Node[] getNodeArray(JSONArray jsonArr) {
        l = jsonArr.size();
        nodes = new Node[l+1];
        nodes[0] = new Node(fbUserID, "Shane Murphy",  xCentre, yCentre, 75);
        nodes[0].color = color(255,255,255);
        for(int i = 0; i < l; i++){
            nodes[i+1] = new Node(jsonArr.getJSONObject(i).getString("id"),
                    jsonArr.getJSONObject(i).getString("name"),
                    (xCentre+(radius * (float)Math.cos(i*(2*Math.PI)/l))),
                    (yCentre+(radius * (float)Math.sin(i*(2*Math.PI)/l))),
                    75
            );
        }
        return nodes;
    }

    public String fbCallMethod ( String[] args )
    {
        String[] params = new String[args.length];
        System.arraycopy( args, 0, params, 0, args.length );
        String paramString = join( params, "/" );
        String[] lines = loadStrings( fbServer + "/" + paramString + "?access_token=" + fbAccessToken);

        if ( lines == null )
        {
            println( "No response from:\n" + fbServer + "/" + paramString );
            return null;
        }
        return join( lines, "\n" );
    }

    //Node class
    class Node{
        float xcoord, ycoord, radius, tempX, tempY, alpha, tempRadius;
        String name;
        String id;
        String pic;
        int color;
        boolean selected;


        Node(String id, String name, float xcoord, float ycoord, float radius){
            this.name = name;
            this.id = id;
            this.xcoord = xcoord+random(-deviation,deviation);
            this.ycoord = ycoord+random(-deviation,deviation);
            this.color = color(random(1, 255), random(1, 255), random(1, 255));
            this.radius = radius;
            this.alpha = random(50, 90);
            this.selected = false;
            this.tempX = xcoord+random(-deviation,deviation);
            this.tempY = ycoord+random(-deviation,deviation);
            this.tempRadius = radius;
        }

        public void drawNode(){
            fill(color, alpha);
            ellipse(xcoord,ycoord,radius,radius);
            //only get pic when drawing node to save loading pics for all nodes when not needed - expensive call
            getPic();
            PImage img = loadImage(pic);
            if (selected) {
                fill(255, 255, 255);
                text(name, xcoord, ycoord, 100);
                this.radius = width/8;
                this.xcoord = xCentre;
                this.ycoord = yCentre;
                this.alpha = 50;
            } else {
                text(name, xcoord, ycoord+50, 100);
                image(img,xcoord-25,ycoord-25);

                this.alpha = 150;
                this.xcoord = tempX;
                this.ycoord = tempY;
                this.radius = tempRadius;

            }
        }

        //Get pic for user.
        public void getPic (){
            String[] pict = loadStrings( fbServer + "/" + id + "/picture?redirect=false");
            if ( pict == null )
            {
                println( "No response from:\n" + fbServer + "/" + id + "/picture?redirect=false");
                return;
            }
            String json =  join( pict, "\n" );
            JSONObject jsonPics = JSONObject.parse(json);
            pic = jsonPics.getJSONObject("data").getString("url");
        }
    }
}