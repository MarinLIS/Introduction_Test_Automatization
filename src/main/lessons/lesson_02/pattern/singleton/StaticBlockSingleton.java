package ru.gb.lessons.lesson_02.pattern.singleton;

/**
 * Метод инициализации статического блока
 */
public class StaticBlockSingleton {

    private static StaticBlockSingleton INSTANCE;

    private String url;
    private Integer port;
    private Boolean connect;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private StaticBlockSingleton() {
    }
    static {
        try {
            INSTANCE = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("bad creating a Singleton Class");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return INSTANCE;
    }
}
