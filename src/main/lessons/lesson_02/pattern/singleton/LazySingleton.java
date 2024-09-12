package ru.gb.lessons.lesson_02.pattern.singleton;

/**
 * Ленивый метод инициализации
 */
public class LazySingleton {

    private static LazySingleton INSTANCE = null;

    private String url;
    private Integer port;
    private Boolean connect;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (LazySingleton.class) {
                INSTANCE = new LazySingleton();
            }
        }
        return INSTANCE;
    }

}
