package ru.gb.lessons.lesson_02.pattern.singleton;

/**
 * Простая инициализация
 */
public class SimpleSingleton {

    private static final SimpleSingleton INSTANCE = new SimpleSingleton("http://url", 8080, true);

    private SimpleSingleton(String url, Integer port, Boolean connect) {
        this.url = url;
        this.port = port;
        this.connect = connect;
    }

    private String url;
    private Integer port;
    private Boolean connect;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static SimpleSingleton getInstance() {
        return INSTANCE;
    }

}
