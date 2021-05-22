package tokyo.peya.plugins.Test.tests.usageParse.lib;

public class Position
{
    public int index;
    public int column;
    public String text;

    public Position(int index, int column, String text)
    {
        this.index = index;
        this.column = column;
        this.text = text;
    }

    public Position advance()
    {
        index++;
        column++;

        return this;
    }

    public Position clone()
    {
        return new Position(index, column, text);
    }

    public Position cloneMinus()
    {
        return new Position(--index, --column, text);
    }

    public Position clonePlus()
    {
        return new Position(++index, ++column, text);
    }
}
