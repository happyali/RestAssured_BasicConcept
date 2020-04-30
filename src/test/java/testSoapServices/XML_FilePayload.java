package testSoapServices;

import java.io.File;
import java.io.FileInputStream;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.util.IOUtils;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.*;
import junit.framework.Assert;

public class XML_FilePayload {

	@Test
	public void sendXMLpayload() throws Exception {
	
		File xmlsrc=new File("./Resources/SoapRequestData/convertCurrency.xml");
			// To convert the file into Raw Data
			FileInputStream xmlfis = new FileInputStream(xmlsrc);
			
			RestAssured.baseURI="http://currencyconverter.kowabunga.net";
			Response resp=RestAssured
					.given()
						.header("Content-Type", "text/xml")
						.and()
						.body(IOUtils.toByteArray(xmlfis))
					.when()
						.post("/converter.asmx")
					.then()
						.statusCode(200)
						.and()
						.log().all().extract().response();
			XmlPath xmlpath =new XmlPath(resp.asInputStream());
			String rate=xmlpath.getString("GetConversionRateResult");
			
			System.out.println("rate is :"+rate);
	}

}