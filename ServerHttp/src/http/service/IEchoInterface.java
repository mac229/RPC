package http.service;

public interface IEchoInterface {
    /**
     * Returns a welcome message
     */
    public String sayHello();

    /**
     * Returns the argument
     * @param text
     * @return
     */
    public String echo(String text);
}
