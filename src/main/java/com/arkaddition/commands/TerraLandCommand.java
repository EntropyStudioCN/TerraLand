package com.arkaddition.commands;

import com.arkaddition.Main;
import com.arkaddition.world.SourceStoneThorn;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class TerraLandCommand extends CommandBase {
    @Override
    public String getName() {
        return "terraland";
    }

    @Override
    public String getUsage(ICommandSender iCommandSender) {
        return "command.terraland.usage";
    }

    @Override
    public void execute(MinecraftServer minecraftServer, ICommandSender iCommandSender, String[] strings) throws CommandException {
        if (strings.length >= 2){
            if (strings[0].equalsIgnoreCase("debug")){
                if (Main.DEV_VERSION){
                    iCommandSender.sendMessage(new TextComponentString("Warn: You are running a debug command"));
                    if (strings[1].equalsIgnoreCase("thorn")){
                        if (!(strings.length > 2)){
                            iCommandSender.sendMessage(new TextComponentString("Spawn SourceStoneThorn with random"));
                            new SourceStoneThorn().spawn(new BlockPos(iCommandSender.getCommandSenderEntity().posX,iCommandSender.getCommandSenderEntity().posY,iCommandSender.getCommandSenderEntity().posZ),iCommandSender.getCommandSenderEntity(),
                                    iCommandSender.getEntityWorld());
                        }
                    }
                }else {
                    iCommandSender.sendMessage(new TextComponentString("This is debug only command(Version:Release)"));
                }
            }
        }
    }
}
