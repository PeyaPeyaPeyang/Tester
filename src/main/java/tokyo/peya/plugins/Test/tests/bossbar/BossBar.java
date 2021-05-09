package tokyo.peya.plugins.Test.tests.bossbar;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.ListIterator;

public class BossBar
{
    private final String charSpace;
    private final String charBar;
    private final String charCore;
    private final Type mode;
    private String[] data;

    private boolean enableSupply;

    private final int displayBars;
    private final int mag;

    public BossBar()
    {
        this(" ", 3, "|", "■", 5, Type.RIGHT_TO_LEFT);
    }

    public BossBar(String charSpace, int mag, String charBar, String charCore, int displayBars, Type type)
    {
        this.charBar = charBar;
        this.charCore = charCore;
        this.charSpace = charSpace;
        this.displayBars = displayBars;
        this.mode = type;
        this.enableSupply = true;
        this.mag = mag;

        init();
    }

    public void tick()
    {
        ListIterator<String> iterator = Arrays.asList(this.data).listIterator();

        int bay = (int) Math.ceil(mag / 2d);

        switch (mode)
        {
            case RIGHT_TO_LEFT:
                int counter = 0;
                while(iterator.hasNext())
                {
                    String buffer = iterator.next();
                    if (buffer.equals(charBar))
                        iterator.set(charSpace);
                    else if (buffer.equals(charSpace))
                        if (counter++ == bay)
                        {
                            iterator.set(charBar);
                            counter = 0;
                        }
                }

        }
    }

    private void setSupply(boolean supply)
    {
        this.enableSupply = supply;
    }

    private String[] getMags()
    {
        String[] mags = {};

        for (int i = 0; i < mag; i++)
            mags = ArrayUtils.add(mags, charSpace);
        return mags;
    }

    private void init()
    {
        switch (mode)
        {
            case RIGHT_TO_LEFT:
                String[] bars = whileBars(displayBars);
                this.data = new String[]{charCore};
                this.data = ArrayUtils.addAll(this.data, getMags());
                this.data = ArrayUtils.addAll(this.data, bars);
                break;
        }
    }

    @Override
    public String toString()
    {
        return "Data: " + String.join("", this.data) + "\n" +
                "Length: " + this.data.length + "\n";
    }

    private String[] whileBars(int count)
    {
        String[] bars = {};

        for (int i = 0; i < count; i++)
        {
            bars = ArrayUtils.add(bars, charBar);
            bars = ArrayUtils.addAll(bars, getMags());
        }
        return bars;
    }

    public enum Type
    {
        RIGHT_TO_LEFT
    }
}
