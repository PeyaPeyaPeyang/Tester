package tokyo.peya.plugins.Test.tests.oauthMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import tokyo.peya.plugins.Test.CommandTest;
import tokyo.peya.plugins.Test.Test;

public class OauthMapTest implements CommandTest
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {


        return true;
    }

    @Override
    public Test register(JavaPlugin plugin)
    {
        plugin.getCommand("oauthmap").setExecutor(this);
        return this;
    }
}
