package tokyo.peya.plugins.Test.tests.usageParse.lib;

import java.util.ArrayList;
import java.util.List;

public class UsageLexer
{
    public String text;
    public Position position;
    public String currentChar = "";
    public List<Token> tokens = new ArrayList<>();
    public Position position = new Position(-1, 0, -1, text);

    public UsageLexer(public String text)
}
