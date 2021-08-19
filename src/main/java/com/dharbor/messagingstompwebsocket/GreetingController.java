package com.dharbor.messagingstompwebsocket;

import com.dharbor.messagingstompwebsocket.model.Cryptobet;
import com.dharbor.messagingstompwebsocket.model.History;
import com.dharbor.messagingstompwebsocket.model.Winbet;
import com.dharbor.messagingstompwebsocket.repository.CryptoBetRepository;
import com.dharbor.messagingstompwebsocket.repository.HistoryRepository;
import com.dharbor.messagingstompwebsocket.repository.WinBetRepository;
import com.dharbor.messagingstompwebsocket.model.Winner;

import com.dharbor.messagingstompwebsocket.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.ListIterator;

import static java.lang.Math.abs;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		String vt = "Logic";
		String vBet = "";

		History history = new History();
		history.setName(HtmlUtils.htmlEscape(message.getName()));
		history.setBet(HtmlUtils.htmlEscape(message.getBet()));
		history.setCycle(String.valueOf(MessagingStompWebsocketApplication.gCycle));
		String vTime = String.valueOf(java.time.LocalDateTime.now());
		history.setStamp(vTime);
		createJpaHistory(history);

		Cryptobet cryptobet = new Cryptobet();
		cryptobet.setName(HtmlUtils.htmlEscape(message.getName()));
		cryptobet.setBet(HtmlUtils.htmlEscape(message.getBet()));
		cryptobet.setStamp(vTime);
		cryptobet.setPrice(MessagingStompWebsocketApplication.gPrice);
		cryptobet.setCycle(String.valueOf(MessagingStompWebsocketApplication.gCycle));
		cryptobet.setWin(false);
		cryptobet.setOpen(true);
		createJpaCryptoBet(cryptobet);

		return new Greeting("FROM|" + HtmlUtils.htmlEscape(message.getName()) + "|" + vt + "|" + vTime);
	}

	@Autowired
	HistoryRepository historyRepository;

	public void createJpaHistory(History history) {
		try {

			History historyUpdate = historyRepository
					.save(new History(history.getName(), history.getBet(), history.getStamp(), history.getCycle()));
		} catch (Exception e) {
		}
	}

	@Autowired
	CryptoBetRepository cryptoBetRepository;

	public void createJpaCryptoBet(Cryptobet cryptobet) {
		try {
			Cryptobet cryptobetUpdate = cryptoBetRepository
					.save(new Cryptobet(cryptobet.getName(), cryptobet.getBet(), cryptobet.getStamp(), cryptobet.getPrice(), cryptobet.getCycle(), cryptobet.getWin(), cryptobet.getOpen()));
		} catch (Exception e) {
		}
	}

	@Autowired
	WinnerRepository winnerRepository;

	@GetMapping("/start/cryptoselect")
	@SendTo("/topic/greetings")
	public Greeting cryptoSelect(HelloMessage message) {

		float vBase = 70000f;
		String winnerName = "";
		Winner winnerUpdate = new Winner();
		try {
			int vX = 0;
			List<Cryptobet> cryptoSelect = cryptoBetRepository.findAll();
			int vN = cryptoSelect.size();
			ListIterator iT = cryptoSelect.listIterator();
			while( vX < vN ) {
				Cryptobet cr = cryptoSelect.get(vX);
				float vBet = Float.valueOf(cr.getBet());
				float vPrice = Float.valueOf(MessagingStompWebsocketApplication.gPrice);
				float vDiff = abs(vBet-vPrice);
				if (vDiff < vBase ) {
					winnerName = cr.getName();
					winnerUpdate.setBet(cr.getBet());
					winnerUpdate.setStamp(cr.getStamp());
					winnerUpdate.setCycle(cr.getCycle());
					winnerUpdate.setPrice(cr.getPrice());
					winnerUpdate.setName(winnerName);
					winnerUpdate.setOpen(true);
					vBase = vDiff;
				}
				vX++;
			}

			if (vN != 0) {
				Winner winnerNew = winnerRepository
						.save(new Winner(winnerUpdate.getName(), winnerUpdate.getBet(), winnerUpdate.getStamp(),winnerUpdate.getPrice(), winnerUpdate.getCycle(), winnerUpdate.getOpen()));
				cryptoBetRepository.deleteAll();
			}


		} catch (Exception e) {
			System.out.print(e.getMessage() + " ERROR ");
		}
		return new Greeting("FROM|");
	}


	@Autowired
	WinBetRepository winBetRepository;

	@GetMapping("/start/now")
	@SendTo("/topic/greetings")
	public Greeting createInitGame(HelloMessage message) {
		long nID = 0l;
		Winbet winbet = new Winbet();
		winbet.setPrice(MessagingStompWebsocketApplication.gPrice);
		winbet.setOpen(false);
		try {
			Winbet winBetUpdate = winBetRepository
					.save(new Winbet(winbet.getName(), winbet.getBet(), winbet.getStamp(), winbet.getPrice(), winbet.getOpen()));
			MessagingStompWebsocketApplication.gCycle = winBetUpdate.getID();

		} catch (Exception e) {
			System.out.print(e.getMessage()+" ERROR ");
		}
		return new Greeting("FROM|" + HtmlUtils.htmlEscape("" + "|" + "vt" + "|" + "vTime"));
	}

}
