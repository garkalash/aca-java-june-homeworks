package com.aca.narekhakobyan.homework.items.functionality;


import com.aca.narekhakobyan.homework.items.functionality.format.FormatVideo;
import com.aca.narekhakobyan.homework.items.functionality.quality.VideoQuality;

public interface Video {
    FormatVideo getVideoFormat();
    VideoQuality getVideoQuality();
}
