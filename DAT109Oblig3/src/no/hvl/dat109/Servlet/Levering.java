package no.hvl.dat109.Servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import no.hvl.dat109.EAO.AvfallsplassEAO;
import no.hvl.dat109.EAO.BrukarEAO;
import no.hvl.dat109.EAO.LeveringsoversiktEAO;
import no.hvl.dat109.EAO.ProduktEAO;
import no.hvl.dat109.Entity.Avfallsplass;
import no.hvl.dat109.Entity.Avfallstype;
import no.hvl.dat109.Entity.Brukar;
import no.hvl.dat109.Entity.Leveringsoversikt;
import no.hvl.dat109.Entity.Produkt;
import no.hvl.dat109.hjelpeklasser.Melding;
import no.hvl.dat109.hjelpeklasser.Meldingstype;

/**
 * Servlet implementation class Levering
 */
@WebServlet("/levering")
public class Levering extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	BrukarEAO brukarEAO;
	
	@EJB
	AvfallsplassEAO	avfallsplassEAO;
	
	@EJB
	LeveringsoversiktEAO leveringsoversiktEAO;
	
	@EJB
	ProduktEAO produktEAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Levering() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String telefon = request.getParameter("telefonnr");
		Brukar brukar = brukarEAO.hentBrukar(telefon);
		
		int avfalssplassID = Integer.parseInt(request.getParameter("avfallsplassID"));
		
		Avfallsplass avfallsplass = avfallsplassEAO.hentAvfallsplass(avfalssplassID);
		Melding melding;
		
		if (avfallsplass != null) {
			melding = new Melding(Meldingstype.ProduktForLeveringOK);
			List<Avfallstype> type = avfallsplass.getAvfallstypes();
			
			List<Leveringsoversikt> produktTilLevering = leveringsoversiktEAO.hentProduktForLevering(brukar, type);
			
			produktTilLevering.forEach(x -> x.getProdukt().getAvfallstypeBean().setAvfallsplasses(null));
			
			
			melding.setProduktTilLevering(produktTilLevering);
		}else {
			melding = new Melding(Meldingstype.FEIL);
		}
		

		
		Gson gson = new GsonBuilder()
		        .excludeFieldsWithoutExposeAnnotation()
		        .create();
		
		
//		historikk.forEach((x) -> x.getProduktBean().getAvfallstypeBean().setAvfallsplasses(null));
		//produkt.getAvfallstypeBean().getAvfallsplasses().forEach(p -> p.setAvfallstypes(null));
		
		response.getWriter().append(gson.toJson(melding));
		
		
//		finn leveringsoversikter som ikkje er levert p� den 
//		aktuelle brukaren, og som har produkttype som kan leverast p� avfallsplassID? 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String[] leveringsoversikter = request.getParameterValues("leveringsoversiktId");
		
		List<String> leveringsoversiktID = Arrays.asList(leveringsoversikter);
		
		List<Leveringsoversikt> leverteLeveringsoversikt = leveringsoversiktEAO.hentProduktListe(leveringsoversiktID);
		Melding melding;
		
		if(leverteLeveringsoversikt.size() > 0) {
			leveringsoversiktEAO.leverProdukt(leverteLeveringsoversikt);
			melding = new Melding(Meldingstype.ProduktLevert);
		}else {
			melding = new Melding(Meldingstype.IngenProdukt);
		}
		
		Gson gson = new GsonBuilder()
		        .excludeFieldsWithoutExposeAnnotation()
		        .create();
		
		response.getWriter().append(gson.toJson(melding));
	}

}
