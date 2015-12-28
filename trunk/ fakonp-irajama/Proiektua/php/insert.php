
<?php

// PHP kodea hasten da
//Gure argazkiak duen izen tenporala hartuko dugu
$tenporala = $_FILES['txtArgazki']['tmp_name'];
//Irudiaren izena hartuko dugu
$irudia = $_FILES['txtArgazki']['name'];
//Argazkiaren izena eta luzapena lortu
$irudia1 = explode(".",$irudia);
//izen aleatorio bat sortu zenbakiekin, eta luzapena gehitu
$irudia2 = rand(0,9).rand(100,9999).rand(100,9999).".".$irudia1[1];
//Zerbitzarira igoko dugu
move_uploaded_file($tenporala, "/home/euiti/lanlekua/PHP_Laborategia/img/".$irudia2);

//Baimenak eman argazkiari
$ruta="/home/euiti/lanlekua/PHP_Laborategia/img/".$irudia2;
chmod($ruta, 0777);	
				// DBKonexioa klasea importatu.
				include("DBKonexioa.php");
				
				// Konexio objetua sortu
            	$konexioa = new DBKonexioa();
				
            	if($konexioa->konektatu()!=true){
					die ("Errorea DBra konektatzen saiatzean.");
				} else {
			
					$izena=$_POST["txtIzena"];
					$abizena=$_POST["txtAbizenak"];
					$emaila=$_POST["txtEmaila"];
					$argazkia=$irudia2;
					$testua=$_POST["txtTestua"];	
					
					$sql = "INSERT INTO erabiltzailea (izena, abizenak, emaila, argazkia, testua) VALUES  ('$izena', '$abizena', '$emaila', '$argazkia', '$testua')";
					
					$emaitza = mysql_query($sql);
					//Datubase konexioa itxi
					$konexioa->konexioaItxi();
					if($emaitza!=true){
						die ("Errorea insert egitean.");
					} else {
						header("Location: nagusia.php");
					}
				}

		// PHP bukaera
				?>
