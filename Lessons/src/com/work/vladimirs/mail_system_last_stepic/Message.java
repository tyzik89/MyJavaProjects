

public interface Message<T> {

    T getContent ();

    String getTo ();

    String getFrom();
}
