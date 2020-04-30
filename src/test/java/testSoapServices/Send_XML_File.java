package testSoapServices;

import java.io.File;
import java.io.FileInputStream;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.util.IOUtils;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.*;

public class Send_XML_File {

	@Test
	public void sendXMLpayload() throws Exception {
		System.out.println("================= The TEST is running as per Class: " + this.getClass().getName()+" ==============");
		
		File src=new File("./SoapRequestData/convertCurrency.xml");
			// To convert the file into Raw Data
			FileInputStream fis = new FileInputStream(src);
			
			RestAssured.baseURI="http://currencyconverter.kowabunga.net";
			Response resp=RestAssured
					.given()
						.header("Content-Type", "text/xml")
						.and()
						.body(IOUtils.toByteArray(fis))
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
