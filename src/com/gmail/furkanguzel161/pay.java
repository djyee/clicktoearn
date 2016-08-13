package com.gmail.furkanguzel161;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import simple.brainsynder.api.ParticleMaker;
import simple.brainsynder.exceptions.MissingParticleException;


public final class pay extends JavaPlugin
  implements Listener
{
     
  public void onEnable()
  {
//Feel Free to Chance code and use :) but please dont forget the original creator 
//Kodu değiştirip Kullanmakta Çekinmeyin Ama Lütfen Eklentinin Orjinal Yapimcisini Unutmayin :)
//creator: djyee (The Noob Coder)
//Yapimci: djyee (Acemi Kodlayici)	  
	  
    try {
      Connection connection = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"
      + database, username, password);
DatabaseMetaData metadata = connection.getMetaData();
ResultSet resultSet;
resultSet = metadata.getColumns(null, null, "clickandearn", null);

      if(resultSet.next()){
          connection.close();
      
      }else{
         try {
  Connection connection1;
  connection1 = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"
          + database, username, password);
  Statement s4 = connection1.createStatement();
  s4.executeUpdate("CREATE TABLE clickandearn" +
             "(id int unsigned not null auto_increment primary key, ipadress varchar(60), L1 varchar(6), L2 varchar(6), L3 varchar(6), date varchar(60), link varchar(60))");
  s4.executeUpdate("INSERT INTO clickandearn (ipadress, L1, L2, L3, date, link) VALUES ('----', '---', '---', '---', '---', '---')");

  connection1.close();
} catch (SQLException e) {            
  e.printStackTrace();
}
         connection.close();
      }
      connection.close();
    } catch (SQLException e) {
  
      e.printStackTrace();
    }
   
    ///
                  
      getServer().getPluginManager().registerEvents(this, this);
      getConfig().options().copyDefaults(true);
        saveConfig();
getLogger().info("Tikla Kazan V1.0 Enable!");
saveDefaultConfig();

  }
  
  public void onDisable()
  {
  
     getLogger().info("Tikla Kazan V1.0 Disable!");

  }
    private File playerdataFile =  new File(getDataFolder(), "players.yml");;
    File pdata = new File(getDataFolder()+"/players.yml");
    FileConfiguration pdatafile = YamlConfiguration.loadConfiguration(pdata);
public void saveDefaultConfig() {
    if (playerdataFile == null) {
        playerdataFile = new File(getDataFolder(), "players.yml");
    }
    if (!playerdataFile.exists()) {            
        saveResource("players.yml", false);
     }
}






  HashMap<Player, Boolean> sohbet = new HashMap<Player, Boolean>();
  HashMap<Player, String> link = new HashMap<Player, String>();
  HashMap<Player, String> linkcheck = new HashMap<Player, String>();
  HashMap<Player, String> effect1 = new HashMap<Player, String>();
  @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
      Player p3 = event.getPlayer();
      if (this.sohbet.get(p3) == null) {
        
        return;
      }
      for (Player player1 : Bukkit.getServer().getOnlinePlayers())
      {
        if (this.sohbet.get(player1) == Boolean.TRUE) {
          event.getRecipients().remove(player1);
          if (event.getPlayer().equals(p3)){
            p3.sendMessage(ChatColor.GRAY + ">>>>>" + ChatColor.GOLD + "Sohbet AktifLeştirildi" + ChatColor.GRAY + "<<<<<");
          sohbet.put(p3, Boolean.FALSE);
          }
           
        }
      }
    }  

           
          String hostname = getConfig().getString("MySQL.hostname");
        int port = getConfig().getInt("MySQL.port");
        String database = getConfig().getString("MySQL.database");
        String username =  getConfig().getString("MySQL.username");
        String password = getConfig().getString("MySQL.password");
      
        String link1_1 = getConfig().getString("Links.L1.C1");
        String link1_2 = getConfig().getString("Links.L1.C2");
        String link1_3 = getConfig().getString("Links.L1.C3");
        String link1_4 = getConfig().getString("Links.L1.C4");
        String link1_5 = getConfig().getString("Links.L1.C5");
        ////////////////////////////
        String link2_1 = getConfig().getString("Links.L2.C1");
        String link2_2 = getConfig().getString("Links.L2.C2");
        String link2_3 = getConfig().getString("Links.L2.C3");
        String link2_4 = getConfig().getString("Links.L2.C4");
        String link2_5 = getConfig().getString("Links.L2.C5");
        ////////////////////////////
        String link3_1 = getConfig().getString("Links.L3.C1");
        String link3_2 = getConfig().getString("Links.L3.C2");
        String link3_3 = getConfig().getString("Links.L3.C3");
        String link3_4 = getConfig().getString("Links.L3.C4");
        String link3_5 = getConfig().getString("Links.L3.C5"); 

        
     public static Inventory tikla = Bukkit.createInventory(null, 45, ChatColor.GREEN +"Tıkla Kazan!");
     
     public boolean creditinfo(Player player) {  
    	 
    
     //////tiklama kredisi bilgi//////
     ItemStack tikla1b1 = new ItemStack(Material.PAPER,1);
       List<String> Fsb1 = new ArrayList<String>();
       Fsb1.add(ChatColor.RED + "Mevcut Tiklama Kredin: "+pdatafile.getString("Players." +player.getUniqueId()+".ClickCredit") );
     
       ItemMeta imsb1 = tikla1b1.getItemMeta();
       imsb1.setDisplayName(ChatColor.RED + "Tiklama Kredisi");
       imsb1.setLore(Fsb1);
       tikla1b1.setItemMeta(imsb1);
     tikla.setItem(24, tikla1b1);
     /////tiklama kredisi bilgi///// 
	return false;
     }
     
     public boolean spawner(Player player) {    
      	  //////Supriz spawner//////
       ItemStack tikla1b1s = new ItemStack(Material.MOB_SPAWNER,1);
         List<String> Fsb1s = new ArrayList<String>();
         Fsb1s.add(ChatColor.GREEN + "Bedel: 70 Tiklama Kredisi!");
         Fsb1s.add(ChatColor.RED + "Mevcut Tiklama Kredin: "+pdatafile.getString("Players." +player.getUniqueId()+".ClickCredit") );
         Fsb1s.add(ChatColor.BLUE + "Supriz Bir"+ChatColor.YELLOW+" Spawner"+ChatColor.BLUE +" Almak için Tiklayin");
         ItemMeta imsb1s = tikla1b1s.getItemMeta();
         imsb1s.setDisplayName(ChatColor.YELLOW + "Supriz Spawner!");
         imsb1s.setLore(Fsb1s);
         tikla1b1s.setItemMeta(imsb1s);
       tikla.setItem(22, tikla1b1s);
       /////Supriz spawner/////g
   	return false;
       }
     public boolean legendarysupricechest(Player player) {    
   	  //////Supriz Sandik//////
    ItemStack tikla1b1s = new ItemStack(Material.CHEST,1);
      List<String> Fsb1s = new ArrayList<String>();
      Fsb1s.add(ChatColor.GREEN + "Bedel: 30 Tiklama Kredisi!");
      Fsb1s.add(ChatColor.RED + "Mevcut Tiklama Kredin: "+pdatafile.getString("Players." +player.getUniqueId()+".ClickCredit") );
      Fsb1s.add(ChatColor.BLUE + "1 Adet"+ChatColor.RED + " Efsanevi Supriz Sandik " +ChatColor.BLUE + "Almak için Tiklayin!");
      ItemMeta imsb1s = tikla1b1s.getItemMeta();
      imsb1s.setDisplayName(ChatColor.RED + "Efsanevi Supriz Sandik");
      imsb1s.setLore(Fsb1s);
      tikla1b1s.setItemMeta(imsb1s);
    tikla.setItem(32, tikla1b1s);
    /////Supriz Sandik/////g
	return false;
    }
     public boolean supricechest(Player player) {    
    	  //////Supriz Sandik//////
     ItemStack tikla1b1s = new ItemStack(Material.CHEST,1);
       List<String> Fsb1s = new ArrayList<String>();
       Fsb1s.add(ChatColor.GREEN + "Bedel: 10 Tiklama Kredisi!");
       Fsb1s.add(ChatColor.RED + "Mevcut Tiklama Kredin: "+pdatafile.getString("Players." +player.getUniqueId()+".ClickCredit") );
       Fsb1s.add(ChatColor.BLUE + "1 Adet"+ChatColor.AQUA + " Supriz Sandik "+ChatColor.BLUE + "Almak için Tiklayin!");
       ItemMeta imsb1s = tikla1b1s.getItemMeta();
       imsb1s.setDisplayName(ChatColor.AQUA + "Supriz Sandik");
       imsb1s.setLore(Fsb1s);
       tikla1b1s.setItemMeta(imsb1s);
     tikla.setItem(30, tikla1b1s);
     /////Supriz Sandik/////g
	return false;
     }
    
     
     public boolean effect(Player player) {    
     //////efektler//////
     ItemStack tikla11b = new ItemStack(Material.JACK_O_LANTERN,1);
       List<String> Fsb1 = new ArrayList<String>();
       Fsb1.add(ChatColor.GREEN + "Bedel: 10 Tiklama Kredisi!");
       Fsb1.add(ChatColor.RED + "Mevcut Tiklama Kredin: "+pdatafile.getString("Players." +player.getUniqueId()+".ClickCredit") );
       Fsb1.add(ChatColor.BLUE + "Saat 00:00 `a kadar Kullanabileceğiniz.");
       Fsb1.add(ChatColor.BLUE + "Supriz Bir Partikul efekt Elde Edersiniz.");
       Fsb1.add(ChatColor.AQUA+  "Raskele Verilir!");
       Fsb1.add(ChatColor.DARK_AQUA + "Almak,Açip kapamak için Tiklayin");
       Fsb1.add(ChatColor.GREEN + "Bağişçilar Tum Efektleri kullanabilir! Bilgi için /bagis");
       Fsb1.add(ChatColor.GOLD + "www.racialfactor.com");
       ItemMeta imsb1 = tikla11b.getItemMeta();
       imsb1.setDisplayName(ChatColor.GOLD + "Supriz Efekt "+effect1.get(player));
       imsb1.setLore(Fsb1);
       tikla11b.setItemMeta(imsb1);
     tikla.setItem(20, tikla11b);
     /////efektler/////
	return false;
     }
     
     public boolean allclickedlink(Player player,int ChestNo ,String Linkno) {
         //////tum Linkler tiklanmiş//////
            ItemStack tikla1 = new ItemStack(Material.SLIME_BALL,1);
              List<String> Fs = new ArrayList<String>();
              Fs.add(ChatColor.GREEN + "Tüm Linklere Tikladin Yarin Tekrar Tiklayabileceksin!");              
              Fs.add(ChatColor.GREEN + "Tiklayarak Kazandiğin Kredini Aşağida Kullanabilirsin! ");
              Fs.add(ChatColor.GOLD+ "Bilgi için: "+ChatColor.GREEN+"Sol Alt Köşedeki Kitaba Bakin!");
              ItemMeta ims = tikla1.getItemMeta();
              ims.setDisplayName(ChatColor.YELLOW + Linkno);
              ims.setLore(Fs);
              tikla1.setItemMeta(ims);
            tikla.setItem(ChestNo, tikla1);
            ///////tum Link tiklanmiş//////
            return false;
           
       }       
        
public boolean clickedlink(Player player,int ChestNo ,String Linkno) {
       //////Link tiklanmiş//////
          ItemStack tikla1 = new ItemStack(Material.SLIME_BALL,1);
            List<String> Fs = new ArrayList<String>();
            Fs.add(ChatColor.GREEN + "Bu Linke Tikladin Lutfen "+ ChatColor.AQUA+link.get(player)+"."+ChatColor.GREEN +" Linke tikla!");
            Fs.add(ChatColor.GOLD+ "Bilgi için: "+ChatColor.GREEN+"Sol Alt Köşedeki Kitaba Bakin!");
            ItemMeta ims = tikla1.getItemMeta();
            ims.setDisplayName(ChatColor.YELLOW + Linkno);
            ims.setLore(Fs);
            tikla1.setItemMeta(ims);
          tikla.setItem(ChestNo, tikla1);
          ///////Link tiklanmiş//////
          return false;
         
     }
public boolean inlinenotclickedlink(Player player,int ChestNo ,String Linkno, String credi) {
          //////Link Tiklanmamiş siradaki//////
          ItemStack tikla12 = new ItemStack(Material.MAGMA_CREAM,1);
            List<String> Fs2 = new ArrayList<String>();
            Fs2.add(ChatColor.LIGHT_PURPLE + "Lütfen Bu Linke Tiklayarak Siradaki Linki Aktif Edin!");
            Fs2.add(ChatColor.LIGHT_PURPLE+ "Kredi Değeri: "+ChatColor.GREEN+credi +" Kredi");
            Fs2.add(ChatColor.GOLD+ "Bilgi için: "+ChatColor.GREEN+"Sol Alt Köşedeki Kitaba Bakin!");
            ItemMeta ims2 = tikla12.getItemMeta();
            ims2.setDisplayName(ChatColor.YELLOW + Linkno);
            ims2.setLore(Fs2);
            tikla12.setItemMeta(ims2);          
          tikla.setItem(ChestNo, tikla12);
          //////Link Tiklanmamiş siradaki//////
          return false;
         
}
  public boolean linenotclickedlink(Player player,int ChestNo ,String Linkno ,String credi) {
          //////Link tiklanmamis sirasi gelmemis//////
          ItemStack tikla13 = new ItemStack(Material.BARRIER,1);
            List<String> Fs3 = new ArrayList<String>();
            Fs3.add(ChatColor.RED + "Lütfen Linklere Sirayla Tiklayin!");
            Fs3.add(ChatColor.LIGHT_PURPLE+ "Kredi Değeri: "+ChatColor.GREEN+credi +" Kredi");
            Fs3.add(ChatColor.GOLD+ "Bilgi için: "+ChatColor.GREEN+"Sol Alt Köşedeki Kitaba Bakin!");
            ItemMeta ims3 = tikla13.getItemMeta();
            ims3.setDisplayName(ChatColor.YELLOW + Linkno);
            ims3.setLore(Fs3);
            tikla13.setItemMeta(ims3);
          tikla.setItem(ChestNo, tikla13);
              //////Link tiklanmamis sirasi gelmemis//////
      return false;
       
     }
     
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
 
    Player p = (Player)sender;
	  if (cmd.getName().equalsIgnoreCase("nerdeyim")){
		  Location l1 = p.getLocation();
		  p.sendMessage(ChatColor.RED +"Location: " + ChatColor.GOLD +" X: "+ l1.getBlockX()  + ChatColor.GOLD +" Y: "  +l1.getBlockY()+   ChatColor.GOLD +" Z: "+ l1.getBlockZ());
	  }
	  
    if (cmd.getName().equalsIgnoreCase("tiklakazan")){
      
      try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"
        + database, username, password);
        Statement s41 = connection.createStatement();
  ResultSet resultSet;
  String ip1 = p.getAddress().getAddress().getHostAddress();
  SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
  resultSet = s41.executeQuery("SELECT * FROM clickandearn WHERE ipadress='"+ip1+"';");
  Date now = new Date();
        if(resultSet.next()){
          
        
      
            connection.close();
        
        }else{
           try {
        connection.close();
    Connection connection1;
    connection1 = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"
            + database, username, password);
    Statement s4 = connection1.createStatement();

    s4.executeUpdate("INSERT INTO clickandearn (ipadress, L1, L2, L3, date, link) VALUES ('"+ip1+"', 'false', 'false', 'false','"+format.format(now)+"', 'http://adf.ly/1bce95')");
  
    connection1.close();
  } catch (SQLException e) {            
    e.printStackTrace();
  }
           connection.close();
        }
        connection.close();
        
      } catch (SQLException e) {
    
        e.printStackTrace();
      } 
      
    
     ResultSet resultSet565 = null;
    Connection connection = null;
    try {
      connection = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"
              + database, username, password);
      Statement s4113 = connection.createStatement(); 
    String ip2 = p.getAddress().getAddress().getHostAddress();
      resultSet565 = s4113.executeQuery("SELECT * FROM clickandearn WHERE ipadress='"+ip2+"';");
    } catch (SQLException e1) {
    
      e1.printStackTrace();
    }
    
    
    try {
    if(resultSet565.next()){
      Date now = new Date();
       SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
      if(!resultSet565.getString("date").equals(format.format(now))){
    	  try {
    		  
              Connection connection123;
              connection123 = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"
                      + database, username, password);
              Statement s42 = connection123.createStatement();
              Statement s43 = connection123.createStatement();
              String ip2 = p.getAddress().getAddress().getHostAddress();
              s42.executeUpdate("DELETE FROM clickandearn WHERE ipadress = '"+ip2+"';");
              s43.executeUpdate("INSERT INTO clickandearn (ipadress, L1, L2, L3, date, link) VALUES ('"+ip2+"', 'false', 'false', 'false','"+format.format(now)+"', '--------');");
              String a1 = "false";
    		  pdatafile.set("Players." +p.getUniqueId()+".Effectselect", "----");    		
              pdatafile.set("Players." +p.getUniqueId()+".effect", false);
              pdatafile.set("Players." +p.getUniqueId()+".L1", a1);
    		  pdatafile.set("Players." +p.getUniqueId()+".L2", a1);
    		  pdatafile.set("Players." +p.getUniqueId()+".L3", a1);
    		  pdatafile.save(pdata);
              connection123.close();
            } catch (SQLException | IOException e) {            
              e.printStackTrace();
            }
    	  connection.close();    
      }
      
    }
    connection.close();
  } catch (SQLException e1) {
    e1.printStackTrace();
    
  }
   
    
    
     try {
          String ip1 = p.getAddress().getAddress().getHostAddress();
          Connection connection12 = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"
          + database, username, password);
          Statement s41 = connection12.createStatement();
          Statement s42 = connection12.createStatement();
          Statement s43 = connection12.createStatement();
          ResultSet resultSet1;
    ResultSet resultSet2;
    ResultSet resultSet3;
    resultSet1 = s41.executeQuery("SELECT * FROM clickandearn WHERE ipadress='"+ip1+"' and L1='false';");
    resultSet2 = s42.executeQuery("SELECT * FROM clickandearn WHERE ipadress='"+ip1+"' and L2='false';");
    resultSet3 = s43.executeQuery("SELECT * FROM clickandearn WHERE ipadress='"+ip1+"' and L3='false';");
    if(resultSet1.next()){          
        link.put(p, "1");   
        inlinenotclickedlink(p, 0, "Link 1","6");
        linenotclickedlink(p,1,"Link 2","6");
        linenotclickedlink(p,2,"Link 3","11");
        
          p.openInventory(tikla);
        connection12.close();
          }else{
            if(resultSet2.next()){
              link.put(p, "2");
      		if(pdatafile.getBoolean("Players." +p.getUniqueId()+".L1") == false){
    			int clicks =  pdatafile.getInt("Players." +p.getUniqueId()+".Clicks") + 1;
    			int clickcredit =  pdatafile.getInt("Players." +p.getUniqueId()+".ClickCredit") + 6;
    			pdatafile.set("Players." +p.getUniqueId()+".Clicks", clicks);
    			pdatafile.set("Players." +p.getUniqueId()+".ClickCredit", clickcredit);
    			pdatafile.set("Players." +p.getUniqueId()+".L1", true);
    			pdatafile.set("Players." +p.getUniqueId()+".İpaddress", ip1 );
    			pdatafile.save(pdata);
        		}
    	 
                clickedlink(p, 0, "Link 1");
                inlinenotclickedlink(p,1,"Link 2","6");
                linenotclickedlink(p,2,"Link 3","11");
              
                  p.openInventory(tikla);
                connection12.close();
            }else{
              if(resultSet3.next()){
                link.put(p, "3");
        		if(pdatafile.getBoolean("Players." +p.getUniqueId()+".L2") == false){
        			int clicks =  pdatafile.getInt("Players." +p.getUniqueId()+".Clicks") + 1;
        			int clickcredit =  pdatafile.getInt("Players." +p.getUniqueId()+".ClickCredit") + 6;
        			pdatafile.set("Players." +p.getUniqueId()+".Clicks", clicks);
        			pdatafile.set("Players." +p.getUniqueId()+".ClickCredit", clickcredit);
        			pdatafile.set("Players." +p.getUniqueId()+".L2", true);
        			pdatafile.set("Players." +p.getUniqueId()+".İpaddress", ip1 );
        			
        			pdatafile.save(pdata);
            		}
                  clickedlink(p, 0, "Link 1");
                  clickedlink(p,1,"Link 2");
                inlinenotclickedlink(p,2,"Link 3","11");
             
                    p.openInventory(tikla);
                  connection12.close();
              }else{
                  if(resultSet3.next()){
                      link.put(p, "4");
              		if(pdatafile.getBoolean("Players." +p.getUniqueId()+".L3") == false){
            			int clicks =  pdatafile.getInt("Players." +p.getUniqueId()+".Clicks") + 1;
            			int clickcredit =  pdatafile.getInt("Players." +p.getUniqueId()+".ClickCredit") + 11;
            			pdatafile.set("Players." +p.getUniqueId()+".Clicks", clicks);
            			pdatafile.set("Players." +p.getUniqueId()+".ClickCredit", clickcredit);
            			pdatafile.set("Players." +p.getUniqueId()+".L3", true);
            			pdatafile.set("Players." +p.getUniqueId()+".İpaddress", ip1 );
            			pdatafile.save(pdata);
                		}
                          clickedlink(p, 0, "Link 1");
                          clickedlink(p,1,"Link 2");                       
                          inlinenotclickedlink(p,2,"Link 3","10");
                            p.openInventory(tikla);
                          connection12.close();
                    }else{
                      if(!resultSet3.next()){
                        link.put(p, "4");
                		if(pdatafile.getBoolean("Players." +p.getUniqueId()+".L3") == false){
                			int clicks =  pdatafile.getInt("Players." +p.getUniqueId()+".Clicks") + 1;
                			int clickcredit =  pdatafile.getInt("Players." +p.getUniqueId()+".ClickCredit") + 11;
                			pdatafile.set("Players." +p.getUniqueId()+".Clicks", clicks);
                			pdatafile.set("Players." +p.getUniqueId()+".ClickCredit", clickcredit);
                			pdatafile.set("Players." +p.getUniqueId()+".L3", true);
                			pdatafile.set("Players." +p.getUniqueId()+".İpaddress", ip1 );
                			pdatafile.save(pdata);
                    		}
                            allclickedlink(p, 0, "Link 1");
                            allclickedlink(p,1,"Link 2");
                            allclickedlink(p,2,"Link 3");
                              p.openInventory(tikla);
                            connection12.close();
                      }
                      connection12.close();
                      }
                    connection12.close();
                    }
            }
            connection12.close();
          }
             connection12.close();
          
          
               
        } catch (SQLException | IOException e) {
      
          e.printStackTrace();
        }   
           
     spawner(p);
     legendarysupricechest(p);
     supricechest(p);
     effect(p);

     creditinfo(p);
      //////bilgi//////
      ItemStack tikla1b = new ItemStack(Material.ENCHANTED_BOOK,1);
        List<String> Fsb = new ArrayList<String>();
        Fsb.add(ChatColor.GREEN + "10 Tane Linkin Hepsine Tikladiğinizda Ödül Menusune Erişim Sağlarsiniz!");
        Fsb.add(ChatColor.GREEN + "Ödul Menusunden Ödulleri alabilir ve 1 Gün geçerli Raskele bir");
        Fsb.add(ChatColor.GREEN+  "Partikul Efektine Erişim Sağlarsiniz!");
        Fsb.add(ChatColor.GREEN + "Üstelik Her Gün Bunu tekrarlayarak bedava eşya ve");
        Fsb.add(ChatColor.GREEN +  "1 günlük partikul efekte sahip olabilirsin");
        Fsb.add(ChatColor.GREEN + "Tek Yapman Gereken Menudeki Tiklanmamiş yerlere tiklayip ");
        Fsb.add(ChatColor.GREEN +   "sohbette verilen Linke girip Reklami geçmek!");
        Fsb.add(ChatColor.GREEN + "Daha Fazla Bilgi için Wiki Sitemizi Ziyaret Edin!");
        Fsb.add(ChatColor.GOLD + "www.racialfactor.com");
        ItemMeta imsb = tikla1b.getItemMeta();
        imsb.setDisplayName(ChatColor.LIGHT_PURPLE + "Bilgi Kitabi");
        imsb.setLore(Fsb);
        tikla1b.setItemMeta(imsb);
      tikla.setItem(36, tikla1b);
      /////bilgi/////
    }
    
  return false;


}
 public void message1(Player player,String link134){
	 player.closeInventory();
	    sohbet.put(player, Boolean.TRUE);
	    player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");     
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");     
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage("    ");
	     player.sendMessage(ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=");
	     player.sendMessage(ChatColor.WHITE + "=" + ChatColor.BLUE + " Merhaba " + ChatColor.YELLOW + player.getName());
	     player.sendMessage(ChatColor.DARK_RED + "=" + ChatColor.LIGHT_PURPLE + " Lütfen Aşağidaki Linke Tikla!");
	     player.sendMessage(ChatColor.WHITE + "=" + ChatColor.YELLOW + " Link: " + ChatColor.AQUA + link134 );         
	  player.sendMessage(ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=");
	   player.sendMessage("    ");
	   player.sendMessage("    ");
	   
	  

	        
	          player.sendMessage(ChatColor.GRAY + ">>>>>" + ChatColor.RED + "Sohbet Kapatildi Sohbeti Aktif etmek için Bişiy yaz!" + ChatColor.GRAY + "<<<<<");


 }
 @EventHandler
 public void move(PlayerMoveEvent event) throws MissingParticleException{
	 Player player = event.getPlayer();
	 
	 if(effect1.get(player)==null){
		 return;
	 }
	 if(effect1.get(player).contains(ChatColor.DARK_RED+"Kapali")  ){
		 return;
	 }
	 if (pdatafile.getString("Players." +player.getUniqueId()+".Effectselect")== null){
		 return;
	 }
	 if (pdatafile.getString("Players." +player.getUniqueId()+".Effectselect").contains("VILLAGER_ANGRY")){
		  ParticleMaker maker = new ParticleMaker(ParticleMaker.Particle.VILLAGER_ANGRY, 2, 1.0);
 maker.sendToLocation(player.getLocation());
		 
	 }else
		 if (pdatafile.getString("Players." +player.getUniqueId()+".Effectselect").contains("HEART")){
			  ParticleMaker maker = new ParticleMaker(ParticleMaker.Particle.HEART, 2, 1.0);
	 maker.sendToLocation(player.getLocation());
			 
		 }else
			 if (pdatafile.getString("Players." +player.getUniqueId()+".Effectselect").contains("LAVA")){
				  ParticleMaker maker = new ParticleMaker(ParticleMaker.Particle.LAVA, 2, 1.0);
		 maker.sendToLocation(player.getLocation());
				 
			 }
	 
 }

 
 
 @EventHandler
  public boolean join(PlayerJoinEvent event) throws IOException{
	  Player p1 = event.getPlayer();
	 String ip1 = p1.getAddress().getAddress().getHostAddress();
	   
	  String a = "empty";

	
		 effect1.put(p1, ChatColor.DARK_RED+"Kapali");
        
if(!pdatafile.isSet("Players." + p1.getUniqueId())) {
int click1 = 0;
		  pdatafile.set("Players." +p1.getUniqueId()+".Player NickN", p1.getName());
		  pdatafile.set("Players." +p1.getUniqueId()+".İpaddress", ip1 );
		  pdatafile.set("Players." +p1.getUniqueId()+".LastClickedDate", a);
		  pdatafile.set("Players." +p1.getUniqueId()+".Clicks", click1);
		  pdatafile.set("Players." +p1.getUniqueId()+".ClickCredit", click1);
		  pdatafile.set("Players." +p1.getUniqueId()+".Effectselect", "----");
		  pdatafile.set("Players." +p1.getUniqueId()+".effect", false);
		  pdatafile.set("Players." +p1.getUniqueId()+".L1", false);
		  pdatafile.set("Players." +p1.getUniqueId()+".L2", false);
		  pdatafile.set("Players." +p1.getUniqueId()+".L3", false);
	 	  pdatafile.set("Players." +p1.getUniqueId()+".LastClickLink", a);
	      pdatafile.save(pdata);
	 }
return false;

 



}
  
 //////////////////////////
public void click1b(Player player, String d1,String d2,String d3,String d4,String d5) throws IOException{

		
	
	
Random dice1 = new Random();         
      int number1 = dice1.nextInt(5);
      switch (number1)
      {
      case 0: 
    	  message1(player,d1);
    	  
    	  pdatafile.set("Players." +player.getUniqueId()+".LastClickLink", d1);
    		
    	  pdatafile.save(pdata);
    	  try {
    			
              Connection connection123;
              connection123 = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"
                      + database, username, password);
              Statement s42 = connection123.createStatement();
              
              String ip2 = player.getAddress().getAddress().getHostAddress();
              if(getConfig().getBoolean("link-tl-activate") == true){
            	 String R11 =  d1.replaceAll("http://link.tl/", "http://link.tl/fly/go.php?to=");
            	 String R1 =  R11.replaceAll("http://ouo.io/", "http://ouo.io/go/");

            	  s42.executeUpdate("UPDATE clickandearn SET link = '"+R1+"' WHERE ipadress= '"+ip2+"';");

              }else{
             s42.executeUpdate("UPDATE clickandearn SET link = '"+d1+"' WHERE ipadress= '"+ip2+"';");

              }
              
              connection123.close();
            } catch (SQLException e) {            
              e.printStackTrace();
            }

        
    
      break;
      case 1:

    	  pdatafile.set("Players." +player.getUniqueId()+".LastClickLink", d2);
    	  pdatafile.save(pdata);
    	  message1(player,d2);
    	  
    	  try {
    			
              Connection connection123;
              connection123 = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"
                      + database, username, password);
              Statement s42 = connection123.createStatement();
              String ip2 = player.getAddress().getAddress().getHostAddress();
              if(getConfig().getBoolean("link-tl-activate") == true){
             	 String R11 =  d2.replaceAll("http://link.tl/", "http://link.tl/fly/go.php?to=");
             	 String R1 =  R11.replaceAll("http://ouo.io/", "http://ouo.io/go/");
            	  s42.executeUpdate("UPDATE clickandearn SET link = '"+R1+"' WHERE ipadress= '"+ip2+"';");

              }else{
             s42.executeUpdate("UPDATE clickandearn SET link = '"+d2+"' WHERE ipadress= '"+ip2+"';");

              }
       
                     connection123.close();
            } catch (SQLException e) {            
              e.printStackTrace();
            } 
      	
      break;
      case 2: 
    	  pdatafile.set("Players." +player.getUniqueId()+".LastClickLink", d3);
    	  pdatafile.save(pdata);
    message1(player,d3);
    try {
    			
              Connection connection123;
              connection123 = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"
                      + database, username, password);
              Statement s42 = connection123.createStatement();
              
              String ip2 = player.getAddress().getAddress().getHostAddress();
              if(getConfig().getBoolean("link-tl-activate") == true){
             	 String R11 =  d3.replaceAll("http://link.tl/", "http://link.tl/fly/go.php?to=");
             	 String R1 =  R11.replaceAll("http://ouo.io/", "http://ouo.io/go/");
            	  s42.executeUpdate("UPDATE clickandearn SET link = '"+R1+"' WHERE ipadress= '"+ip2+"';");

              }else{
             s42.executeUpdate("UPDATE clickandearn SET link = '"+d3+"' WHERE ipadress= '"+ip2+"';");

              }
                              connection123.close();
            } catch (SQLException e) {            
              e.printStackTrace();
            }
      	
      break;
      case 3: 
    	  
    	  pdatafile.set("Players." +player.getUniqueId()+".LastClickLink", d4); 
    	  pdatafile.save(pdata);
    		message1(player,d4);
    	  try {
    		  
              Connection connection123;
              connection123 = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"
                      + database, username, password);
              Statement s42 = connection123.createStatement();
              
              String ip2 = player.getAddress().getAddress().getHostAddress();
              if(getConfig().getBoolean("link-tl-activate") == true){
             	 String R11 =  d4.replaceAll("http://link.tl/", "http://link.tl/fly/go.php?to=");
             	 String R1 =  R11.replaceAll("http://ouo.io/", "http://ouo.io/go/");
            	  s42.executeUpdate("UPDATE clickandearn SET link = '"+R1+"' WHERE ipadress= '"+ip2+"';");

              }else{
             s42.executeUpdate("UPDATE clickandearn SET link = '"+d4+"' WHERE ipadress= '"+ip2+"';");

              }
                              connection123.close();
            } catch (SQLException e) {            
              e.printStackTrace();
            }
      break;
      case 4: 
    	  pdatafile.set("Players." +player.getUniqueId()+".LastClickLink", d5);
    	  pdatafile.save(pdata);
    		message1(player,d5);
    	  try {
    		  
              Connection connection123;
              connection123 = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"
                      + database, username, password);
              Statement s42 = connection123.createStatement();
              
              String ip2 = player.getAddress().getAddress().getHostAddress();
              if(getConfig().getBoolean("link-tl-activate") == true){
             	 String R11 =  d5.replaceAll("http://link.tl/", "http://link.tl/fly/go.php?to=");
             	 String R1 =  R11.replaceAll("http://ouo.io/", "http://ouo.io/go/");
            	  s42.executeUpdate("UPDATE clickandearn SET link = '"+R1+"' WHERE ipadress= '"+ip2+"';");

              }else{
             s42.executeUpdate("UPDATE clickandearn SET link = '"+d5+"' WHERE ipadress= '"+ip2+"';");

              }
                              connection123.close();
            } catch (SQLException e) {            
              e.printStackTrace();
            } 
          
      }
}
  
@EventHandler
  public void onInventoryClick(InventoryClickEvent event) throws SQLException, IOException, MissingParticleException {
  final Player player = (Player) event.getWhoClicked(); 
  ItemStack clicked = event.getCurrentItem(); 
  Inventory inventory = event.getInventory(); 


  if (inventory.getName().equals(tikla.getName())) {
	  event.setCancelled(true);
    if (event.getCurrentItem() != null &&clicked.getType() == Material.MAGMA_CREAM) {      
    
  if(clicked.hasItemMeta()&&clicked.getItemMeta().getDisplayName().equals(ChatColor.YELLOW +"Link "+link.get(player))){
	  if(clicked.getItemMeta().getDisplayName().equals(ChatColor.YELLOW +"Link 1")){
		
		  
	    		if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link1_1){		
	    			
	    			message1(player, link1_1);
	    			return;
	    		}else
	    			if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link1_2){		
		    			message1(player,link1_2);
		    			return;		    		
	    		}
	    			else
		    			if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link1_3){		
			    			message1(player,link1_3);
			    			return;		    		
		    		}else
		    			if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link1_4){		
			    			message1(player,link1_4);
			    			return;		    		
		    		}else
		    			if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link1_5){		
			    			message1(player,link1_5);
			    			return;		    		
		    		}else{
		    		  click1b(player, link1_1, link1_2, link1_3, link1_4, link1_5);	
		    		}
	    		
	    	//config ekle	
				
		
	  }else
     if(clicked.getItemMeta().getDisplayName().equals(ChatColor.YELLOW +"Link 2")){
 		if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link2_1){		
			message1(player,link2_1);
			return;
		}else
			if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link2_2){		
    			message1(player,link2_2);
    			return;		    		
		}
			else
    			if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link2_3){		
	    			message1(player,link2_3);
	    			return;		    		
    		}else
    			if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link2_4){		
	    			message1(player,link2_4);
	    			return;		    		
    		}else
    			if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link2_5){		
	    			message1(player,link2_5);
	    			return;		    		
    		}else{
    		  click1b(player, link2_1, link2_2, link2_3, link2_4, link2_5);	
    		}
     }else
     if(clicked.getItemMeta().getDisplayName().equals(ChatColor.YELLOW +"Link 3")){
  		if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link3_1){		
 			message1(player,link3_1);
 			return;
 		}else
 			if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link3_2){		
     			message1(player,link3_2);
     			return;		    		
 		}
 			else
     			if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link3_3){		
 	    			message1(player,link3_3);
 	    			return;		    		
     		}else
     			if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link3_4){		
 	    			message1(player,link3_4);
 	    			return;		    		
     		}else
     			if(pdatafile.getString("Players." +player.getUniqueId()+".LastClickLink") == link3_5){		
 	    			message1(player,link3_5);
 	    			return;		    		
     		}else{
     		  click1b(player, link3_1, link3_2, link3_3, link3_4, link3_5);	
     		}	
     }
     
       
		}   
    }
 
 
  
   if (event.getCurrentItem() != null &&clicked.getType() == Material.JACK_O_LANTERN) { 
	   if(clicked.hasItemMeta()&&clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Supriz Efekt " +ChatColor.DARK_GREEN+"Açik")){
		   effect1.put(player, ChatColor.DARK_RED+"Kapali");	
		     creditinfo(player);
		   effect(player);
		   spawner(player);
	   }else
	if(clicked.hasItemMeta()&&clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Supriz Efekt " +ChatColor.DARK_RED+"Kapali")){
		 if(pdatafile.getBoolean("Players." +player.getUniqueId()+".effect") == true){
			 effect1.put(player, ChatColor.DARK_GREEN+"Açik");
		 }
		  
		 effect(player);
		 int clickcredit2 =  pdatafile.getInt("Players." +player.getUniqueId()+".ClickCredit") -10;
		if(pdatafile.getBoolean("Players." +player.getUniqueId()+".effect") == false){
			
		
		 if(pdatafile.getInt("Players." +player.getUniqueId()+".ClickCredit") > 10){
			 
		
		 
	
			 effect1.put(player, ChatColor.DARK_GREEN+"Açik");
       
	     			
	     			
	     			pdatafile.set("Players." +player.getUniqueId()+".ClickCredit", clickcredit2);
	     			pdatafile.save(pdata);
	     			 	 effect(player);
		
		 Random dice1 = new Random();         
	      int number1 = dice1.nextInt(3);
	 	 
	      switch (number1)
	      {
	      case 0: 
	    	  pdatafile.set("Players." +player.getUniqueId()+".Effectselect", "VILLAGER_ANGRY");  		
			  pdatafile.set("Players." +player.getUniqueId()+".effect", true);
			  pdatafile.save(pdata);
	      break;
	      case 1:
	    	  pdatafile.set("Players." +player.getUniqueId()+".Effectselect", "HEART");
			  pdatafile.set("Players." +player.getUniqueId()+".effect", true);
			  pdatafile.save(pdata);
	      break;
	      case 2: 
	    	  pdatafile.set("Players." +player.getUniqueId()+".Effectselect", "LAVA");
			  pdatafile.set("Players." +player.getUniqueId()+".effect", true);
			  pdatafile.save(pdata);
	      }
		
	 
	
	   }else{
		   if(pdatafile.getBoolean("Players." +player.getUniqueId()+".effect") == false){
			   		   player.sendMessage(ChatColor.RED+"Yeterli Bakiyeniz Yok Lütfen Link Tiklayarak Bakiye Elde Eldin!");
		   player.closeInventory();
		   }
	   }
	   }
  }
   }
   if (event.getCurrentItem() != null &&clicked.getType() == Material.ENCHANTED_BOOK) { 
	   
  }
   if (event.getCurrentItem() != null &&clicked.getType() == Material.MOB_SPAWNER) { 
 	   if(clicked.hasItemMeta()&&clicked.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Supriz Spawner!")){
   		  if(pdatafile.getInt("Players." +player.getUniqueId()+".ClickCredit") > 69){
   			 if(!(player.getInventory().firstEmpty() == -1)){           		   
   			 int clickcredit2 =  pdatafile.getInt("Players." +player.getUniqueId()+".ClickCredit") -70;	 
   			pdatafile.set("Players." +player.getUniqueId()+".ClickCredit", clickcredit2);
     			pdatafile.save(pdata);	 Random dice1 = new Random();         
     		      int number1 = dice1.nextInt(16);
     		      
     		     switch (number1)
     		      {
     		      case 0: 
     		    	  //domuzspawneri
     		    	  System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
     		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" pig 1");
     		      break;
     		      case 1:
     		    	  //inek spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" cow 1");
     		      break;
     		      case 2: 
     		    	  //tavuk spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" chicken 1");
     		    	 break;
     		      case 3:
     		    	 //mushroom cow spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" Mooshroom 1");
     		    	 break;
     		      case 4:
     		    	  //koyun spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" sheep 1");
     		    	 break;
     		      case 5:
     		    	  //ocelot spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" ocelot 1");
     		    	 break;
     		      case 6:
     		    	  //zombie pigman spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" zombiepigman 1");
     		    	 break;
     		      case 7:
     		    	  //zombi spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" zombie 1");
     		    	 break;
     		      case 8:
     		    	  //creeper spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" creeper 1");
     		    	 break;
     		      case 9:
     		    	  //örumcek spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" spider 1");
     		    	 break;
     		      case 10:
     		    	  //enderman spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" enderman 1");
     		    	 break;
     		      case 11:
     		    	  //skeleton spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" skeleton 1");
     		    	 break;
     		      case 12:
     		    	  //mağara örumceği
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" cavespider 1");     		    	 break;
     		      case 13:
     		    	  //slime spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" slime 1");
     		    	 break;
     		      case 14:
     		    	 //blaze spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" blaze 1");;
     		    	 break;
     		      case 15:
     		    	 //magma cube spawneri
     		    	 System.out.println("Oyuncu"+player.getName()+"Tikla kazandan Spawner aldi:" );
      		    	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ss give " + player.getName()+" magmacube 1");
     		      }
     			supricechest(player);
     			legendarysupricechest(player);
     			creditinfo(player);
       			effect(player);
   			 }else{
   				 player.sendMessage(ChatColor.RED+"Lütfen Envanterinizi Boşaltiniz!");
   				 player.closeInventory();
   			 }
     		
   		  }else{
   			 player.sendMessage(ChatColor.RED+"Yeterli Bakiyeniz Yok Lütfen Link Tiklayarak Bakiye Elde Eldin!");
   			   player.closeInventory();
   		  }
   	   }
  }
  
    if (event.getCurrentItem() != null &&clicked.getType() == Material.CHEST) { 

 	   if(clicked.hasItemMeta()&&clicked.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Supriz Sandik")){
 			
 		  if(pdatafile.getInt("Players." +player.getUniqueId()+".ClickCredit") > 9){
 			 if(!(player.getInventory().firstEmpty() == -1)){  
 		          ItemStack item5 = new ItemStack(Material.CHEST);
 		          List<String> F5 = new ArrayList<String>();
 		          F5.add(ChatColor.RED + "============Içinden Çikabilecekler=============");
 		          F5.add(ChatColor.GRAY + "Ejderha Nefesi" + ChatColor.GOLD + " Servet 5 Elmas Kazma" + ChatColor.GRAY + " Altin 64-32 ");
 		          F5.add(ChatColor.GOLD + "Ipeksi Dokunuş Elmas Kazma" + ChatColor.GOLD + " Elmas 32-16" + ChatColor.GRAY + ChatColor.GOLD + " Demir 64 veya 64+64");
 		          F5.add(ChatColor.GRAY + "Sponge" + ChatColor.GOLD + " Supriz Xp Sandiği" + ChatColor.GRAY + " Supriz Pro Set Sandiği ");
 		          F5.add(ChatColor.GOLD  +" Kömur 64+64+64");
 		          F5.add(ChatColor.RED + "==========================================");
 		          ItemMeta im5 = item5.getItemMeta();
 		          im5.setDisplayName(ChatColor.AQUA + "Supriz Sandik");
 		          im5.setLore(F5);
 		          item5.setItemMeta(im5);           		   
 			 int clickcredit2 =  pdatafile.getInt("Players." +player.getUniqueId()+".ClickCredit") -10;	 
 			pdatafile.set("Players." +player.getUniqueId()+".ClickCredit", clickcredit2);
 		   	 player.getInventory().addItem(new ItemStack(item5));
   			pdatafile.save(pdata);
   			spawner(player);
   			supricechest(player);
   			legendarysupricechest(player);
   			creditinfo(player);
   			effect(player);
 			 }else{
 				 player.sendMessage(ChatColor.RED+"Lütfen Envanterinizi Boşaltiniz!");
 				 player.closeInventory();
 			 }
   		
 		  }else{
 			 player.sendMessage(ChatColor.RED+"Yeterli Bakiyeniz Yok Lütfen Link Tiklayarak Bakiye Elde Eldin!");
 			   player.closeInventory();
 		  }
 	   }
 	   if(clicked.hasItemMeta()&&clicked.getItemMeta().getDisplayName().equals(ChatColor.RED + "Efsanevi Supriz Sandik")){
			
  		  if(pdatafile.getInt("Players." +player.getUniqueId()+".ClickCredit") > 29){
  			 if(!(player.getInventory().firstEmpty() == -1)){  
  		          ItemStack item5 = new ItemStack(Material.CHEST);
  		          List<String> F5 = new ArrayList<String>();
  		          F5.add(ChatColor.RED + "============Içinden Çikabilecekler=============");
  		          F5.add(ChatColor.GRAY + "11 Ateşli Silahtan 1 tanesi" + ChatColor.GOLD + " P4 Elmas Set" );
  		          F5.add(ChatColor.GOLD + "Jetpack" +ChatColor.GRAY+"Elytra"+ChatColor.GOLD+"Bomba Creeper");      
  		          F5.add(ChatColor.RED + "==========================================");
  		          ItemMeta im5 = item5.getItemMeta();
  		          im5.setDisplayName(ChatColor.RED + "Efsanevi Supriz Sandik");
  		          im5.setLore(F5);
  		          item5.setItemMeta(im5);          		   
  			 int clickcredit2 =  pdatafile.getInt("Players." +player.getUniqueId()+".ClickCredit") -30;	 
  			pdatafile.set("Players." +player.getUniqueId()+".ClickCredit", clickcredit2);
  		   	 player.getInventory().addItem(new ItemStack(item5));
    			pdatafile.save(pdata);
    			spawner(player);
    			supricechest(player);
    			legendarysupricechest(player);
    			creditinfo(player);
      			effect(player);
  			 }else{
  				 player.sendMessage(ChatColor.RED+"Lütfen Envanterinizi Boşaltiniz!");
  				 player.closeInventory();
  			 }
    		
  		  }else{
  			 player.sendMessage(ChatColor.RED+"Yeterli Bakiyeniz Yok Lütfen Link Tiklayarak Bakiye Elde Eldin!");
  			   player.closeInventory();
  		  }
  	   }

 	   
 	   
  }
  

}
} 



} 



 