package org.strotmann.metals

// necessary components are imported

import org.apache.http.HttpEntity
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import org.json.JSONObject

public class KurseHoler{

    // essential URL structure is built using constants
    def String BASE_URL = "https://api.edelmetalle.de/"
    def String ENDPOINT = "public.json"
	
    // this object is used for executing requests to the (REST) API
    def CloseableHttpClient httpClient = HttpClients.createDefault()
		
	JSONObject exchangeRates = exRates()
			
	JSONObject exRates () {
		// The following line initializes the HttpGet Object with the URL in order to send a request
		HttpGet gApi = new HttpGet(BASE_URL + ENDPOINT)
		CloseableHttpResponse resp
		try {
			resp =  httpClient.execute(gApi)
		} catch (Exception e) {
			e.printStackTrace()
		}
		HttpEntity entity = resp.getEntity()
		// the following line converts the JSON Response to an equivalent Java Object
		JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity))			
		return exchangeRates	
	}
	
	BigDecimal EuroJeDollar () {
		Double quotes = exchangeRates.getDouble("wechselkurs_usd_eur")
		BigDecimal kurs = 1/quotes.toBigDecimal()
		kurs
	}
	
	BigDecimal DollarJeUnze (String m) {
		Map konv = ["au":"gold", "ag":"silber", "pl":"platin", "pd":"palladium",]
		Double quotes = exchangeRates.getDouble("${konv[m]}"+"_usd")
		BigDecimal kurs = quotes.toBigDecimal()
		kurs
	}
}
