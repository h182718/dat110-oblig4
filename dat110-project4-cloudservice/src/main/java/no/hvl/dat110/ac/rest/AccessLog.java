package no.hvl.dat110.ac.rest;

import com.google.gson.Gson;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AccessLog {

    protected ConcurrentHashMap<Integer, AccessEntry> log;
    private AtomicInteger cid;

    public AccessLog() {
        this.log = new ConcurrentHashMap<Integer, AccessEntry>();
        cid = new AtomicInteger(0);
    }

    // TODO: add an access entry for the message and return assigned id
    public int add(String message) {

        int id = log.size() + 1;
        AccessEntry ae = new AccessEntry(id, message);
        log.put(id, ae);

        return id;
    }

    // TODO: retrieve a specific access entry
    public AccessEntry get(int id) {
        return log.get(id);

    }

    // TODO: clear the access entry log
    public void clear() {
        log.clear();
    }

    // TODO: JSON representation of the access log
    public String toJson() {

        Gson gson = new Gson();
        String json = gson.toJson(log.values());

        return json;
    }
}
