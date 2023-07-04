package Exceptions;

public class Resource implements AutoCloseable {
    //AutoCloseable - метод позволяет в try закидывать ресурс. Используем когда метод нужно закрыть (автоматически в контексте с try with resources)
    @Override
    public void close() throws Exception {
        System.out.println("Resource has been closed ---->" + this);
    }
}
