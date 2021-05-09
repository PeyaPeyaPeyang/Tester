package tokyo.peya.plugins.Test.tests.entitySelector;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import tokyo.peya.plugins.Test.CommandTest;
import tokyo.peya.plugins.Test.Test;

import java.util.stream.Collectors;

public class EntitySelectorTest implements CommandTest
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (args.length == 0)
        {
            sender.sendMessage("Usage: /select <selector>");
            return false;
        }

        try
        {
            EntitySelector.matchEntities(sender, args[0], Entity.class, true).forEach(entity -> {
                sender.sendMessage(entity.getName() + "=" + entity.getUniqueId());
            });
        }
        catch (SelectorInvalidException e)
        {
            sender.sendMessage("無効なセレクタ：" +
                    e.getInvalidKeys().entrySet().stream()
                            .map(ent -> ent.getKey() + "=" + ent.getValue()).collect(Collectors.joining(""))
            );
        }
        catch (SelectorException e)
        {
            sender.sendMessage("壊れたセレクタ");
        }

        return true;
    }

    @Override
    public Test register(JavaPlugin plugin)
    {
        plugin.getCommand("selector").setExecutor(this);
        return this;
    }
}
