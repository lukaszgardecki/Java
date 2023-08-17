package wzorce.bridge;

import wzorce.bridge.processor.HDProcessor;
import wzorce.bridge.processor.UHD4KProcessor;
import wzorce.bridge.video.NetflixVideo;
import wzorce.bridge.video.YoutubeVideo;

class Main {
    public static void main(String[] args) {
        YoutubeVideo youtubeVideo = new YoutubeVideo(new HDProcessor());
        youtubeVideo.play("abc.mp4");

        NetflixVideo netflixVideo = new NetflixVideo(new UHD4KProcessor());
        netflixVideo.play("dfg.mp4");
    }
}
