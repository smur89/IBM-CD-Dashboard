This is a sprite of the two most common sizes of file type icons.
A CSS file is provided with this sprite for accessing the images.
Also, a properties file is provided to expose the coordinates of
the images so you can build your own CSS classes using this sprite.

The 32bit version of this sprite is provided to enable editing
of the sprite by an IBM customer after a product has shipped.
(Even though this technique is not recommended. Overriding
individual CSS classes is the recommended technique for changing
the images displayed in the UI.)  Products should ship both the
32bit and 8bit versions of the sprite. However, the 32bit version
of the sprite should not be used at runtime because IE 6 will not
display it properly and performance will be negatively impacted
due to the 32bit file being larger than the 8bit version.

NOTE: Images contained in this sprite may change at any time.
The coordinates of images in this sprite may change at any time.
Always update the coordinates in your CSS from the properties
file any time you update the sprite image.

