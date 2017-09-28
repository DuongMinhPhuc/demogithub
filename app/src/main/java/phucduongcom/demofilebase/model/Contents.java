package phucduongcom.demofilebase.model;

/**
 * Created by phucd on 9/28/2017.
 */

public class Contents {
    private  String title;
    private  String image;
    private  String description;

    public Contents(String title, String image, String description) {
        this.title = title;
        this.image = image;
        this.description = description;
    }

    public Contents() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String
    toString() {
        return "Contents{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
