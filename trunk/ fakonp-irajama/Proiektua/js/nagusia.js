

function argazkiLuzapenaKonprobatu(fileArgazki){
	
	argazki = fileArgazki.value;
	onartuak = new Array(".gif", ".jpg", ".png");
	if (argazki != "") {
		luzapena = (argazki.substring(argazki.lastIndexOf("."))).toLowerCase();
		onartuta = false;
      		for (var i = 0; i < onartuak.length; i++) {
         		if (onartuak[i] == luzapena) {
			        onartuta = true;
			        break;
		         }
      		}
		if (!onartuta) {
			alert(luzapena + " luzapena ez da egokia.");
			fileArgazki.value="";			
		}
	}
}

function sortu() {
	document.getElementById("erabiltzailedatuak").className = "ezizkutu";
}

function gaituBotoiak() {
	document.getElementById("botoiBorratu").disabled = false;
	document.getElementById("botoiAldatu").disabled = false;
}

function utziSortu() {
	document.formu.txtIzena.value = "";
	document.formu.txtAbizenak.value = "";
	document.formu.txtEmaila.value = "";
	document.formu.txtArgazki.value = "";
	document.formu.txtTestua.value = "";	
	document.getElementById("erabiltzailedatuak").className = "izkutu";
}

function onartuSortu() {
	
	if(balioztatuSortu()){		
		document.getElementById("erabiltzailedatuak").className = "izkutu";
		document.formu.action = "insert.php";
		document.formu.submit();
		
	} else {
		alert('Eremu guztiak bete behar dira erabiltzaile berria sortzeko');
	}	
}

function balioztatuSortu(){
	if(document.formu.txtIzena.value!="" && document.formu.txtAbizenak.value!="" && document.formu.txtEmaila.value!="" && document.formu.txtArgazki.value!="" && document.formu.txtTestua.value!="") {
		return true;
	} else {
		return false;
	}
	
}

function borratu() {
	
	
	for(i=0; i<document.formu.radio.length; i++) {
		if(document.formu.radio[i].checked == true) {
			document.formu.gakoa.value = document.formu.radio[i].value;
			document.formu.action = "delete.php";
			document.formu.submit();
			return 0;
		}
	}
	alert('Erabiltzaile bat aukeratu behar duzu.');
		
}

function aldatu() {
	
	
	for(i=0; i<document.formu.radio.length; i++) {
		if(document.formu.radio[i].checked == true) {
			document.formu.gakoa.value = document.formu.radio[i].value;
			document.formu.action = "aldatuErabiltzailea.php";
			document.formu.method = "GET";
			document.formu.submit();
			return 0;
		}
	}
	alert('Erabiltzaile bat aukeratu behar duzu.');
		
}
function logeatu() {
	if (document.formu.webErabiltzaile.value != "" &&
	document.formu.pasahitza.value != "") {
	document.formu.action = "login.php";
	document.formu.method = "POST";
	document.formu.submit();
	return 0;
	}
	alert('Erabiltzailea eta pasahitza sartu behar duzu.');
	}
function deslogeatu() {
	document.formu.action = "logout.php";
	document.formu.method = "POST";
	document.formu.submit();
	alert("Agurrr!!!");
	}


