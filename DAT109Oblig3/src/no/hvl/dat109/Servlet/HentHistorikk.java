package no.hvl.dat109.Servlet;

import java.io.IOException;
import java.util.List;

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
import no.hvl.dat109.Entity.Brukar;
import no.hvl.dat109.Entity.Leveringsoversikt;
import no.hvl.dat109.Entity.Produkt;
import no.hvl.dat109.hjelpeklasser.Melding;
import no.hvl.dat109.hjelpeklasser.Meldingstype;

/**
 * Servlet implementation class getHistorikk
 */
@WebServlet("/hentHistorikk")
public class HentHistorikk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	LeveringsoversiktEAO leveringsoversiktEAO;
	
	@EJB
	BrukarEAO brukarEAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HentHistorikk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF8");
		
		String telefon = request.getParameter("telefon");
		Melding melding;
		
		Brukar brukar = brukarEAO.hentBrukar(telefon);
		
		List<Leveringsoversikt> historikk = leveringsoversiktEAO.hentHistorikk(brukar);
		
		if(historikk == null) {
			melding = new Melding(Meldingstype.TomHistorikk);
		}else {
			melding = new Melding(Meldingstype.HistorikkOK); 
			melding.setLeveringsoversikt(historikk);
		}
		
		Gson gson = new GsonBuilder()
		        .excludeFieldsWithoutExposeAnnotation()
		        .create();
		

		//produkt.getAvfallstypeBean().getAvfallsplasses().forEach(p -> p.setAvfallstypes(null));
		
		response.getWriter().append(gson.toJson(melding));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
