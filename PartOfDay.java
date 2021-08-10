package lesson7;

public class PartOfDay {
    private int icon;
    private String iconPhrase;
    private boolean hasPrecipitation;

    public PartOfDay() {
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public boolean isHasPrecipitation() {
        return hasPrecipitation;
    }
}
