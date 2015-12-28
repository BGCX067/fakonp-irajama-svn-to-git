<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../css/estiloak.css"></link>
		<script type="text/javascript" src="../js/nagusia.js"></script>
	</head>
	
	<body>
		<form name="formu" action="" method="POST" enctype="multipart/form-data">
		<p>
<?php session_start();
if(isset($_SESSION['web_erabiltzaile'])) { ?> Kaixo <?php echo $_SESSION['web_erabiltzaile']; ?> !!!
<input type="button" name="deslogeatuBotoia" value="Irten!" onclick="deslogeatu();"></input> <?php } else {?>Nor zara?
<input type="text" name="webErabiltzaile" value=""></input>
<input type="password" name="pasahitza" value=""></input>
<input type="button" name="logeatuBotoia" value="Sartu!" onclick="logeatu();"></input> <?php } ?>
</p>
		
			<!-- Taula dinamikoa -->
			<h2><u>Taula dinamikoa</u></h2>
			<p>[Datubasetik dator taularen informazioa.]</p>
			<table id="dinamikoa">
				<tr>
					<th></th>
					<th>Izena</th>
					<th>Argazkia</th>
					<th>Testua</th>
				</tr>
				
				
				<!-- PHP hasiera -->
				<?php
				// PHP kodea hasten da
				
				// DBKonexioa klasea importatu.
				include("DBKonexioa.php");
				
				// Konexio objetua sortu
            	$konexioa = new DBKonexioa();
				
            	if($konexioa->konektatu()!=true){
					die ("Errorea DBra konektatzen saiatzean.");
				} else {
					$sql = "SELECT * FROM erabiltzailea";
					$emaitzak = mysql_query($sql);
					if (mysql_num_rows($emaitzak) > 0) {								
						
						$i = 0; // Lerroak zenbatzeko
						
						while($lerroa = mysql_fetch_assoc($emaitzak)) {
							// Taularen tr eta td-ak osatu		
							// lerroa bikoitia bada estiloa aldatuko diot, bestela ez					
							if( $i % 2 == 0) {
					  			echo "<tr class=\"alt\">"; // estiloa aldatzeko class="alt"
							} else {
								echo "<tr>";
							}
							echo "	<td>";
							//Radio bakoitzari value moduan DBko gakoa ipiniko diogu
							echo "		<input type=\"radio\" name=\"radio\" value=\"$lerroa[iderabiltzailea]\" onclick=\"gaituBotoiak();\">";
							echo "	</td>";
							echo "	<td>";
							echo "		<a href=\"$lerroa[emaila]\">$lerroa[izena] $lerroa[abizenak]</a>";
							echo "	</td>";
							echo "	<td>";
							echo "		<img src=\"../img/$lerroa[argazkia]\">";
							echo "	</td>";
							echo "	<td>$lerroa[testua]</td>";
							echo "</tr>";							
							$i++; // lerro zenbatzaileari 1 gehitu
					  	}
					}
					//Datubase konexioa itxi
					$konexioa->konexioaItxi();
				}
			  	
							
				// PHP bukaera
				?>
				
				<!-- PHP amaiera -->
								
			</table>
			
			<!-- Taula dinamikoaren botoiak -->
			<table>
				<tr>
					<td>
						<input type="button" value="Erabiltzailea ezabatu" id="botoiBorratu" onclick="borratu();" disabled/>
					</td>
					<td>PHPren bidez ezabatuko dugu DBtik eta orria berriro kargatuko dugu.</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="Erabiltzailea sortu" onclick="sortu();"/>
					</td>
					<td>PHPren bidez erabiltzailea DBan sartuko dugu eta orria berriro kargatuko dugu.</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="Erabiltzailea aldatu" id="botoiAldatu" onclick="aldatu();" disabled/>
					</td>
					<td>PHPren bidez DBko erabiltzailea aldatuko dugu eta orria berriro kargatuko dugu.</td>
				</tr>
			
			</table>
			
			<!-- Hutsune bat usteko -->
			<p></p>
			
			<!-- Input hau erabiliko dugu erabiltzaile bat borratzerakoan jakiteko zein den borratu beharreko gakoa (aukeratutako radioaren balioa) -->
			<input type="hidden" name="gakoa" value=""></input>
			
			
			<!-- Hutsune bat usteko -->
			<p></p>
			<!--datuak sartzeko izkutaturik dagoen formularioa -->
<p>

<fieldset class="izkutu" id="erabiltzailedatuak">
<legend>Erabiltzaile berriaren datuak</legend>
<table>
<tr>
<td>Izena:</td>
<td>
<input type="text" value="" name="txtIzena">
</td>
</tr>
<tr>
<td>Abizenak:</td>
<td>
<input type="text" value="" name="txtAbizenak">
</td>
</tr>
<tr>
<td>Emaila:</td>
<td>
<input type="text" value="" name="txtEmaila">
</td>
</tr>
<tr>
<td>Argazkia:</td>
<td>
<input type="file" value="" name="txtArgazki"
onchange="argazkiLuzapenaKonprobatu(this);">
</td>
</tr>
<tr>
<td>Testua:</td>
<td>
<textarea cols="20" rows="2" name="txtTestua">Hemen idatzi</textarea>
</td>
</tr>
<tr>
<td>
<input type="button" value="Onartu" onclick="onartuSortu();"/>
<input type="button" value="Utzi" onclick="utziSortu();"/>
</td>
</tr>
</table>
</fieldset>
</p>
			
			
			<!-- Taula estatikoa -->
			<h2><u>Taula estatikoa</u></h2>
			<p>[Kodean bertan dator taularen informazioa, orrian sartzean beti berdina ikusiko da.]</p>
			<table id="estatikoa">
			<tr>
				<th>Izena</th>
				<th>Argazkia</th>
				<th>Testua</th>
			</tr>
			<tr>
			<td><a href="mailto:irene@gmail.com">Irene Bilbao</a></td>
			<td><img src="../img/irene.jpg"></td>
			<td>Ireneri dagokion testu adibidea</td>
			</tr>
			<tr class="alt">
			<td><a href="mailto:irati@gmail.com">Irati Agirre</a></td>
			<td><img src="../img/irati.jpg"></td>
			<td>Iratiri dagokion testu adibidea</td>
			</tr>
			<tr>
			<td><a href="mailto:idoia@gmail.com">Idoia Benito</a></td>
			<td><img src="../img/idoia.jpg"></td>
			<td>Idoiari dagokion testu adibidea</td>
			</tr>
			</table>
		
		
		</form>
	</body>
</html>