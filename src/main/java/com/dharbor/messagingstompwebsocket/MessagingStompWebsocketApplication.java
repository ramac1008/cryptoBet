package com.dharbor.messagingstompwebsocket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MessagingStompWebsocketApplication {

	public static long gCycle;
	public static String gPrice;
	public static boolean gOpen;

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(MessagingStompWebsocketApplication.class, args);

		while (true) {
			System.out.print("going");
			gPrice  = getKryptoPrice();
			gOpen   = true;

			getInitCycle();

			Thread.sleep(36000);
			getFinCycle();

			gOpen   = false;


		}
	}

	private static String getKryptoPrice() {

		final String uri = "https://api.nomics.com/v1/currencies/ticker?key=65896f7f61d5c538c14e8ba993f154866e5ffc69&ids=BTC&interval=1m";

		String vPriceN = "";
		String vPriceDate = "";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		try {
			assert result != null;

			JSONArray jsonArray = new JSONArray(result);
			JSONObject jsonObjectRet = jsonArray.getJSONObject(0);
			String vPriceS = jsonObjectRet.getString("price");
			vPriceDate = jsonObjectRet.getString("price_date");

			//String[] vPriceA = vPriceS.split(".");
			vPriceN = vPriceS;

		} catch (JSONException err) { }

		return (vPriceN);

	}

	private static String getInitCycle() {
		try {
			final String uri = "http://127.0.0.1:8080/start/now";

			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(uri, String.class);

		} catch (Exception err) { }

		return ("OK");
	}

	private static String getFinCycle() {
		try {
			final String uri = "http://localhost:8080/start/cryptoselect";

			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(uri, String.class);

		} catch (Exception err) { }

		return ("OK");
	}

}
