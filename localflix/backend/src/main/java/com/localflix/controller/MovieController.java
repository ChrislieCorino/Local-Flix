package com.localflix.controller;

import com.localflix.model.Movie;
import com.localflix.repository.MovieRepository;
import com.localflix.service.WatchlistService;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MovieController {
    private final MovieRepository repo; private final WatchlistService watchlist;
    public MovieController(MovieRepository repo, WatchlistService watchlist){this.repo=repo;this.watchlist=watchlist;}
    @GetMapping("/movies")
    public List<Movie> movies(@RequestParam(required=false) String q, @RequestParam(required=false) String category){
        return repo.findAll().stream().filter(m -> q==null || q.isBlank() || (m.title()+" "+m.description()+" "+m.genre()).toLowerCase().contains(q.toLowerCase()))
          .filter(m -> category==null || category.equalsIgnoreCase("All") || m.category().equalsIgnoreCase(category) || m.genre().equalsIgnoreCase(category)).toList();
    }
    @GetMapping("/movies/{id}") public ResponseEntity<Movie> movie(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
    @GetMapping("/categories") public Set<String> categories(){Set<String>s=new LinkedHashSet<>();s.add("All");repo.findAll().forEach(m->{s.add(m.category());s.add(m.genre());});return s;}
    @GetMapping("/watchlist") public Set<Long> watchlist(){return watchlist.all();}
    @PostMapping("/watchlist/{id}") public Map<String,Object> toggle(@PathVariable Long id){return Map.of("inWatchlist",watchlist.toggle(id),"id",id);}
}
