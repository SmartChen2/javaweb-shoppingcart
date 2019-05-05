
package filter;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements javax.servlet.Filter {

		private String adg;
		public EncodingFilter() {
		
		}
		public void destroy() {
		
		}
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			request.setCharacterEncoding(this.adg);
			response.setCharacterEncoding(this.adg);
			chain.doFilter(request, response);
		}
		public void init(FilterConfig fcg) throws ServletException {
			this.adg=fcg.getInitParameter("encoding");
		}
}