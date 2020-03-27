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

import no.hvl.dat109.Interfaces.BrukarEAOInterface;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;
import no.hvl.dat109.hjelpeklasser.Melding;
import no.hvl.dat109.hjelpeklasser.Meldingstype;


/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	BrukarEAOInterface brukerEAO;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String telefon = request.getParameter("telefon"); // for test "81549300"
		String passord = request.getParameter("passord"); // for test "qwer1234"
		Melding melding;
		
		//1.Valider telefon
		if(brukerEAO.hentBrukar(telefon) != null) {
			melding = new Melding(Meldingstype.LoginOK);
			InnloggingUtil.loggInn(request);
		}else {
			melding = new Melding(Meldingstype.BrukarFinnastIkkje);
		}
		//2.Valider passord
		
		//3.Sende tilbake en melding i Json-format
		Gson gson = new GsonBuilder()
		        .excludeFieldsWithoutExposeAnnotation()
		        .create();
		
		response.getWriter().append(gson.toJson(melding));
		
		//4.Lage sesjon?
		
		
	}

}
