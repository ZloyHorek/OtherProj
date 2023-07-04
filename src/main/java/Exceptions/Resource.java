package Exceptions;

public class Resource implements AutoCloseable {
    //AutoCloseable - ����� ��������� � try ���������� ������. ���������� ����� ����� ����� ������� (������������� � ��������� � try with resources)
    @Override
    public void close() throws Exception {
        System.out.println("Resource has been closed ---->" + this);
    }
}
