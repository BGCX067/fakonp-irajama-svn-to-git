
<?php
				// PHP kodea hasten da
				
				// DBKonexioa klasea importatu.
				include("DBKonexioa.php");
				
				// Konexio objetua sortu
            	$konexioa = new DBKonexioa();
				
            	if($konexioa->konektatu()!=true){
					die ("Errorea DBra konektatzen saiatzean.");
				} else {
					$gakoa = $_POST["gakoa"];
					$sql = "DELETE FROM erabiltzailea WHERE iderabiltzailea=$gakoa";
					$emaitzak = mysql_query($sql);
					
					
					//Datubase konexioa itxi
					$konexioa->konexioaItxi();
					header("Location: nagusia.php");
					
				}
			  	
							
				// PHP bukaera
				?>