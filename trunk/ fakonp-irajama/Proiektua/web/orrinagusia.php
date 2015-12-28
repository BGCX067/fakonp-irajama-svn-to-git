
<html> 
<head>
	<title>Proiektua</title>
<script language="javascript" type="text/javascript" src="../js/skripta.js">
// Beste aparteko fitx batetan=> <script language="javascript" src="nireskripta.js>
// Hemen gure Javascript kodea kokatuko dugu
function reseteatu() {
document.formularioa.emaila.value="";
document.formularioa.pasahitza.value="";
}
function balioztatu() {
//*-dun eremuak betetzea derrigorrezkoa da.
if(document.formularioa.emaila.value == "" || document.formularioa.pasahitza.value == "" ) {
	alert("*-dun eremuak bete behar dira");
	return false;
	}

}

function agurtu(agurra){
alert(agurra);
}

</script>
</head>




<body onLoad="agurtu('Kaixo, ongi etorri!!')" onUnload="agurtu('Agur!!!!!')">
<form name="formularioa">
<p>
<fieldset style="border-color: #00FF00; width:550">
<legend>  Erabiltzailea identifikatu </legend>
<table>
<p>
	<tr>
	
		<td>Emaila*:</td>
		<td><input type="text" name="emaila" value=""/></td>
		<td>Pasahitza*:</td>
		<td><input type="text" name="pasahitza" value=""/></td>
		<td><input type="submit" value="OK!" onclick="identifikatu();"/></td>
		<td><input type="button" value="Reset" onclick="reseteatu();"/></td>
	</tr>
</p>

<p>
	<tr>

</br>
		<td><input type="submit" value="Enpresa berria" onclick="enpresaErregistratu();"/></td>
		<td><input type="submit" value="Bezero berria" onclick="bezeroaErregistratu();"/></td>
	</tr>	
</p>		

</table>
</legend>
</p>


</form>
<?php 
$db_host = '127.0.0.1';
$db_user = 'root';
$db_pwd ='euiti';
$datubasea = 'deskontplan';
$konexioa = new mysqli($db_host,$db_user,$db_pwd, $datubasea);
$emaitzak= $konexioa->query("SELECT * FROM Eskaintza WHERE Data???= GAUR?????");
echo "<table border='1'>";
echo "<tr>";
echo "<th>Argazkia</th>";
echo "<th>Deskribapena</th>";
echo "<th>Prezioa</th>";
echo "<th>Info gehiago</th>";
echo "</tr>";


while ($lerroa = $emaitzak->fetch_array(MYSQLI_ASSOC)){
	echo "<tr>";
	echo "<td align="center"><img src=\"../img/$lerroa[argazkia]\" height=\"80\"\"/></td>";
	echo "<td align="center">$lerroa[deskribapena]</td>";
	echo "<td align="center">$lerroa[prezioa]</td>";
	echo "<td align="center"> <a href="/html/infoGehiago.html">informazio gehiago</a> </td>";
	echo "</tr>";	
}





echo "</table>";
mysql_free_result($rs);
mysql_close();
?>

</body>
</html>