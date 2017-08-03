package dev.sgp.filtre;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.util.Constantes;

public class FrequentationFilter implements Filter {

	private FilterConfig config = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		config.getServletContext().log("statistiques initialized");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		VisiteWeb vis = new VisiteWeb();
		
		/**
		 * If I introduce this line after the chain.dofilter
		 * it won't work as it will give the answer (jsp)files 
		 * to get the real link 
		 */
		vis.setChemin(((HttpServletRequest) request).getRequestURI());
		long before=System.currentTimeMillis();
		chain.doFilter(request, response);
		long after=System.currentTimeMillis();
		
		
		vis.setTempsExecution(after-before);
		
	
		Constantes.WEB_SERVICE.sauvegarderVisite(vis);

		
	}

	@Override
	public void destroy() {


	}

}
