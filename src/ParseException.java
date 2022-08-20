/**
 * Project 4
 *
 *The exception for the class parser. Creates a custom exception and is thrown when needed.
 *
 * @author Yashvin Vedanaparti, Riley Turk, section 17
 *
 * @version 3/31/17
 *
 */
import java.io.Serializable;

public class ParseException extends Exception implements Serializable
{
    public ParseException (String message)
    {
        super(message);
    }
}
