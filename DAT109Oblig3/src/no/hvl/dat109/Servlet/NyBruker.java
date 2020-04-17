package no.hvl.dat109.Servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import no.hvl.dat109.EAO.BrukarEAO;
import no.hvl.dat109.Entity.Brukar;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;
import no.hvl.dat109.hjelpeklasser.InputValidering;
import no.hvl.dat109.hjelpeklasser.Melding;
import no.hvl.dat109.hjelpeklasser.Meldingstype;

/**
 * Servlet implementation class NyBruker
 */
@WebServlet("/nybruker")
public class NyBruker extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	@EJB
	BrukarEAO brukarEAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NyBruker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HashMap<String,String> inputdata = new HashMap<String,String>();
		inputdata.put("telefon", request.getParameter("telefon"));
		inputdata.put("fornavn", request.getParameter("fornavn"));
		inputdata.put("etternavn", request.getParameter("etternavn"));
		inputdata.put("passord", request.getParameter("passord"));
		inputdata.put("passordRepetert", request.getParameter("passordRepetert"));

		InputValidering validering = new InputValidering(inputdata);
		HashMap<String,String> validated_data = validering.validerNyBrukar();
		
		Melding melding;
		System.out.println("ny brukar");

		if(validering.erGyldig()) {
		
			//2.Valider om bruker finst fr� f�r
			if(brukarEAO.hentBrukar(validated_data.get("telefon")) != null) {
				melding = new Melding(Meldingstype.BrukarFinst);
			} else {	
				//4a.Om alt er ok:
				melding = new Melding(Meldingstype.RegistreringOK);
		
				Brukar brukar = new Brukar();
				brukar.setEtternavn(validated_data.get("etternavn"));
				brukar.setFornavn(validated_data.get("fornavn"));
				brukar.setPassord(validated_data.get("passord"));
				brukar.setTelefon(validated_data.get("telefon"));
				brukarEAO.lagreNyBrukar(brukar);
				InnloggingUtil.loggInn(request);
			}
		
		} else { // feil i input
			melding = new Melding(Meldingstype.FEIL);
			melding.setFeilmeldingar(validering.getFeilmeldingar());
		}

		Gson gson = new GsonBuilder()
		        .excludeFieldsWithoutExposeAnnotation()
		        .create();
		
		response.getWriter().append(gson.toJson(melding));
	}

}
