<?php
if(isset($_REQUEST['Submit'])){
    $xml = new DOMDocument("1.0", "UTF-8");
    $xml->load("patient_details.xml");
    $rootTag = $xml->getElementsByTagName("root")->item(0);
    $dataTag = $xml->createElement("data");
    $nameTag = $xml->createElement("name", $_REQUEST['name']);
    $ageTag = $xml->createElement("age", $_REQUEST['age']);
    $genderTag = $xml->createElement("gender", $_REQUEST['gender']);
    
    $dataTag->appendChild($nameTag);
    $dataTag->appendChild($ageTag);
    $dataTag->appendChild($genderTag);

    $rootTag->appendChild($dataTag);


    

    $xml->save("patient_details.xml");
    }
?>