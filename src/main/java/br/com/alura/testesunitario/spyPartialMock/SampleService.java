package br.com.alura.testesunitario.spyPartialMock;

public class SampleService {
    public String actualMethod() {
        return "Real implementation of actualMethod";
    }
    public String toBeSpiedMethod() {
        return "Real implementation of toBeSpiedMethod";
    }
}
