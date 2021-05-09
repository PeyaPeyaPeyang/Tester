package tokyo.peya.plugins.Test;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public interface CommandTest extends Test, CommandExecutor
{
    boolean onCommand(CommandSender sender, Command command, String label, String[] args);
}
