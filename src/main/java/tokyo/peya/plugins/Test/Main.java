package tokyo.peya.plugins.Test;

import org.bukkit.plugin.java.JavaPlugin;
import tokyo.peya.plugins.Test.tests.bossbar.BossBar;
import tokyo.peya.plugins.Test.tests.entitySelector.EntitySelectorTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Main extends JavaPlugin
{
    public static ArrayList<Test> tests;

    public Main()
    {
        tests = new ArrayList<>(Arrays.asList(
                new EntitySelectorTest().register(this)
        ));
    }


    public static void main(String args[])
    {
        long startTime = System.currentTimeMillis();
        BossBar bar = new BossBar(" ", 3, "|", "■", 5, BossBar.Type.RIGHT_TO_LEFT);

        bar.tick();
        System.out.println(bar);

        System.out.println("t: " + (System.currentTimeMillis() - startTime));
    }

    @Override
    public void onEnable()
    {
    }
}
