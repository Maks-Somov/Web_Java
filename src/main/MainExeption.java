package main;

import main.model.Resume;

/**
 * Maks
 * 07.02.2020.
 */
///////////Test on comp///////////////////////////
public class MainExeption extends RuntimeException {
    private Resume resume = null;
    private String uuid = null;

    public MainExeption(String message) {
        super(message);
    }

    public MainExeption(String message, Throwable e) {
        super(message, e);
    }

    public MainExeption(String message, Resume resume) {
        super(message);
        this.resume = resume;
    }

    public MainExeption(Throwable e, Resume resume, String message) {
        super(message, e);
        this.resume = resume;
    }

    public MainExeption(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public Resume getResume() {
        return resume;
    }

    public String getUuid() {
        return uuid;
    }
}
