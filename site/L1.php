<?php
$servername = "194.169.211.12";//your mysql server adress
$username = "ni412926_2sql1";//your mysql server user name 
$password = "6.6708E57";// your mysql password
$dbname = "ni412926_2sql1"; // your database name
$link1 = "http://link.tl/fly/go.php?to=ImUp";//here comes link 1
$link2 = "http://link.tl/fly/go.php?to=JnmP";//here comes link 2
$link3 = "http://link.tl/fly/go.php?to=JnmQ";//here comes link 3
$link4 = "http://link.tl/fly/go.php?to=JnmS";//here comes link 4
$link5 = "http://link.tl/fly/go.php?to=JnmT";//here comes link 5
$ipaddress = $_SERVER["REMOTE_ADDR"];
$ref = $_SERVER["HTTP_REFERER"];
$date = date("d-m-Y");
$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 






if (strpos($ref, $link1) !== FALSE) {
$sql = "UPDATE clickandearn SET L1='true' WHERE ipadress='".$ipaddress."';";
$query = mysqli_query($conn, "SELECT * FROM clickandearn WHERE link='".$link1."' and ipadress='".$ipaddress."';");

if(mysqli_num_rows($query) > 0){

if (mysqli_query($conn, $sql)) {
    echo "Success!";
	    ?>
    <body background="Basari.png">
    	
 <strong>By djyee</strong>  
    </body>           
    <?php
} else {
    echo "Hata: " . $sql . "<br>" . $conn->error;
    echo $ipaddress;
}

}else{

	echo "Tiklanan link Doğru Değil!11";
	      ?>
    <body background="iptal.png">
 <strong>By djyee</strong>  
 </body>
<?php 
	
	}

}else{
	
	echo "Tiklanan link Doğru Değil!";
	      ?>
    <body background="iptal.png">
 <strong>By djyee</strong>  
 </body>
<?php 
	
	}
if (strpos($ref, $link2) !== FALSE) {
$sql = "UPDATE clickandearn SET L1='true' WHERE ipadress='".$ipaddress."';";
$query = mysqli_query($conn, "SELECT * FROM clickandearn WHERE link='".$link2."' and ipadress='".$ipaddress."';");

if(mysqli_num_rows($query) > 0){

if (mysqli_query($conn, $sql)) {
    echo "Success!";
	    ?>
    <body background="Basari.png">
    	
 <strong>By djyee</strong>  
    </body>           
    <?php
} else {
    echo "Hata: " . $sql . "<br>" . $conn->error;
    echo $ipaddress;
}

}else{

	echo "Tiklanan link Doğru Değil!11";
	      ?>
    <body background="iptal.png">
 <strong>By djyee</strong>  
 </body>
<?php 
	
	}

}else{
	
	echo "Tiklanan link Doğru Değil!";
	      ?>
    <body background="iptal.png">
 <strong>By djyee</strong>  
 </body>
<?php 
	
	}
	
if (strpos($ref, $link3) !== FALSE) {
$sql = "UPDATE clickandearn SET L1='true' WHERE ipadress='".$ipaddress."';";
$query = mysqli_query($conn, "SELECT * FROM clickandearn WHERE link='".$link3."' and ipadress='".$ipaddress."';");

if(mysqli_num_rows($query) > 0){

if (mysqli_query($conn, $sql)) {
    echo "Success!";
	    ?>
    <body background="Basari.png">
    	
 <strong>By djyee</strong>  
    </body>           
    <?php
} else {
    echo "Hata: " . $sql . "<br>" . $conn->error;
    echo $ipaddress;
}

}else{

	echo "Tiklanan link Doğru Değil!11";
	      ?>
    <body background="iptal.png">
 <strong>By djyee</strong>  
 </body>
<?php 
	
	}

}else{
	
	echo "Tiklanan link Doğru Değil!";
	      ?>
    <body background="iptal.png">
 <strong>By djyee</strong>  
 </body>
<?php 
	
	}
if (strpos($ref, $link4) !== FALSE) {
$sql = "UPDATE clickandearn SET L1='true' WHERE ipadress='".$ipaddress."';";
$query = mysqli_query($conn, "SELECT * FROM clickandearn WHERE link='".$link4."' and ipadress='".$ipaddress."';");

if(mysqli_num_rows($query) > 0){

if (mysqli_query($conn, $sql)) {
    echo "Success!";
	    ?>
    <body background="Basari.png">
    	
 <strong>By djyee</strong>  
    </body>           
    <?php
} else {
    echo "Hata: " . $sql . "<br>" . $conn->error;
    echo $ipaddress;
}

}else{

	echo "Tiklanan link Doğru Değil!11";
	      ?>
    <body background="iptal.png">
 <strong>By djyee</strong>  
 </body>
<?php 
	
	}

}else{
	
	echo "Tiklanan link Doğru Değil!";
	      ?>
    <body background="iptal.png">
 <strong>By djyee</strong>  
 </body>
<?php 
	
	}

if (strpos($ref, $link5) !== FALSE) {
$sql = "UPDATE clickandearn SET L1='true' WHERE ipadress='".$ipaddress."';";
$query = mysqli_query($conn, "SELECT * FROM clickandearn WHERE link='".$link5."' and ipadress='".$ipaddress."';");

if(mysqli_num_rows($query) > 0){

if (mysqli_query($conn, $sql)) {
    echo "Success!";
	    ?>
    <body background="Basari.png">
    	
 <strong>By djyee</strong>  
    </body>           
    <?php
} else {
    echo "Hata: " . $sql . "<br>" . $conn->error;
    echo $ipaddress;
}

}else{

	echo "Tiklanan link Doğru Değil!11";
	      ?>
    <body background="iptal.png">
 <strong>By djyee</strong>  
 </body>
<?php 
	
	}

}else{
	
	echo "Tiklanan link Doğru Değil!";
	      ?>
    <body background="iptal.png">
 <strong>By djyee</strong>  
 </body>
<?php 
	
	}

$conn->close();

?>