package enums;

public enum RecordType {
    MP4("Video MP4"),
    VGA("VGA"),
    MP3("Record MP3"),
    HD("HD");

    private final String type;

    RecordType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
