<?php
// http://adf.ly/J5xdi  kismi dişinda değişiklik yapilmasina izin yoktur. Tum Haklari Saklidir.
$ipaddress = $_SERVER["REMOTE_ADDR"];
$ref = $_SERVER['HTTP_REFERER'];
if (strpos($ref, 'http://adf.ly/tgCiG') !== FALSE) {
	$de = str_replace(".","",$ipaddress);
	$baglanti = mysql_connect( "mysql.hostinger.web.tr", "u636894480_root", "123456" );
    mysql_select_db( "u636894480_joint", $baglanti);
	$sql = "ALTER TABLE jointopay ADD `$de` VARCHAR(60);";
	$b=mysql_query($sql,$baglanti);
if ($b)
{
}
mysql_close($baglanti);
    ?>
    <body background="Basari.png">
    	
 <strong>By djyee</strong>  
    </body>           
    <?php
} else {
    ?>
    <body background="iptal.png">
 <strong>By djyee</strong>  
 </body>
<?php
}
?>
