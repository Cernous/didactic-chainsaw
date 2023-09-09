package Workshop1;

/**
 * Hello world!
 *
 */
public class W1 
{
    public static void main( String[] args )
    {
        int x;
        x = recursive_handshake(6);
        System.out.println("The result is "  + x);
    }

    public static int recursive_handshake(int n)
    {
        if (n == 1)
        {
            return 0;
        }
        return (n-1) + recursive_handshake(n-1);
    }
}
