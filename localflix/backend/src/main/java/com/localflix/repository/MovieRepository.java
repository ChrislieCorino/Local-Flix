package com.localflix.repository;

import com.localflix.model.Movie;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
    private final List<Movie> movies = new CopyOnWriteArrayList<>(List.of(
        new Movie(1L,"The River Between","A young filmmaker returns home and discovers a story worth risking everything to tell.","Drama","Local Stories","2026","16","1h 48m","https://primaryleap.co.uk/images/wikileap/post_levels/thumb_orignal/32d419f896ca782505b2d256a1ee902db75a5ba7iY.jpg","https://www.youtube.com/embed/ScMzIvxBSi4",true),
        new Movie(2L,"Johannesburg Nights","Three friends chase one unforgettable night across the city lights.","Thriller","Local Stories","2025","16","1h 36m","https://live.staticflickr.com/7317/8747365478_7518152a93_b.jpg","https://www.youtube.com/embed/aqz-KE-bpKQ",false),
        new Movie(3L,"Cape Town Blue","A photographer follows the ocean south and finds an unexpected second chance.","Romance","Romance","2025","13","1h 42m","https://img.freepik.com/premium-photo/black-couple-drink-relax-sand-by-beach-romantic-date-vacation-anniversary-getaway-bonding-man-woman-together-with-white-wine-ocean-escape-commitment-love-connection_590464-422999.jpg","https://www.youtube.com/embed/ysz5S6PUM-U",false),
        new Movie(4L,"Ubuntu","When a community centre is threatened, neighbours unite to save their home.","Drama","Drama","2024","PG","1h 55m","https://static.wixstatic.com/media/3849a9_3128712d1fe440718a3b6f255c6446aa~mv2.jpg/v1/fill/w_980,h_554,al_c,q_85,usm_0.66_1.00_0.01,enc_avif,quality_auto/3849a9_3128712d1fe440718a3b6f255c6446aa~mv2.jpg","https://www.youtube.com/embed/tgbNymZ7vqY",false),
        new Movie(5L,"Street Kings","An underground dance crew prepares for the biggest battle of their lives.","Action","Action","2026","16","1h 31m","https://tse2.mm.bing.net/th/id/OIP.-OFSu4NEbMHMp8pxfkAJMAHaE8?r=0&rs=1&pid=ImgDetMain&o=7&rm=3","https://www.youtube.com/embed/ScMzIvxBSi4",true),
        new Movie(6L,"Mzansi Laughs","Local comedians bring the house down in this fast-paced stand-up special.","Comedy","Comedy","2025","13","1h 12m","https://static.vecteezy.com/system/resources/thumbnails/035/644/347/large/african-american-people-suffering-from-migraine-on-camera-having-flu-symptoms-and-being-exhausted-in-studio-man-and-woman-with-headache-rubbing-temples-to-ease-the-pressure-unwell-couple-video.jpg","https://www.youtube.com/embed/aqz-KE-bpKQ",false),
        new Movie(7L,"The Last Taxi","A night driver picks up a passenger who changes the course of his life.","Mystery","Thriller","2024","16","1h 44m","https://thumbs.dreamstime.com/b/shared-taxi-road-newtown-district-johannesburg-south-africa-shared-taxi-newtown-johannesburg-108421705.jpg","https://www.youtube.com/embed/ysz5S6PUM-U",false),
        new Movie(8L,"Karoo Skies","A quiet coming-of-age story set beneath an endless Karoo sky.","Coming of Age","Local Stories","2023","PG","1h 38m","https://dennehof.co.za/wp-content/uploads/2024/01/Karoo-Skies.jpg","https://www.youtube.com/embed/tgbNymZ7vqY",false),
        new Movie(9L,"Golden Hour","A young artist turns a tiny studio into the start of something bigger.","Drama","New Releases","2026","13","1h 27m","https://media.istockphoto.com/id/1284317705/photo/black-female-singer-singing-into-microphone-in-recording-studio.jpg?s=612x612&w=0&k=20&c=pYHj5ROKTp6giRfataNWWdKQIQeduHOCsbBKryN1nf0=","https://www.youtube.com/embed/ScMzIvxBSi4",true),
        new Movie(10L,"Durban Heat","A rookie reporter uncovers a conspiracy while chasing the story of the summer.","Crime","Thriller","2025","16","1h 50m","https://media.istockphoto.com/id/515009937/photo/female-african-news-reporter-working-outdoors.jpg?s=612x612&w=0&k=20&c=4TlCot7SwWHsWYOXLnM-Sd2RWmmxOxR_ihsR2Qi45tY=","https://www.youtube.com/embed/aqz-KE-bpKQ",false)
    ));
    public List<Movie> findAll(){ return movies; }
    public Optional<Movie> findById(Long id){ return movies.stream().filter(m -> m.id().equals(id)).findFirst(); }
}
