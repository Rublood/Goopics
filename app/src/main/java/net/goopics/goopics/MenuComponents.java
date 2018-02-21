package net.goopics.goopics;

public class MenuComponents {
    private String aName;
    private int image;

    public MenuComponents(String aName , int ressource){
        setImage(ressource);
        setName(aName);
    }

    public String getName() {
        return aName;
    }

    public void setName(String aName) {
        this.aName = aName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}