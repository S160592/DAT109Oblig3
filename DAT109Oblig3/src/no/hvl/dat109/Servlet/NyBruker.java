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
import no.hvl.dat109.Entity.Brukar;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;
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
		
		String telefon = request.getParameter("telefon"); // for test "81549300"
		String fornavn = request.getParameter("fornavn"); // For test "Ole"
		String etternavn = request.getParameter("etternavn"); // for test "Doffen"
		String passord = request.getParameter("passord"); // for test "qwer1234"
		String passordRepetert = request.getParameter("passordRepetert"); // for test "qwer1234"
		Melding melding;
		System.out.println("ny brukar");
		//1.Valider input(om alt e fylt ut)
		
		//2.Valider om bruker finst fr� f�r
		if(brukarEAO.hentBrukar(telefon) != null) {
			melding = new Melding(Meldingstype.BrukarFinst);
		}else {
			
		
		
		//3.Valider om passord e like
		
		//4a.Om alt er ok:
		
		melding = new Melding(Meldingstype.RegistreringOK);

		Brukar brukar = new Brukar();
		brukar.setEtternavn(etternavn);
		brukar.setFornavn(fornavn);
		brukar.setPassord(passord);
		brukar.setTelefon(telefon);
		brukarEAO.lagreNyBrukar(brukar);
		InnloggingUtil.loggInn(request);
		//5a. Logge inn brukaren
		
		}
		
		//4b.Om alt ikkje er ok:
		//Send riktig feilmelding
//		
		Gson gson = new GsonBuilder()
		        .excludeFieldsWithoutExposeAnnotation()
		        .create();
//		
		response.getWriter().append(gson.toJson(melding));
	
	}

}
