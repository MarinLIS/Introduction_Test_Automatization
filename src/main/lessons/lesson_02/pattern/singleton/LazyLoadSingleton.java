package ru.gb.lessons.lesson_02.pattern.singleton;

/**
 * Метод отложенной загрузки
 */
public class LazyLoadSingleton {

    private String url;
    private Integer port;
    private Boolean connect;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private LazyLoadSingleton() {
    }

    private static class SingletonClassHolder {
        static final LazyLoadSingleton INSTANCE = new LazyLoadSingleton();
    }
    public static LazyLoadSingleton getInstance() {
        return SingletonClassHolder.INSTANCE;
    }

}
