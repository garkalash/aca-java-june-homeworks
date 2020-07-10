package items.functionality;

import items.functionality.quality.VideoQuality;

public interface Video {
    boolean playVideo();
    String getVideoFormat();
    VideoQuality getVideoQuality();
}
