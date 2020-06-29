package com.aca.narekhakobyan.homework1.items.functionality;


import com.aca.narekhakobyan.homework1.items.functionality.format.FormatVideo;
import com.aca.narekhakobyan.homework1.items.functionality.quality.VideoQuality;

public interface Video {
    FormatVideo getVideoFormat();
    VideoQuality getVideoQuality();
}
