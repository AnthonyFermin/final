package strq;
/**
 * Created by c4q-anthonyf on 12/10/15.
 */
public class SimpleStringQueue implements StringQueue
{
    String string;

    public SimpleStringQueue() {
        string = "";
    }


    @Override
    public int length()
    {
        return string.length();
    }

    @Override
    public void enqueue(String string)
    {
        this.string = this.string + string;
    }

    @Override
    public String dequeue(int length)
    {
        String temp = string.substring(0, length);
        string = string.substring(length);
        return temp;
    }

    @Override
    public String toString() {
        return string;
    }
}
