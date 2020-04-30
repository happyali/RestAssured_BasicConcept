package testSoapServices;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;

public class XML_HttpConnection {

		
	@Test
	public void sendXML_SOAP_Data() {

		// Service under test can be found @ http://currencyconverter.kowabunga.net/converter.asmx?op=GetConversionRate

		try {
			 String url = "http://currencyconverter.kowabunga.net/converter.asmx?op=GetConversionRate";
			 URL obj = new URL(url);
			 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			 con.setRequestMethod("POST");
			 con.setRequestProperty("Content-Type","text/xml; charset=utf-8");
			 String fromCurrency="USD";
			 String toCurrency="INR";
			 
			 // For xml string, we need to replace all " with \" and then remove the next line parameter from the payload to makeup a single string
			 // Use notepad to replace " --> \"
			 // Use https://www.textfixer.com/tools/remove-line-breaks.php to remove next line.
			 String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"> <soap12:Body> <GetConversionRate xmlns=\"http://tempuri.org/\"> <CurrencyFrom>"+fromCurrency+"</CurrencyFrom> <CurrencyTo>"+toCurrency+"</CurrencyTo> <RateDate>2020-04-26T00:00:00</RateDate> </GetConversionRate> </soap12:Body> </soap12:Envelope>";
			 con.setDoOutput(true);
			 DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			 wr.writeBytes(xml);
			 wr.flush();
			 wr.close();
			 String responseStatus = con.getResponseMessage();
			 System.out.println(responseStatus);
			 BufferedReader in = new BufferedReader(new InputStreamReader(
			 con.getInputStream()));
			 String inputLine;
			 StringBuffer response = new StringBuffer();
			 while ((inputLine = in.readLine()) != null) {
			 response.append(inputLine);
			 }
		 
		 in.close();
		 System.out.println("response:" + response);//.toString());
		 XmlPath xmlpath =new XmlPath(response.toString());//asInputStream());
		 String rate=xmlpath.getString("GetConversionRateResult");
		 System.out.println("rate is :"+rate);
		 
		 } catch (Exception e) {
			 System.out.println(e);
		 }
 	}
}