package fr.napo.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
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
    public void onDisconnect(PlayerQuitEvent event){
        Player player = (Player) event.getPlayer();
        event.setQuitMessage(ChatColor.DARK_BLUE + "Au Revoir" + player.getName() + "Bonne journée a toi :/");
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if(it == null) return;

        if(it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(("§a§lModes de Jeux"))){
            Inventory inv = Bukkit.createInventory(null, 54, "§7Menu Principal");

            inv.setItem(10, getItem(Material.WOOL, "§b§lSheepWars"));
            inv.setItem(11, getItem(Material.DIAMOND_BLOCK, "§b§lFreeBuild"));
            inv.setItem(12, getItem(Material.WOOD_HOE, "§c§lGunWars"));
            inv.setItem(13, getItem(Material.MINECART, "§2§lSans Titre"));
            inv.setItem(14, getItem(Material.GRASS, "§2§lSkyBlock §d§lSaison 1!"));
            inv.setItem(15, getItem(Material.ITEM_FRAME, "§7Prochainement..."));
            inv.setItem(19, getItem(Material.NETHER_STAR, "§b§lSkyWars"));
            inv.setItem(20, getItem(Material.BED, "§2§lBedWars"));
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
            switch(event.getCurrentItem().getType()){
                case WOOL:
                    if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lSheepWars")){
                        event.setCancelled(true);
                        player.closeInventory();
                        player.sendMessage("§b§lTest");
                    }
                    break;
                case DIAMOND_BLOCK:
                    if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lFreeBuild")){
                        event.setCancelled(true);
                        player.closeInventory();
                        player.sendMessage("§b§lFreeBuild");
                    }
                    break;
                case WOOD_HOE:
                    if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lGunWars")){
                        event.setCancelled(true);
                        player.closeInventory();
                        player.sendMessage("§c§lGunWars");
                    }
                    break;
                case MINECART:
                    if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2§lSans Titre")){
                        event.setCancelled(true);
                        player.closeInventory();
                        player.sendMessage("§2§lSans Titre");
                    }
                    break;
                case GRASS:
                    if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2§lSkyBlock §d§lSaison 1!")){
                        event.setCancelled(true);
                        player.closeInventory();
                        player.sendMessage("§2§lSkyBlock §d§lSaison 1!");
                    }
                    break;
                case ITEM_FRAME:
                    if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Prochainement...")){
                        event.setCancelled(true);
                        player.closeInventory();
                        player.sendMessage("§7Prochainement...");
                    }
                    break;
                case NETHER_STAR:
                    if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lSkyWars")){
                        event.setCancelled(true);
                        player.closeInventory();
                        player.sendMessage("§2Vous allez bientôt être tp au §b§lSkyWars");
                    }
                    break;
                case BED:
                    if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2§lBedWars")){
                        event.setCancelled(true);
                        player.closeInventory();
                        player.sendMessage("§2Vous allez bientôt être tp au §2§lBedWars");
                    }
                    break;
                default: break;
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
