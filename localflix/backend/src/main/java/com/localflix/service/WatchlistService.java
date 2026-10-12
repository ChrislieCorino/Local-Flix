package com.localflix.service;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WatchlistService {
    private final Set<Long> ids = ConcurrentHashMap.newKeySet();
    public Set<Long> all(){ return Set.copyOf(ids); }
    public boolean toggle(Long id){ if(!ids.add(id)) { ids.remove(id); return false; } return true; }
    public boolean contains(Long id){ return ids.contains(id); }
}
