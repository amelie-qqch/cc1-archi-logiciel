package utils;

public interface LoggerInterface {
    // ou passer le code en param
    void error(String message);
    void info(String message);
    void debug(String message);
    void warning(String message);
}
