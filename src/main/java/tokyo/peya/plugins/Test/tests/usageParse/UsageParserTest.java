package tokyo.peya.plugins.Test.tests.usageParse;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import tokyo.peya.plugins.Test.CommandTest;
import tokyo.peya.plugins.Test.Test;

public class UsageParserTest implements CommandTest
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        String plainText = String.join(" ", args);


        return true;
    }

    @Override
    public Test register(JavaPlugin plugin)
    {
        plugin.getCommand("selector").setExecutor(this);
        return this;
    }
}
