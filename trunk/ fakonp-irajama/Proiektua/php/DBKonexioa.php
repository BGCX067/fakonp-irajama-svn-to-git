<?php
class DBKonexioa{
	var $konexioa;
	var $izena;
	var $host;
	var $user;
	var $pwd;
	function DBKonexioa(){
		$this->izena = "php_labo";
		$this->host="127.0.0.1";
		$this->user = "root";
		$this->pwd = "euiti";
	}

	function konektatu() {
		if(!($kon=@mysql_connect($this->host, $this->user,$this->pwd))){
			die("Errorea. Ezin da datubasera konektatu.");
			return false;
		}
		if (!@mysql_select_db($this->izena,$kon)){
			die("Errorea datubasea aukeratzean.");
			return false;
		}
		$this->konexioa=$kon;
		return true;
	}

    function konexioaItxi(){
        mysql_close($this->konexioa);
    }
}
?>