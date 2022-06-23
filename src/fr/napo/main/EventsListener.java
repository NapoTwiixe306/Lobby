package fr.napo.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;

public class EventsListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = (Player) event.getPlayer();
        event.setJoinMessage(ChatColor.DARK_GREEN + "Bonjour " + player.getName() + " et bon jeux a toi ! ");

        player.getInventory().clear();
        ItemStack customcompass = new ItemStack(Material.COMPASS, 1);
        ItemMeta customC = customcompass.getItemMeta();
        customC.setDisplayName("§a§lModes de Jeux");
        customcompass.setItemMeta(customC);
        player.getInventory().setItem(4, customcompass);
        player.updateInventory();

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if(it == null) return;

        if(it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(("§cJeux"))){
            Inventory inv = Bukkit.createInventory(null, 54, "§7Menu Principal");

            inv.setItem(10, getItem(Material.WOOL, "§b§lSheepWars"));
            inv.setItem(11, getItem(Material.DIAMOND_BLOCK, "§b§lFreeBuild"));
            inv.setItem(12, getItem(Material.WOOD_HOE, "§c§lGunWars"));
            inv.setItem(13, getItem(Material.MINECART, "§2§lSans Titre"));
            inv.setItem(14, getItem(Material.GRASS, "§2§lSkyBlock §d§lSaison 4!"));
            inv.setItem(15, getItem(Material.ITEM_FRAME, "§7Prochainement..."));

    

            player.openInventory(inv);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Inventory inv = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if(current == null) return;

        if(inv.getName().equalsIgnoreCase("§7Menu Principal")){
            if(current.getType() == Material.WOOL){
                player.closeInventory();
                player.sendMessage("§b§lSheepWars");
            }
        }
    }

    public ItemStack getItem(Material material, String customeName){
        ItemStack it = new ItemStack(material, 1);
        ItemMeta itM = it.getItemMeta();
        if(customeName != null) itM.setDisplayName(customeName);
        it.setItemMeta(itM);
        return it;
    }

}
