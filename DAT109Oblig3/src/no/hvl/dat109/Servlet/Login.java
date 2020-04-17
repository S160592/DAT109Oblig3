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
import no.hvl.dat109.Entity.Produkt;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;
import no.hvl.dat109.hjelpeklasser.InputValidering;
import no.hvl.dat109.hjelpeklasser.Melding;
import no.hvl.dat109.hjelpeklasser.Meldingstype;


/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	BrukarEAO brukarEAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		inputdata.put("passord", request.getParameter("passord"));
		
		InputValidering validering = new InputValidering(inputdata);
		HashMap<String,String> validated_data = validering.validerLogInn();
		
		Melding melding = null;
		
		if(validering.erGyldig()) {
			Brukar brukar = brukarEAO.hentBrukar(validated_data.get("telefon"));
			
			// Godkjent innlogging
			if(brukar != null && brukar.getPassord().equals(validated_data.get("passord"))) { 
				melding = new Melding(Meldingstype.LoginOK);
				InnloggingUtil.loggInn(request);
			} else { // ikkje godkjent
				melding = new Melding(Meldingstype.BrukarFinnastIkkje);
			}
			
		} else {
			melding = new Melding(Meldingstype.FEIL);
			melding.setFeilmeldingar(validering.getFeilmeldingar());
		}
		
		// Sende tilbake melding i Json-format
		Gson gson = new GsonBuilder()
		        .excludeFieldsWithoutExposeAnnotation()
		        .create();
		
		response.getWriter().append(gson.toJson(melding));		
	}
}
