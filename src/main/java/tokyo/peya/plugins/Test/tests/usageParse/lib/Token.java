package tokyo.peya.plugins.Test.tests.usageParse.lib;

enum TokenTypes
{
    NUMBER("NUMBER"),
    OPERATOR("OPERATOR"),
    TRUE("TRUE"),
    FALSE("FALSE"),
    IDENTIFIER("IDENTIFIER");

    public final String type;

    TokenTypes(String type)
    {
        this.type = type;
    }
}

public class Token
{
    public static final String[] true_values = {
        "true",
        "1",
        "on",
    };

    public static final String[] false_values = {
        "false",
        "0",
        "off"
    };

    public final TokenTypes type;
    public final String value;
    public Position start;
    public Position end;

    public Token(TokenTypes type, String value, Position start, Position end)
    {
        this.type = type;
        this.value = value;
        this.start = start;
        this.end = end;
    }

    public Token(TokenTypes type, String value, Position start)
    {
        this.type = type;
        this.value = value;
        this.start = start;
    }

    public Token(TokenTypes type, String value)
    {
        this.type = type;
        this.value = value;
    }

    public Token(TokenTypes type)
    {
        this.type = type;
        this.value = "";
    }

    @Override
    public String toString()
    {
        return type.type + (value.length() > 0 ? ":" + value : "");
    }
}
