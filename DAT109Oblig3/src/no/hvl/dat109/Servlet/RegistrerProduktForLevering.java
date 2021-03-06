package no.hvl.dat109.Servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import no.hvl.dat109.EAO.BrukarEAO;
import no.hvl.dat109.EAO.LeveringsoversiktEAO;
import no.hvl.dat109.EAO.ProduktEAO;
import no.hvl.dat109.Entity.Brukar;
import no.hvl.dat109.Entity.Leveringsoversikt;
import no.hvl.dat109.Entity.Produkt;
import no.hvl.dat109.hjelpeklasser.Melding;
import no.hvl.dat109.hjelpeklasser.Meldingstype;

/**
 * Servlet implementation class RegistrerProduktForLevering
 */
@WebServlet("/registrerProduktForLevering")
public class RegistrerProduktForLevering extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	LeveringsoversiktEAO leveringsoversiktEAO;
	
	@EJB
	BrukarEAO brukarEAO;
	
	@EJB
	ProduktEAO produktEAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrerProduktForLevering() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strekkode = request.getParameter("strekkode");
		String telefon = request.getParameter("telefon");
		
		Brukar brukar = brukarEAO.hentBrukar(telefon);
		Produkt produkt = produktEAO.hentProdukt(strekkode);
		
		Leveringsoversikt leveringsoversikt = new Leveringsoversikt();
		leveringsoversikt.setProdukt(produkt);	
		leveringsoversikt.setBrukar(brukar);
		leveringsoversikt.setLevert(false);
		leveringsoversiktEAO.addLeveringsoversikt(leveringsoversikt);
	
		
		Melding melding = new Melding(Meldingstype.RegistreringOK);
		
		Gson gson = new GsonBuilder()
		        .excludeFieldsWithoutExposeAnnotation()
		        .create();
		
		response.getWriter().append(gson.toJson(melding));
	}

}
